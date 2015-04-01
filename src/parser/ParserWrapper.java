package parser;

import java.sql.SQLException;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import checker.DB;
import checker.Policy;

import relation.Column;
import relation.ColumnMetadata;
import relation.ColumnOptMetadata;
import relation.Counters;
import relation.Index;
import relation.Op;
import relation.OpAgg;
import relation.OpAlias;
import relation.OpExcept;
import relation.OpGroup;
import relation.OpHaving;
import relation.OpJoin;
import relation.OpProject;
import relation.OpWhere;
import relation.Operation;
import relation.Relation;
import relation.SQLUtils;
import relation.UnaryOperation;
import utils.DataLawyerException;
import utils.MyLogger;

public class ParserWrapper {

	public static Relation convertASTtoRelation(Tree tree) throws SQLException,
			DataLawyerException {
		return convertASTtoRelation(tree, Counters.getCounters());
	}

	public static Relation convertASTtoRelation(Tree tree, Counters counters)
			throws SQLException, DataLawyerException {

		Relation output = null;

		if (tree.getChildCount() == 1) {
			output = parseSelect(null, tree, counters);
		} else if (tree.getChildCount() >= 2) {
			boolean processedSelectAggregates = false;
			boolean hasExcept = false;
			Relation exceptRelation = null;
			for (int ichild = 1; ichild < tree.getChildCount(); ++ichild) {
				Tree subtree = tree.getChild(ichild);
				String treetype = subtree.getText().toLowerCase();
				if (treetype.equals("from")) {
					// Adding the from operator.
					output = parseFrom(subtree, counters);
				} else if (treetype.equals("where")) {
					// Adding the where operator.
					output = parseWhere(output, subtree, counters);
				} else if (treetype.equals("group")) {
					// Adding the grouping operator.
					output = parseGroup(output, subtree);
				} else if (treetype.equals("having")) {
					// Adding the aggregation operator.
					output = parseAgg(output, tree.getChild(0), subtree);
					processedSelectAggregates = true;
					output = parseHaving(output, subtree, counters);
				} else if (treetype.equals("except")) {
					hasExcept = true;
					exceptRelation = convertASTtoRelation(subtree, counters);
				} else {
					throw new DataLawyerException("Unexpected parsing structure: "
							+ treetype);
				}
			}
			if (!processedSelectAggregates)
				output = parseAgg(output, tree.getChild(0), null);

			// Adding the project operator.
			output = parseSelect(output, tree.getChild(0), counters);

			// Processing except.
			if (hasExcept)
				output = new OpExcept(output, exceptRelation);

		} else
			throw new IllegalArgumentException("Weird SQL statement!");

		MyLogger.getLog().finest(
				"Parse tree looks as follows:\n" + output.toString());

		return output;
	}

	private static ArrayList<Tree> getAggregations(Tree input)
			throws DataLawyerException {
		ArrayList<Tree> candidates = new ArrayList<Tree>();
		ArrayList<Tree> aggregates = new ArrayList<Tree>();

		if (input.getText().equalsIgnoreCase("select")) {
			for (int iChild = 0; iChild < input.getChildCount(); iChild++)
				if (input.getChild(iChild).getText().equalsIgnoreCase("as"))
					candidates.add(input.getChild(iChild).getChild(0));
				else {
					// TODO: Must do something about this.
					MyLogger.getLog().warning("WARNING: Consider an alias for "
							+ input.getChild(iChild).toStringTree());
					candidates.add(input.getChild(iChild));
				}
		} else if (input.getText().equalsIgnoreCase("having")) {
			ArrayList<Tree> operations = getOperationClauses(input.getChild(0));
			for (Tree operation : operations) {
				candidates.add(operation.getChild(0));
				candidates.add(operation.getChild(1));
			}
		} else
			throw new DataLawyerException(
					"Only having and select clauses can perform aggregation.");

		while (!candidates.isEmpty()) {
			Tree tree = candidates.remove(candidates.size() - 1);
			if (tree.getChildCount() == 1
					&& Operation.IsAggregate(tree.getText()))
				aggregates.add(tree);
			else {
				for (int i = 0; i < tree.getChildCount(); ++i)
					candidates.add(tree.getChild(i));
			}
		}

		return aggregates;
	}

