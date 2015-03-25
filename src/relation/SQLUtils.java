package relation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import checker.Logs;
import checker.PolicyTransformer;

import parser.ParserWrapper;
import utils.DataLawyerException;
import utils.StringUtils;



public class SQLUtils {

	private static boolean activityLog(Relation index) {
		return Logs.USERS.getName().equalsIgnoreCase(index.getName())
				|| Logs.SCHEMA.getName().equalsIgnoreCase(index.getName())
				|| Logs.PROVENANCE.getName().equalsIgnoreCase(index.getName());
	}

	/**
	 * Modifies the given query to compute the hash of each output tuple.
	 * 
	 * @param query
	 * @return
	 * @throws DataLawyerException
	 */
	public static final String addOutput(Relation query, int queryid)
			throws DataLawyerException {

		OpAlias alias = new OpAlias(query, "alias__0");

		String otid = "";
		String concatOp = " || ";
		for (Column c : alias.getColumns()) {
			otid += String.format("cast(%s as text)%s", c.getInfo()
					.getNameAliased(), concatOp);
		}
		otid = otid.substring(0, otid.length() - concatOp.length());
		otid = String.format("md5(%s)", otid);

		return String.format("SELECT %d, %s\nFROM (%s) AS %s", queryid, otid,
				convertToSQL(query), alias.getName());
	}

	/**
	 * Modifies the given query to compute the provenance expression.
	 * 
	 * @param query
	 * @return
	 * @throws DataLawyerException
	 */
	public static final String addProvenance(Relation query, int queryid,
			boolean toTempTable) throws DataLawyerException {
		if (!provSanityCheck(query))
			throw new DataLawyerException(
					"Can not compute provenance of this query. Do not normalize the query.");
		provenanceHelper(query);

		OpAlias alias = new OpAlias(query, "alias__0");

		ArrayList<Column> contentColumns = new ArrayList<Column>();
		for (Column c : alias.getColumns())
			if (!alias.getColumnOptInfo(c).isProvenance())
				contentColumns.add(c);
		String otid = "";
		String concatOp = " || ";
		for (Column c : contentColumns) {
			otid += String.format("cast(%s as text)%s", c.getInfo()
					.getNameAliased(), concatOp);
		}
		otid = otid.substring(0, otid.length() - concatOp.length());
		otid = String.format("md5(%s)", otid);

		String selectLine = "";
		String comma = ", ";
		String functionToCall = "public.insert_to_prov";
		if (toTempTable)
			functionToCall = "mimic2v26.insert_to_prov_temp";
		for (Column c : alias.getColumns()) {
			if (alias.getColumnOptInfo(c).isProvenance()) {
				String relname = SQLUtils.getBaseIndex(c).getName();
				selectLine += String.format("%s(%d, %s, '%s', %s)%s",
						functionToCall, queryid, otid, relname, c.getInfo()
								.getNameAliased(), comma);
				// You may have to change mimic2v26 to public sometimes.
			}
		}
		selectLine = selectLine.substring(0,
				selectLine.length() - comma.length());
		return String.format("SELECT %s\nFROM (%s) AS %s", selectLine,
				convertToSQL(query), alias.getName());
	}

	public static ArrayList<String> convertToSQL(
			ArrayList<Relation> partialPolicies) throws DataLawyerException {
		ArrayList<String> sqlStrings = new ArrayList<String>();
		for (Relation r : partialPolicies)
			sqlStrings.add(convertToSQL(r));
		return sqlStrings;
	}

	/**
	 * Generates the corresponding SQL statement.
	 * 
	 * @return The corresponding SQL statement as a String.
	 * @throws DataLawyerException
	 */
	public static final String convertToSQL(Relation query) throws DataLawyerException {

		if (query instanceof Index)
			return ((Index) query).getName();

		if (query instanceof OpAlias)
			return String.format("%s AS %s",
					convertToSQL(((OpAlias) query).input(0)),
					((OpAlias) query).getName());

		if (query instanceof OpExcept)
			return String.format("%s EXCEPT (%s)",
					convertToSQL(((OpExcept) query).input(0)),
					convertToSQL(((OpExcept) query).input(1)));

		if (query instanceof OpUnion) {
			ArrayList<String> toUnion = new ArrayList<String>();
			for (Relation r : ((OpUnion) query).inputs())
				toUnion.add(convertToSQL(r));
			String toRet = toUnion.get(0);
			for (int i = 1; i < toUnion.size(); ++i)
				toRet += " UNION " + toUnion.get(i);
			return toRet;
		}

		String select, from, where, groupby, having;

		if (query.getColumns().size() == 0)
			select = "select 1\n";
		else
			select = sqlPrint(getAliasedColumns(query), "select", ", ");

		ArrayList<Relation> inputs = getNodeType(query, Index.class, false);
		inputs.addAll(getNodeType(query, OpAlias.class, false));
		from = sqlPrint(inputs, "from", ",\n\t");

		where = sqlPrint(getSelectionClauses(query), "where", " and ");

		groupby = sqlPrint(groupingColumns(query), "group by", ", ");

		having = sqlPrint(getHavingClauses(query), "having", " and ");

		return String
				.format("%s%s%s%s%s", select, from, where, groupby, having);
	}

	public static final boolean equalityModuloConstants(Relation left,
			Relation right) throws DataLawyerException {
		if (!left.getClass().equals(right.getClass()))
			return false;

		if (left instanceof OpAlias) {
			return equalityModuloConstants(((OpAlias) left).input(0),
					((OpAlias) right).input(0));
		} else if (left instanceof OpGroup) {
			// A sequence comparison of the grouping columns and a set
			// comparison of the non-grouping columns.
			OpGroup leftOp = (OpGroup) left;
			OpGroup rightOp = (OpGroup) right;
			if (leftOp.getColumns().size() != rightOp.getColumns().size())
				return false;
			if (leftOp.nGroupingColumns != rightOp.nGroupingColumns)
				return false;
			for (int iCol = 0; iCol < leftOp.nGroupingColumns; ++iCol)
				if (!leftOp.getColumn(iCol).equalsLogically(
						rightOp.getColumn(iCol)))
					return false;
			// TODO: To be sure, also do the symmetrical check.
			for (int iCol = leftOp.nGroupingColumns; iCol < leftOp.getColumns()
					.size(); ++iCol) {
				boolean foundMatch = false;
				for (int jCol = rightOp.nGroupingColumns; jCol < rightOp
						.getColumns().size(); ++jCol) {
					if (leftOp.getColumn(iCol).equalsLogically(
							rightOp.getColumn(jCol))) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch)
					return false;
			}
			return equalityModuloConstants(leftOp.input(0), rightOp.input(0));
		} else if (left instanceof OpAgg) {
			OpAgg leftOp = (OpAgg) left;
			OpAgg rightOp = (OpAgg) right;
			if (leftOp.getColumns().size() != rightOp.getColumns().size())
				return false;
			if (leftOp.operations().size() != rightOp.operations().size())
				return false;

			// TODO: To be sure, also do the symmetrical check.
			for (Column leftCol : leftOp.getColumns()) {
				if (!leftOp.aggregatedByThisOperator(leftCol))
					continue;
				boolean foundMatch = false;
				for (Column rightCol : rightOp.getColumns()) {
					if (!rightOp.aggregatedByThisOperator(rightCol))
						continue;
					if (leftCol.equalsLogically(rightCol)) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch)
					return false;
			}

			return equalityModuloConstants(leftOp.input(0), rightOp.input(0));
		} else if (left instanceof OpExcept) {
			// If left = A - B and right = A' - B', check A ~ A' and B ~ B'.
			OpExcept leftOp = (OpExcept) left;
			OpExcept rightOp = (OpExcept) right;
			return equalityModuloConstants(leftOp.input(0), rightOp.input(0))
					&& equalityModuloConstants(leftOp.input(1),
							rightOp.input(1));
		} else if (left instanceof OpProject) {
			// TODO: Assume that the descendants are equalModuloConstants.
			OpProject leftOp = (OpProject) left;
			OpProject rightOp = (OpProject) right;
			if (leftOp.getColumns().size() != rightOp.getColumns().size())
				return false;
			// TODO: To be sure, also do the symmetrical check.
			for (Column leftC : leftOp.getColumns()) {
				boolean foundMatch = false;
				for (Column rightC : rightOp.getColumns())
					if (leftC.equalsLogically(rightC)) {
						foundMatch = true;
						break;
					}
				if (!foundMatch)
					return false;
			}
			return equalityModuloConstants(leftOp.input(0), rightOp.input(0));
		} else if (left instanceof OpHaving) {
			OpHaving leftOp = (OpHaving) left;
			OpHaving rightOp = (OpHaving) right;
			if (leftOp.getColumns().size() != rightOp.getColumns().size())
				return false;
			// TODO: To be sure, also do the symmetrical check.
			for (Operation opL : leftOp.operations()) {
				boolean foundMatch = false;
				for (Operation opR : rightOp.operations()) {
					if (opL.equalsLogically(opR)) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch)
					return false;
			}
			return equalityModuloConstants(leftOp.input(0), rightOp.input(0));
		} else if (left instanceof OpWhere) {
			OpWhere leftOp = (OpWhere) left;
			OpWhere rightOp = (OpWhere) right;
			if (leftOp.getColumns().size() != rightOp.getColumns().size())
				return false;
			// TODO: To be sure, also do the symmetrical check.
			for (Operation opL : leftOp.operations()) {
				boolean foundMatch = false;
				for (Operation opR : rightOp.operations()) {
					if (opL.equalsLogically(opR)) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch)
					return false;
			}
			return equalityModuloConstants(leftOp.input(0), rightOp.input(0));
		} else if (left instanceof OpJoin) {
			OpJoin leftOp = (OpJoin) left;
			OpJoin rightOp = (OpJoin) right;
			if (leftOp.getColumns().size() != rightOp.getColumns().size())
				return false;
			if (leftOp.numInputs() != rightOp.numInputs())
				return false;
			// TODO: To be sure, also do the symmetrical check.
			for (Operation opL : leftOp.operations()) {
				boolean foundMatch = false;
				for (Operation opR : rightOp.operations()) {
					if (opL.equalsLogically(opR)) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch)
					return false;
			}

			// TODO: To be sure, also do the symmetrical check.
			for (int lcid = 0; lcid < leftOp.numInputs(); ++lcid) {
				boolean foundMatch = false;
				for (int rcid = 0; rcid < rightOp.numInputs(); ++rcid) {
					if (equalityModuloConstants(leftOp.input(lcid),
							rightOp.input(rcid))) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch)
					return false;
			}
			return true;

		} else if (left instanceof Index) {
			Index leftRel = (Index) left;
			Index rightRel = (Index) right;
			return (leftRel.getName().equalsIgnoreCase(rightRel.getName()));
		} else
			throw new DataLawyerException("Unsupported operator type: "
					+ left.getClass().getName());
	}