	/**
	 * We have a very crude heuristic here. If we ever make it public, would
	 * need to clean this up.
	 * 
	 * @param input
	 * @return
	 * @throws SQLException
	 * @throws DataLawyerException
	 */
	private static Relation getInputRelation(Tree input, Counters counters,
			boolean aliased) throws SQLException, DataLawyerException {
		String relation_name = input.getText().toLowerCase();
		if (input.getChildCount() == 0) {
			String[] names = DB.getDB().separateSchemaAndName(relation_name);
			Index index = new Index(names[1], names[0], counters);
			if (aliased)
				return new OpAlias(index, "alias_" + index.getId());
			else
				return index;
		} else if (input.getChildCount() == 1) {
			Relation base_relation = getInputRelation(input.getChild(0),
					counters, false);
			return new OpAlias(base_relation, relation_name);
		} else {
			Relation base_query = convertASTtoRelation(input, counters);
			return new OpAlias(base_query, relation_name);
		}
	}

	/**
	 * Checks if one of the columns of the input Relation is identical to the
	 * column represented by the abstract syntax tree representation of a column
	 * (in variable tree of type Tree).
	 * 
	 * @param inputRelation
	 * @param tree
	 * @return The matched Column. If no such Column is found, returns null. If
	 *         more than one matching Columns are found, it throws an exception.
	 * @throws DataLawyerException
	 */
	private static Column getNewColumn(Relation inputRelation, Tree tree)
			throws DataLawyerException {

		if (inputRelation.getColumn(tree) != null)
			throw new DataLawyerException("Can not create duplicate columns.");

		String name = tree.getText();

		Column toRet = null;

		if (ColumnMetadata.IsConstant(name)) {
			ColumnMetadata constColInfo = ColumnMetadata.getConstantColumn(name);
			toRet = new Column(constColInfo, inputRelation.counters);
		} else if (Operation.IsAggregate(name)) {
			// Should never reach here.
			throw new DataLawyerException("Should not have reached here: "
					+ tree.toString());
		} else if (ColumnMetadata.isArithmeticOp(name)) {
			ArrayList<Column> inputs = new ArrayList<Column>();
			for (int i = 0; i < tree.getChildCount(); ++i) {
				Column inputCol = getNewColumnIfRequired(inputRelation,
						tree.getChild(i));
				inputs.add(inputCol);
			}
			toRet = new Column(ColumnMetadata.getDerivedColumn(name, inputs),
					inputRelation.counters);
		} else if (name.equalsIgnoreCase("function")) {
			String funcName = tree.getChild(0).getText();
			// TODO: Check that this function is supported by the database.
			ArrayList<Column> inputs = new ArrayList<Column>();
			for (int i = 1; i < tree.getChildCount(); ++i) {
				Column inputCol = getNewColumnIfRequired(inputRelation,
						tree.getChild(i));
				inputs.add(inputCol);
			}
			toRet = new Column(ColumnMetadata.getDerivedColumn(funcName, inputs),
					inputRelation.counters);
		} else if (name.equalsIgnoreCase("as")) {
			String alias = tree.getChild(1).getText();
			Column aliased = getNewColumnIfRequired(inputRelation,
					tree.getChild(0));
			toRet = Column.getAliasedColumn(null, alias, aliased,
					inputRelation.counters, true);
		} else {
			// Should not reach here. Throwing an exception.
			throw new DataLawyerException("Should not have reached here: "
					+ tree.toString());
		}

		return toRet;
	}

	private static Column getNewColumnIfRequired(Relation input, Tree tree)
			throws DataLawyerException {
		Column toRet = input.getColumn(tree);
		if (toRet == null)
			toRet = getNewColumn(input, tree);
		return toRet;
	}