	public static final ArrayList<Relation> flatten(Relation query) {
		ArrayList<Relation> toRet = new ArrayList<Relation>();
		toRet.add(query);
		if (query instanceof Op) {
			Op op = (Op) query;
			for (Relation input : op.inputs())
				toRet.addAll(flatten(input));
		}
		return toRet;
	}

	private static final ArrayList<String> getAliasedColumns(Relation query) {
		ArrayList<String> aliased = new ArrayList<String>();
		for (Column c : query.getColumns())
			aliased.add(c.getInfo().getSqlDefinition());
		return aliased;
	}

	public static Column getBaseColumn(Column column,
			boolean unrollthroughalias, boolean unrollthroughaggregate)
			throws DataLawyerException {
		ArrayList<Column> unrolled = unrollColumn(column, unrollthroughalias,
				unrollthroughaggregate);
		if (unrolled == null)
			return null;
		else
			return unrolled.get(unrolled.size() - 1);
	}

	private static final Index getBaseIndex(Column c) throws DataLawyerException {
		if (c.getInfo() instanceof IndexColInfo)
			return (Index) c.getInfo()._relation;
		if (c.getInfo() instanceof ConstColumn)
			return null;
		if (c.getInfo() instanceof AggColInfo) {
			AggColInfo agginfo = (AggColInfo) c.getInfo();
			return getBaseIndex(agginfo._op._inputIndex);
		}
		if (c.getInfo() instanceof AliasColInfo) {
			AliasColInfo aliasinfo = (AliasColInfo) c.getInfo();
			return getBaseIndex(aliasinfo.getInput());
		}
		throw new DataLawyerException("Unsuuported ColumnInfo type: "
				+ c.getInfo().getClass().getName());
	}

	private static final ArrayList<Operation> getHavingClauses(Relation query) {
		return getOperations(query, OpHaving.class, false);
	}

	public static final ArrayList<Relation> getNodeType(Relation query,
			Class<?> classType, boolean recurseThroughAlias) {
		ArrayList<Relation> toRet = new ArrayList<Relation>();
		if (classType.isInstance(query))
			toRet.add(query);
		if (query instanceof Op)
			for (Relation input : ((Op) query).inputs()) {
				if (!recurseThroughAlias && input instanceof OpAlias) {
					if (classType.isInstance(input))
						toRet.add(input);
					continue;
				}
				toRet.addAll(getNodeType(input, classType, recurseThroughAlias));
			}
		return toRet;
	}

	private static final ArrayList<Operation> getOperations(Relation query,
			Class<?> classType, boolean recurseThroughAlias) {
		ArrayList<Relation> rels = getNodeType(query, classType,
				recurseThroughAlias);
		ArrayList<Operation> operations = new ArrayList<Operation>();
		for (Relation input : rels) {
			if (!(input instanceof Op))
				continue;
			Op op = (Op) input;
			operations.addAll(op.operations());
		}
		return operations;
	}

	/**
	 * This does not consider the Clock as part of the usage log. So, the Clock
	 * relation is always assumed to be present.
	 * 
	 * @param policy
	 * @param logs
	 *            : The log-generating functions that are available.
	 * @return
	 * @throws DataLawyerException
	 * @throws SQLException
	 */
	public static final ArrayList<Relation> getPartialPolicies(Relation policy,
			ArrayList<String> logs) throws DataLawyerException, SQLException {
		policy = ParserWrapper.parseSQL(convertToSQL(policy));
		ArrayList<Relation> splits = new ArrayList<Relation>();
		ArrayList<Relation> groups = getNodeType(policy, OpGroup.class, true);
		HashMap<Relation, Integer> numGroupsMap = new HashMap<Relation, Integer>();
		for (Relation group : groups)
			numGroupsMap.put(group, ((OpGroup) group).nGroupingColumns);
		ArrayList<Relation> bases = getNodeType(policy, Index.class, true);

		// Delete absent log-generating functions from the query.
		for (Relation base : bases)
			if (activityLog(base) && !logs.contains(base.getName())) {
				for (Column c : base.getColumns()) {
					Op parent = base._parent;
					parent.deleteInputColumnRecursive(c, base);
				}
				base._parent.deleteInput(base, true);
			}

		// If, due to the absence of a log-generating function, a grouping
		// operator's group-by columns are affected, the entire subquery has to
		// be evaluated separately.
		// Also, the parent query has to assume that this subquery is missing.
		for (Relation group : getNodeType(policy, OpGroup.class, true)) {
			if (((OpGroup) group).nGroupingColumns != numGroupsMap.get(group)) {
				Op currOp = group._parent;
				while (!(currOp instanceof OpAlias) && currOp._parent != null)
					currOp = currOp._parent;
				if (currOp._parent != null) {
					for (Column c : currOp.getColumns())
						currOp._parent.deleteInputColumnRecursive(c, currOp);
					currOp._parent.deleteInput(currOp, true);
				}
				splits.add(new OpProject(((OpGroup) group).input(0)));
			}
		}

		if (getNodeType(policy, Relation.class, true).size() == 1
				&& policy instanceof OpProject)
			;
		else {
			PolicyTransformer.normalizeAsBoolean(policy);
			splits.add(policy);
		}

		return splits;

		/*
		 * ArrayList<String> toRet = new ArrayList<String>(); for (Relation r :
		 * splits) toRet.add(convertToSQL(r)); return toRet;
		 */
	}

	private static final ArrayList<Operation> getSelectionClauses(Relation query) {
		ArrayList<Operation> ops = getOperations(query, OpJoin.class, false);
		ops.addAll(getOperations(query, OpWhere.class, false));
		return ops;
	}

	private static final ArrayList<Column> groupingColumns(Relation query)
			throws DataLawyerException {
		ArrayList<Column> toReturn = new ArrayList<Column>();
		ArrayList<Relation> groups = getNodeType(query, OpGroup.class, false);
		if (groups.size() > 1)
			throw new DataLawyerException("More than one group bys in a query block: "
					+ query.toString());
		for (Relation input : groups) {
			OpGroup group = (OpGroup) input;
			toReturn.addAll(group.getColumns().subList(0,
					group.nGroupingColumns));
		}
		return toReturn;
	}

	public static final boolean hasOp(Relation query, Class<?> classType,
			boolean recurseThroughAlias) {
		return !getNodeType(query, classType, recurseThroughAlias).isEmpty();
	}