	private static ArrayList<Tree> getOperationClauses(Tree tree) {
		ArrayList<Tree> operations = new ArrayList<Tree>();
		if (tree.getText().equalsIgnoreCase("and"))
			for (int iChild = 0; iChild < tree.getChildCount(); ++iChild)
				operations.addAll(getOperationClauses(tree.getChild(iChild)));
		else
			operations.add(tree);
		return operations;
	}

	public static void main(String[] args) {
		System.out.println("Testing!");
		try {

			DB.getDB().createLGFs();

//			String src = "SELECT t.qid, t.otid, COUNT(t.itid) AS num_inputs FROM (SELECT p.qid, p.otid, p.itid FROM Provenance p WHERE p.irid = 'd_patients' GROUP BY p.qid, p.otid, p.itid ) AS t GROUP BY t.qid, t.otid HAVING COUNT(t.itid) < 10";
//			String src1 = "SELECT z.qid, z.otid, COUNT(z.itid) AS numin FROM (SELECT p.qid, p.otid, p.itid FROM Provenance p WHERE p.irid = 'd_patients' GROUP BY p.qid, p.otid, p.itid ) AS z GROUP BY z.qid, z.otid HAVING COUNT(z.itid) < 10";

			String src = "select t.bucket, count(t.bucket) AS tot_count from 	(select width_bucket(a.valuenum, 0, 231, 231) AS bucket from 	 labevents as a, ext_labevents_of_interest as b where a.itemid = b.itemid ) as t group by t.bucket";
			
			String policyString = "SELECT 1 FROM ( SELECT p.qid, p.otid FROM Schema s, Provenance p WHERE s.irid = 'd_patients' AND s.qid = p.qid GROUP BY p.qid, p.otid) AS t GROUP BY t.qid HAVING COUNT(t.otid) > 100";
			
			Relation policy = parseSQL(policyString);
			ArrayList<String> logs = new ArrayList<String>();
			// logs.add("provenance"); 
			logs.add("schema");
			System.out.println(SQLUtils.convertToSQL(policy));
			System.out.println(SQLUtils.getPartialPolicies(policy, logs));
			
			System.out.println();
			
			System.out.println(src + "\n");
			Relation query = parseSQL(src);
		//	SQLUtils.addProvenance(query, 1);

			/*
			 * System.out.println(SQLUtils.convertToSQL(query));
			 * System.out.println(SQLUtils.addProvenance(query, 1) + "\n\n");
			 * 
			 * System.out.println(SQLUtils.toStringClassList(SQLUtils
			 * .flatten(query)));
			 */
			
	//		System.out.println(src1 + "\n");
	//		Relation query1 = parseSQL(src1);
	//		System.out.println("Are the two queries logically equivalent? " + SQLUtils.equalityModuloConstants(query, query1));

			Policy.normalizeAsBoolean(query);
			System.out.println("Generated simplified SQL:\n"
					+ SQLUtils.convertToSQL(query));
			System.out.println("Incrementally computable? "
					+ Policy.isIncremental(query, true));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DataLawyerException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting!");
	}

	private static Relation parseAgg(Relation input, Tree select_subtree,
			Tree having_subtree) throws DataLawyerException {
		if (!select_subtree.getText().equalsIgnoreCase("select"))
			throw DataLawyerException.incorrectParseTree("select");
		if (having_subtree != null)
			if (!having_subtree.getText().equalsIgnoreCase("having"))
				throw DataLawyerException.incorrectParseTree("having");

		ArrayList<Tree> aggregations = getAggregations(select_subtree);
		if (having_subtree != null)
			aggregations.addAll(getAggregations(having_subtree));

		Relation output = input;

		// Unlike parseWhere, there might not be any aggregated column.
		if (aggregations.size() > 0) {
			output = new OpAgg(input);
			for (Tree aggregate : aggregations) {
				// We might end up adding duplicate columns (for example through
				// the having clause and through the select clause).
				if (output.getColumn(aggregate) == null) {
					String operation_string = aggregate.getText();
					Column input_col_id = getNewColumnIfRequired(input,
							aggregate.getChild(0));
					ColumnOptMetadata optinfo = input
							.getColumnOptInfo(input_col_id);
					UnaryOperation operation = Operation.getUnary(
							operation_string, input_col_id);
					((OpAgg) output).addOperation(operation, optinfo);
				}
			}
		}

		return output;
	}

	/**
	 * This method parses the 'from' part of the parse tree returned by ANTLR.
	 * 
	 * @param from_subtree
	 * @return
	 * @throws SQLException
	 * @throws DataLawyerException
	 */
	private static Relation parseFrom(Tree from_subtree, Counters counters)
			throws SQLException, DataLawyerException {

		if (!from_subtree.getText().equalsIgnoreCase("from"))
			throw DataLawyerException.incorrectParseTree("from");
		if (from_subtree.getChildCount() == 0)
			throw new DataLawyerException("From clause has no relations.");

		// TODO: Why was alias boolean here 'true'? During policy
		// transformations, it helps. To handle this, make sure that you throw
		// an exception if a user submits a query without aliases.
		Relation input1 = getInputRelation(from_subtree.getChild(0), counters,
				true);

		// If there is just one relation to operate over, return the Index
		// constructed.
		if (from_subtree.getChildCount() == 1)
			return input1;

		Relation input2 = getInputRelation(from_subtree.getChild(1), counters,
				true);

		// Construct an empty join operator.
		OpJoin join = new OpJoin(input1, input2);

		// 1. Iterate over all the relations mentioned in the from clause.
		// 2. Check that those relations exist in the database. If so, add their
		// columns in the columnMetadata object.
		// 3. Add the individual relations as inputs of the join operator.
		for (int iChild = 2; iChild < from_subtree.getChildCount(); ++iChild) {
			Relation input = getInputRelation(from_subtree.getChild(iChild),
					counters, true);
			join.addInput(input);
		}

		return join;
	}

	private static Op parseGroup(Relation input, Tree group_subtree)
			throws DataLawyerException {
		if (!group_subtree.getText().equalsIgnoreCase("group"))
			throw DataLawyerException.incorrectParseTree("group");

		OpGroup group = new OpGroup(input);
		for (int iChild = 0; iChild < group_subtree.getChildCount(); ++iChild) {
			Column col_id = input.getColumn(group_subtree.getChild(iChild));
			if (col_id == null)
				col_id = getNewColumn(input, group_subtree.getChild(iChild));
			group.addGroupingColumn(col_id);
		}
		return group;
	}

	private static Op parseHaving(Relation input, Tree having_subtree,
			Counters counters) throws DataLawyerException {
		if (!having_subtree.getText().equalsIgnoreCase("having"))
			throw DataLawyerException.incorrectParseTree("having");

		// The following is necessary but not sufficient.
		if (!(input instanceof Op))
			throw new DataLawyerException(
					"The having operator must be called on the outcome of another operator.");

		OpHaving having = new OpHaving((Op) input);

		ArrayList<Tree> operations = getOperationClauses(having_subtree
				.getChild(0));
		if (operations.isEmpty())
			throw new DataLawyerException(
					"The having clauses can not be empty, if this method has been invoked.");

		for (Tree operation : operations) {
			String op = operation.getText();

			Column left_col_id = getNewColumnIfRequired(input,
					operation.getChild(0));
			Column right_col_id = getNewColumnIfRequired(input,
					operation.getChild(1));

			if (!ColumnMetadata.allInputsKnown(input, left_col_id))
				throw new DataLawyerException(
						"Parse error in having clause. Accessing a column not in context: "
								+ operation.getChild(0).toString());
			if (!ColumnMetadata.allInputsKnown(input, right_col_id))
				throw new DataLawyerException(
						"Parse error in having clause. Accessing a column not in context: "
								+ operation.getChild(1).toString());

			having.addOperation(
					Operation.getBinary(op, left_col_id, right_col_id), null);
		}

		return having;
	}

	private static Op parseSelect(Relation input, Tree select_subtree,
			Counters counters) throws DataLawyerException {
		if (!select_subtree.getText().equalsIgnoreCase("select"))
			throw DataLawyerException.incorrectParseTree("select");

		OpProject project = new OpProject(input);

		if (select_subtree.getChild(0).getText().equalsIgnoreCase("*")) {
			for (Column c : input.getColumns())
				project.appendColumn(c, new ColumnOptMetadata());
		} else {
			Column c = null;
			for (int i = 0; i < select_subtree.getChildCount(); ++i) {
				try {
					c = getNewColumnIfRequired(input,
							select_subtree.getChild(i));
				} catch (DataLawyerException e) {
					System.err.println("SELECT parse error: "
							+ input.toString());
					throw e;
				}
				if (!ColumnMetadata.allInputsKnown(input, c))
					MyLogger.getLog().warning("Parse warning in select clause. Might be accessing a column not in context: "
									+ select_subtree.getChild(i).toStringTree());
				project.appendColumn(c, new ColumnOptMetadata());
			}
		}

		return project;
	}

	public static Relation parseSQL(String src) throws SQLException,
			DataLawyerException {

		sqlLexer lexer = new sqlLexer(new ANTLRStringStream(src));
		MyLogger.getLog().info("Created lexer!");
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MyLogger.getLog().info("Done tokenizing!");
		sqlParser parser = new sqlParser(tokens);
		MyLogger.getLog().info("Done parsing!");

		CommonTree tree = null;
		try {
			tree = (CommonTree) parser.select().getTree();

			try {
				return convertASTtoRelation(tree);
			} catch (DataLawyerException e) {
				MyLogger.getLog().severe(
						"convertASTtoRelation failed: " + tree.toStringTree());
				e.printStackTrace();
				System.exit(1);
			}

		} catch (RecognitionException e) {
			MyLogger.getLog().severe("Parser failed: " + src);
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param input
	 * @param where_subtree
	 * @return
	 * @throws DataLawyerException
	 */
	private static Op parseWhere(Relation input, Tree where_subtree,
			Counters counters) throws DataLawyerException {
		if (!where_subtree.getText().equalsIgnoreCase("where"))
			throw DataLawyerException.incorrectParseTree("where");

		ArrayList<Tree> operations = getOperationClauses(where_subtree
				.getChild(0));
		if (operations.isEmpty())
			throw new DataLawyerException("The where clause can not be empty.");

		Relation where = input;

		for (Tree operation : operations) {
			String op = operation.getText();
			Column left_col_id = getNewColumnIfRequired(input,
					operation.getChild(0));
			Column right_col_id = getNewColumnIfRequired(input,
					operation.getChild(1));

			if (!ColumnMetadata.allInputsKnown(input, left_col_id))
				throw new DataLawyerException(
						"Parse error in where clause. Accessing a column not in context: "
								+ operation.getChild(0).toString());
			if (!ColumnMetadata.allInputsKnown(input, right_col_id))
				throw new DataLawyerException(
						"Parse error in where clause. Accessing a column not in context: "
								+ operation.getChild(1).toString());

			if (ColumnMetadata.isOverallConstant(left_col_id)
					|| ColumnMetadata.isOverallConstant(right_col_id)) {
				if (!(where instanceof OpWhere))
					where = new OpWhere(input);
				((OpWhere) where).addOperation(
						Operation.getBinary(op, left_col_id, right_col_id),
						null);
			} else {
				((OpJoin) input).addOperation(
						Operation.getBinary(op, left_col_id, right_col_id),
						null);
			}

		}

		// At this point, either this is a JoinOperator or a WhereOperator.
		if (where instanceof OpJoin)
			return (OpJoin) where;
		else
			return (OpWhere) where;
	}

	public void parsePolicy() {
		// String src = "true && (false || true && (true || false))";
		// datalogLexer lexer = new datalogLexer(new ANTLRStringStream(src));
		// datalogParser parser = new datalogParser(new
		// CommonTokenStream(lexer));
		// CommonTree tree = (CommonTree)parser.parse().getTree();
		// DOTTreeGenerator gen = new DOTTreeGenerator();
		// StringTemplate st = gen.toDOT(tree);
		// System.out.println(st);
	}

}