	private static final void provenanceHelper(Relation query)
			throws DataLawyerException {
		if (query instanceof OpProject) {
			OpProject prOp = (OpProject) query;

			if (!hasOp(prOp, OpAgg.class, false)) {
				Relation input = prOp.input(0);
				OpAgg agg = null;
				// If no grouping operator exists, add one and then do the
				// aggregate.
				if (!(input instanceof OpGroup)) {
					OpGroup group = new OpGroup(input);
					for (Column c : prOp.getColumns()) {
						// If the column is an alias, we probably won't find it
						// in the input. Instead look at what has been aliased.
						if (group.hasColumn(c)
								|| (c.getInfo() instanceof DerivedColumn))
							group.addGroupingColumn(c);
						else if (c.getInfo() instanceof AliasColInfo)
							group.addGroupingColumn(((AliasColInfo) c.getInfo())
									.getInput());
						else {
							System.err.println("Error here: "
									+ convertToSQL(query));
							throw new DataLawyerException(
									"Can not find grouping column.");
						}
					}
					agg = new OpAgg(group);
				} else
					// If grouping operator exists, directly do the aggregate.
					agg = new OpAgg(input);
				prOp.replaceInput(input, agg);
			}

			provenanceHelper(prOp.input(0));

			for (Column c : prOp.getColumns()) {
				int id = 1;
				if (c.getInfo() instanceof AggColInfo) {
					Column newc = Column.getAliasedColumn(null, "aggcol_" + id,
							c, prOp.counters, true);
					prOp.appendColumn(newc,
							new ColumnOptInfo(prOp.getColumnOptInfo(c)));
					prOp.deleteColumn(c);
					++id;
				}
			}

			for (Column c : prOp.input(0).getColumns()) {
				ColumnOptInfo inputoptinfo = prOp.input(0).getColumnOptInfo(c);
				if (inputoptinfo.isProvenance()) {
					Column newc = Column.getAliasedColumn(null, "ctid_"
							+ getBaseIndex(c).getId(), c, prOp.counters, true);
					prOp.appendColumn(newc, new ColumnOptInfo(inputoptinfo));
				}
			}
		} else if (query instanceof OpAlias) {
			OpAlias alias = (OpAlias) query;
			provenanceHelper(alias.input(0));
			for (Column c : alias.input(0).getColumns()) {
				ColumnOptInfo inputoptinfo = alias.input(0).getColumnOptInfo(c);
				if (inputoptinfo.isProvenance())
					alias.appendAfterAliasing(c,
							new ColumnOptInfo(inputoptinfo));
			}
		} else if (query instanceof OpExcept) { // TODO: Bad bad idea. Will
												// break things.
			OpExcept except = (OpExcept) query;
			provenanceHelper(except.input(0));
			provenanceHelper(except.input(1));
			for (Column c : except.input(0).getColumns()) {
				ColumnOptInfo inputoptinfo = except.input(0)
						.getColumnOptInfo(c);
				if (inputoptinfo.isProvenance())
					except.appendColumn(c, new ColumnOptInfo(inputoptinfo));
			}
		} else if (query instanceof Index) {
			Index index = (Index) query;
			ColumnOptInfo optinfo = new ColumnOptInfo();
			optinfo.setProvenance(true);
			index.appendColumn(new Column(new IndexColInfo("ctid", index),
					index.counters), optinfo);
		} else if (query instanceof OpAgg) {
			OpAgg agg = (OpAgg) query;
			provenanceHelper(agg.input(0));
			for (Column c : agg.input(0).getColumns()) {
				ColumnOptInfo inputoptinfo = agg.input(0).getColumnOptInfo(c);
				if (inputoptinfo.isProvenance()) {
					UnaryOperation uop = Operation.getUnary("public.prov", c);
					agg.addOperation(uop, new ColumnOptInfo(inputoptinfo));
				}
			}
		} else if ((query instanceof OpWhere) || (query instanceof OpHaving)
				|| (query instanceof OpJoin) || (query instanceof OpGroup)) {
			Op op = (Op) query;
			for (Relation input : op.inputs()) {
				provenanceHelper(input);
				for (Column c : input.getColumns()) {
					ColumnOptInfo inputoptinfo = input.getColumnOptInfo(c);
					if (inputoptinfo.isProvenance())
						op.appendColumn(c, inputoptinfo);
				}
			}
		} else {
			throw new DataLawyerException(
					"Unsupported operator type for provenance computation: "
							+ query.getClass().getName());
		}
	}

	private static final boolean provSanityCheck(Relation query) {
		if (!sanityCheck(query))
			return false;
		ArrayList<Relation> aliases = getNodeType(query, OpAlias.class, false);
		if (getNodeType(query, OpProject.class, false).size() > 1)
			return false;
		if (hasOp(query, OpProject.class, false)
				&& !(query instanceof OpProject))
			return false;
		boolean retVal = true;
		for (Relation alias : aliases)
			retVal &= provSanityCheck(((Op) alias).input(0));
		return retVal;
	}

	public static final boolean sanityCheck(Relation query) {
		ArrayList<Relation> aliases = getNodeType(query, OpAlias.class, false);
		ArrayList<Relation> indices = getNodeType(query, Index.class, false);
		if (aliases.isEmpty() && indices.size() != 1)
			return false;
		if (!aliases.isEmpty() && !indices.isEmpty())
			return false;
		if (getNodeType(query, OpJoin.class, false).size() > 1)
			return false;
		if (getNodeType(query, OpAgg.class, false).size() > 1)
			return false;
		if (getNodeType(query, OpHaving.class, false).size() > 1)
			return false;
		if (getNodeType(query, OpWhere.class, false).size() > 1)
			return false;
		if (!getNodeType(query, OpHaving.class, false).isEmpty()
				&& getNodeType(query, OpAgg.class, false).isEmpty())
			return false;
		boolean retVal = true;
		for (Relation alias : aliases)
			retVal &= sanityCheck(((Op) alias).input(0));
		return retVal;
	}

	private static final String sqlPrint(List<?> outputs, String prefix,
			String delim) throws DataLawyerException {
		if (outputs.size() == 0)
			return "";
		ArrayList<String> stringArray = new ArrayList<String>();
		for (Object o : outputs)
			if (o instanceof String)
				stringArray.add((String) o);
			else if (o instanceof Column)
				stringArray.add(((Column) o).toSqlString());
			else if (o instanceof Operation)
				stringArray.add(((Operation) o).toSqlString());
			else if (o instanceof Index)
				stringArray.add(((Index) o).toSqlString());
			else if (o instanceof OpAlias)
				stringArray.add(((OpAlias) o).toSqlString());
			else
				throw new DataLawyerException("Can not convert query tree to SQL.");
		return String.format("%s %s\n", prefix,
				StringUtils.join(stringArray, delim));
	}

	public static final ArrayList<String> toStringClassList(List<?> list) {
		ArrayList<String> toRet = new ArrayList<String>();
		for (Object o : list)
			toRet.add(o.getClass().getSimpleName());
		return toRet;
	}

	/**
	 * Gets the base relations used in this column. Base relations are either
	 * ConstColumns or IndexColumns.
	 * 
	 * @param column
	 * @param unrollthroughalias
	 * @param unrollthroughaggregate
	 * @return
	 * @throws DataLawyerException
	 */
	public static ArrayList<Column> unrollColumn(Column column,
			boolean unrollthroughalias, boolean unrollthroughaggregate)
			throws DataLawyerException {
		ArrayList<Column> toret = new ArrayList<Column>();
		if (column == null)
			return null;
		ColumnInfo info = column.getInfo();
		if (info instanceof ConstColumn)
			toret.add(column);
		else if (info instanceof IndexColInfo)
			toret.add(column);
		else if (info instanceof AggColInfo && unrollthroughaggregate) {
			AggColInfo agginfo = (AggColInfo) info;
			toret.addAll(unrollColumn(agginfo.getSourceColumn(),
					unrollthroughalias, unrollthroughaggregate));
		} else if (info instanceof AliasColInfo && unrollthroughalias) {
			AliasColInfo aliasinfo = (AliasColInfo) info;
			toret.addAll(unrollColumn(aliasinfo.getInput(), unrollthroughalias,
					unrollthroughaggregate));
		} else if (info instanceof DerivedColumn) {
			DerivedColumn derivedInfo = (DerivedColumn) info;
			for (Column c : derivedInfo.inputs)
				toret.addAll(unrollColumn(c, unrollthroughalias,
						unrollthroughaggregate));
		} else {
			throw new DataLawyerException("No such ColumnInfo supported: "
					+ info.getClass().getSimpleName());
		}
		return toret;
	}

}
