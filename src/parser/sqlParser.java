// $ANTLR 3.5.2 src/parser/sqlParser.g 2015-03-25 03:19:40

    package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class sqlParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "AS", "ASC", "AVG", 
		"BY", "CHAR", "COMMA", "COMMENT", "CONCA", "COUNT", "CROSS", "DESC", "DISTINCT", 
		"DIVIDE", "DOT", "EQ", "ESC_SEQ", "EXCEPT", "EXPONENT", "FLOAT", "FOR", 
		"FROM", "FULL", "FUNCTION", "GEQ", "GROUP", "GT", "HAVING", "HEX_DIGIT", 
		"ID", "INNER", "INT", "INTERSECT", "JOIN", "LBRAC", "LEFT", "LEQ", "LIKE", 
		"LIMIT", "LT", "MAX", "MIN", "MINUS", "MULTIPLY", "NATURAL", "NEQ", "NOWAIT", 
		"OCTAL_ESC", "OF", "OFFSET", "ON", "ONLY", "OR", "ORDER", "OUTER", "PLUS", 
		"QUAL_ID", "RBRAC", "RIGHT", "SELECT", "SHARE", "STRING", "SUM", "UNICODE_ESC", 
		"UNION", "UNKNOWN", "UPDATE", "USING", "VARCHAR", "WHERE", "WS"
	};
	public static final int EOF=-1;
	public static final int ALL=4;
	public static final int AND=5;
	public static final int AS=6;
	public static final int ASC=7;
	public static final int AVG=8;
	public static final int BY=9;
	public static final int CHAR=10;
	public static final int COMMA=11;
	public static final int COMMENT=12;
	public static final int CONCA=13;
	public static final int COUNT=14;
	public static final int CROSS=15;
	public static final int DESC=16;
	public static final int DISTINCT=17;
	public static final int DIVIDE=18;
	public static final int DOT=19;
	public static final int EQ=20;
	public static final int ESC_SEQ=21;
	public static final int EXCEPT=22;
	public static final int EXPONENT=23;
	public static final int FLOAT=24;
	public static final int FOR=25;
	public static final int FROM=26;
	public static final int FULL=27;
	public static final int FUNCTION=28;
	public static final int GEQ=29;
	public static final int GROUP=30;
	public static final int GT=31;
	public static final int HAVING=32;
	public static final int HEX_DIGIT=33;
	public static final int ID=34;
	public static final int INNER=35;
	public static final int INT=36;
	public static final int INTERSECT=37;
	public static final int JOIN=38;
	public static final int LBRAC=39;
	public static final int LEFT=40;
	public static final int LEQ=41;
	public static final int LIKE=42;
	public static final int LIMIT=43;
	public static final int LT=44;
	public static final int MAX=45;
	public static final int MIN=46;
	public static final int MINUS=47;
	public static final int MULTIPLY=48;
	public static final int NATURAL=49;
	public static final int NEQ=50;
	public static final int NOWAIT=51;
	public static final int OCTAL_ESC=52;
	public static final int OF=53;
	public static final int OFFSET=54;
	public static final int ON=55;
	public static final int ONLY=56;
	public static final int OR=57;
	public static final int ORDER=58;
	public static final int OUTER=59;
	public static final int PLUS=60;
	public static final int QUAL_ID=61;
	public static final int RBRAC=62;
	public static final int RIGHT=63;
	public static final int SELECT=64;
	public static final int SHARE=65;
	public static final int STRING=66;
	public static final int SUM=67;
	public static final int UNICODE_ESC=68;
	public static final int UNION=69;
	public static final int UNKNOWN=70;
	public static final int UPDATE=71;
	public static final int USING=72;
	public static final int VARCHAR=73;
	public static final int WHERE=74;
	public static final int WS=75;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public sqlParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public sqlParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return sqlParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/parser/sqlParser.g"; }


	public static class aggregator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aggregator"
	// src/parser/sqlParser.g:15:1: aggregator : ( SUM | COUNT | MAX | MIN | AVG );
	public final sqlParser.aggregator_return aggregator() throws RecognitionException {
		sqlParser.aggregator_return retval = new sqlParser.aggregator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set1=null;

		Object set1_tree=null;

		try {
			// src/parser/sqlParser.g:15:12: ( SUM | COUNT | MAX | MIN | AVG )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set1=input.LT(1);
			if ( input.LA(1)==AVG||input.LA(1)==COUNT||(input.LA(1) >= MAX && input.LA(1) <= MIN)||input.LA(1)==SUM ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set1));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aggregator"


	public static class comparator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "comparator"
	// src/parser/sqlParser.g:16:1: comparator : ( EQ | GT | LEQ | GEQ | LT | NEQ | LIKE );
	public final sqlParser.comparator_return comparator() throws RecognitionException {
		sqlParser.comparator_return retval = new sqlParser.comparator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set2=null;

		Object set2_tree=null;

		try {
			// src/parser/sqlParser.g:16:12: ( EQ | GT | LEQ | GEQ | LT | NEQ | LIKE )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set2=input.LT(1);
			if ( input.LA(1)==EQ||input.LA(1)==GEQ||input.LA(1)==GT||(input.LA(1) >= LEQ && input.LA(1) <= LIKE)||input.LA(1)==LT||input.LA(1)==NEQ ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set2));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comparator"


	public static class order_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_operator"
	// src/parser/sqlParser.g:17:1: order_operator : ( GT | LT );
	public final sqlParser.order_operator_return order_operator() throws RecognitionException {
		sqlParser.order_operator_return retval = new sqlParser.order_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set3=null;

		Object set3_tree=null;

		try {
			// src/parser/sqlParser.g:17:16: ( GT | LT )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set3=input.LT(1);
			if ( input.LA(1)==GT||input.LA(1)==LT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set3));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_operator"


	public static class operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "operator"
	// src/parser/sqlParser.g:18:1: operator : ( PLUS | MINUS | MULTIPLY | DIVIDE | CONCA );
	public final sqlParser.operator_return operator() throws RecognitionException {
		sqlParser.operator_return retval = new sqlParser.operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set4=null;

		Object set4_tree=null;

		try {
			// src/parser/sqlParser.g:18:10: ( PLUS | MINUS | MULTIPLY | DIVIDE | CONCA )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set4=input.LT(1);
			if ( input.LA(1)==CONCA||input.LA(1)==DIVIDE||(input.LA(1) >= MINUS && input.LA(1) <= MULTIPLY)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set4));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "operator"


	public static class column_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "column_name"
	// src/parser/sqlParser.g:20:1: column_name : ( ID | QUAL_ID );
	public final sqlParser.column_name_return column_name() throws RecognitionException {
		sqlParser.column_name_return retval = new sqlParser.column_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set5=null;

		Object set5_tree=null;

		try {
			// src/parser/sqlParser.g:20:13: ( ID | QUAL_ID )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set5=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==QUAL_ID ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set5));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "column_name"


	public static class type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// src/parser/sqlParser.g:21:1: type : UNKNOWN ;
	public final sqlParser.type_return type() throws RecognitionException {
		sqlParser.type_return retval = new sqlParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token UNKNOWN6=null;

		Object UNKNOWN6_tree=null;

		try {
			// src/parser/sqlParser.g:21:7: ( UNKNOWN )
			// src/parser/sqlParser.g:21:9: UNKNOWN
			{
			root_0 = (Object)adaptor.nil();


			UNKNOWN6=(Token)match(input,UNKNOWN,FOLLOW_UNKNOWN_in_type161); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNKNOWN6_tree = (Object)adaptor.create(UNKNOWN6);
			adaptor.addChild(root_0, UNKNOWN6_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class column_alias_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "column_alias"
	// src/parser/sqlParser.g:22:1: column_alias : ID ;
	public final sqlParser.column_alias_return column_alias() throws RecognitionException {
		sqlParser.column_alias_return retval = new sqlParser.column_alias_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID7=null;

		Object ID7_tree=null;

		try {
			// src/parser/sqlParser.g:22:14: ( ID )
			// src/parser/sqlParser.g:22:16: ID
			{
			root_0 = (Object)adaptor.nil();


			ID7=(Token)match(input,ID,FOLLOW_ID_in_column_alias169); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID7_tree = (Object)adaptor.create(ID7);
			adaptor.addChild(root_0, ID7_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "column_alias"


	public static class alias_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "alias"
	// src/parser/sqlParser.g:23:1: alias : ID ;
	public final sqlParser.alias_return alias() throws RecognitionException {
		sqlParser.alias_return retval = new sqlParser.alias_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID8=null;

		Object ID8_tree=null;

		try {
			// src/parser/sqlParser.g:23:8: ( ID )
			// src/parser/sqlParser.g:23:10: ID
			{
			root_0 = (Object)adaptor.nil();


			ID8=(Token)match(input,ID,FOLLOW_ID_in_alias178); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID8_tree = (Object)adaptor.create(ID8);
			adaptor.addChild(root_0, ID8_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alias"


	public static class function_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_name"
	// src/parser/sqlParser.g:24:1: function_name : ID ;
	public final sqlParser.function_name_return function_name() throws RecognitionException {
		sqlParser.function_name_return retval = new sqlParser.function_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID9=null;

		Object ID9_tree=null;

		try {
			// src/parser/sqlParser.g:24:15: ( ID )
			// src/parser/sqlParser.g:24:17: ID
			{
			root_0 = (Object)adaptor.nil();


			ID9=(Token)match(input,ID,FOLLOW_ID_in_function_name186); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID9_tree = (Object)adaptor.create(ID9);
			adaptor.addChild(root_0, ID9_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function_name"


	public static class argument_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "argument"
	// src/parser/sqlParser.g:25:1: argument : ( INT | FLOAT | ID );
	public final sqlParser.argument_return argument() throws RecognitionException {
		sqlParser.argument_return retval = new sqlParser.argument_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set10=null;

		Object set10_tree=null;

		try {
			// src/parser/sqlParser.g:25:10: ( INT | FLOAT | ID )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set10=input.LT(1);
			if ( input.LA(1)==FLOAT||input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set10));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argument"


	public static class table_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "table_name"
	// src/parser/sqlParser.g:26:1: table_name : ( ID | QUAL_ID );
	public final sqlParser.table_name_return table_name() throws RecognitionException {
		sqlParser.table_name_return retval = new sqlParser.table_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set11=null;

		Object set11_tree=null;

		try {
			// src/parser/sqlParser.g:26:12: ( ID | QUAL_ID )
			// src/parser/sqlParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set11=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==QUAL_ID ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set11));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "table_name"


	public static class join_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_type"
	// src/parser/sqlParser.g:28:1: join_type : ( ( INNER )? JOIN -> ^( JOIN ) | LEFT ( OUTER )? JOIN -> ^( LEFT ) | RIGHT ( OUTER )? JOIN -> ^( RIGHT ) | FULL ( OUTER )? JOIN -> ^( FULL ) | CROSS JOIN !);
	public final sqlParser.join_type_return join_type() throws RecognitionException {
		sqlParser.join_type_return retval = new sqlParser.join_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INNER12=null;
		Token JOIN13=null;
		Token LEFT14=null;
		Token OUTER15=null;
		Token JOIN16=null;
		Token RIGHT17=null;
		Token OUTER18=null;
		Token JOIN19=null;
		Token FULL20=null;
		Token OUTER21=null;
		Token JOIN22=null;
		Token CROSS23=null;
		Token JOIN24=null;

		Object INNER12_tree=null;
		Object JOIN13_tree=null;
		Object LEFT14_tree=null;
		Object OUTER15_tree=null;
		Object JOIN16_tree=null;
		Object RIGHT17_tree=null;
		Object OUTER18_tree=null;
		Object JOIN19_tree=null;
		Object FULL20_tree=null;
		Object OUTER21_tree=null;
		Object JOIN22_tree=null;
		Object CROSS23_tree=null;
		Object JOIN24_tree=null;
		RewriteRuleTokenStream stream_LEFT=new RewriteRuleTokenStream(adaptor,"token LEFT");
		RewriteRuleTokenStream stream_JOIN=new RewriteRuleTokenStream(adaptor,"token JOIN");
		RewriteRuleTokenStream stream_RIGHT=new RewriteRuleTokenStream(adaptor,"token RIGHT");
		RewriteRuleTokenStream stream_OUTER=new RewriteRuleTokenStream(adaptor,"token OUTER");
		RewriteRuleTokenStream stream_FULL=new RewriteRuleTokenStream(adaptor,"token FULL");
		RewriteRuleTokenStream stream_INNER=new RewriteRuleTokenStream(adaptor,"token INNER");

		try {
			// src/parser/sqlParser.g:28:13: ( ( INNER )? JOIN -> ^( JOIN ) | LEFT ( OUTER )? JOIN -> ^( LEFT ) | RIGHT ( OUTER )? JOIN -> ^( RIGHT ) | FULL ( OUTER )? JOIN -> ^( FULL ) | CROSS JOIN !)
			int alt5=5;
			switch ( input.LA(1) ) {
			case INNER:
			case JOIN:
				{
				alt5=1;
				}
				break;
			case LEFT:
				{
				alt5=2;
				}
				break;
			case RIGHT:
				{
				alt5=3;
				}
				break;
			case FULL:
				{
				alt5=4;
				}
				break;
			case CROSS:
				{
				alt5=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// src/parser/sqlParser.g:28:15: ( INNER )? JOIN
					{
					// src/parser/sqlParser.g:28:15: ( INNER )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==INNER) ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// src/parser/sqlParser.g:28:15: INNER
							{
							INNER12=(Token)match(input,INNER,FOLLOW_INNER_in_join_type225); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_INNER.add(INNER12);

							}
							break;

					}

					JOIN13=(Token)match(input,JOIN,FOLLOW_JOIN_in_join_type228); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_JOIN.add(JOIN13);

					// AST REWRITE
					// elements: JOIN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 28:27: -> ^( JOIN )
					{
						// src/parser/sqlParser.g:28:30: ^( JOIN )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_JOIN.nextNode(), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:29:8: LEFT ( OUTER )? JOIN
					{
					LEFT14=(Token)match(input,LEFT,FOLLOW_LEFT_in_join_type243); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LEFT.add(LEFT14);

					// src/parser/sqlParser.g:29:13: ( OUTER )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==OUTER) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// src/parser/sqlParser.g:29:13: OUTER
							{
							OUTER15=(Token)match(input,OUTER,FOLLOW_OUTER_in_join_type245); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_OUTER.add(OUTER15);

							}
							break;

					}

					JOIN16=(Token)match(input,JOIN,FOLLOW_JOIN_in_join_type248); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_JOIN.add(JOIN16);

					// AST REWRITE
					// elements: LEFT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 29:25: -> ^( LEFT )
					{
						// src/parser/sqlParser.g:29:28: ^( LEFT )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_LEFT.nextNode(), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/parser/sqlParser.g:30:8: RIGHT ( OUTER )? JOIN
					{
					RIGHT17=(Token)match(input,RIGHT,FOLLOW_RIGHT_in_join_type263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RIGHT.add(RIGHT17);

					// src/parser/sqlParser.g:30:14: ( OUTER )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==OUTER) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// src/parser/sqlParser.g:30:14: OUTER
							{
							OUTER18=(Token)match(input,OUTER,FOLLOW_OUTER_in_join_type265); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_OUTER.add(OUTER18);

							}
							break;

					}

					JOIN19=(Token)match(input,JOIN,FOLLOW_JOIN_in_join_type268); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_JOIN.add(JOIN19);

					// AST REWRITE
					// elements: RIGHT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 30:26: -> ^( RIGHT )
					{
						// src/parser/sqlParser.g:30:29: ^( RIGHT )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_RIGHT.nextNode(), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// src/parser/sqlParser.g:31:8: FULL ( OUTER )? JOIN
					{
					FULL20=(Token)match(input,FULL,FOLLOW_FULL_in_join_type283); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FULL.add(FULL20);

					// src/parser/sqlParser.g:31:13: ( OUTER )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==OUTER) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// src/parser/sqlParser.g:31:13: OUTER
							{
							OUTER21=(Token)match(input,OUTER,FOLLOW_OUTER_in_join_type285); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_OUTER.add(OUTER21);

							}
							break;

					}

					JOIN22=(Token)match(input,JOIN,FOLLOW_JOIN_in_join_type288); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_JOIN.add(JOIN22);

					// AST REWRITE
					// elements: FULL
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 31:25: -> ^( FULL )
					{
						// src/parser/sqlParser.g:31:28: ^( FULL )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_FULL.nextNode(), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// src/parser/sqlParser.g:32:8: CROSS JOIN !
					{
					root_0 = (Object)adaptor.nil();


					CROSS23=(Token)match(input,CROSS,FOLLOW_CROSS_in_join_type303); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CROSS23_tree = (Object)adaptor.create(CROSS23);
					adaptor.addChild(root_0, CROSS23_tree);
					}

					JOIN24=(Token)match(input,JOIN,FOLLOW_JOIN_in_join_type305); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_type"


	public static class simple_operand_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "simple_operand"
	// src/parser/sqlParser.g:35:1: simple_operand : ( aggregator ^ LBRAC ! expression RBRAC !| LBRAC ! expression RBRAC ! operator ^ expression | LBRAC ! expression RBRAC !| DISTINCT ^ expression | function LBRAC expressions RBRAC -> ^( FUNCTION function expressions ) | column_name | INT | FLOAT | VARCHAR );
	public final sqlParser.simple_operand_return simple_operand() throws RecognitionException {
		sqlParser.simple_operand_return retval = new sqlParser.simple_operand_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRAC26=null;
		Token RBRAC28=null;
		Token LBRAC29=null;
		Token RBRAC31=null;
		Token LBRAC34=null;
		Token RBRAC36=null;
		Token DISTINCT37=null;
		Token LBRAC40=null;
		Token RBRAC42=null;
		Token INT44=null;
		Token FLOAT45=null;
		Token VARCHAR46=null;
		ParserRuleReturnScope aggregator25 =null;
		ParserRuleReturnScope expression27 =null;
		ParserRuleReturnScope expression30 =null;
		ParserRuleReturnScope operator32 =null;
		ParserRuleReturnScope expression33 =null;
		ParserRuleReturnScope expression35 =null;
		ParserRuleReturnScope expression38 =null;
		ParserRuleReturnScope function39 =null;
		ParserRuleReturnScope expressions41 =null;
		ParserRuleReturnScope column_name43 =null;

		Object LBRAC26_tree=null;
		Object RBRAC28_tree=null;
		Object LBRAC29_tree=null;
		Object RBRAC31_tree=null;
		Object LBRAC34_tree=null;
		Object RBRAC36_tree=null;
		Object DISTINCT37_tree=null;
		Object LBRAC40_tree=null;
		Object RBRAC42_tree=null;
		Object INT44_tree=null;
		Object FLOAT45_tree=null;
		Object VARCHAR46_tree=null;
		RewriteRuleTokenStream stream_LBRAC=new RewriteRuleTokenStream(adaptor,"token LBRAC");
		RewriteRuleTokenStream stream_RBRAC=new RewriteRuleTokenStream(adaptor,"token RBRAC");
		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
		RewriteRuleSubtreeStream stream_expressions=new RewriteRuleSubtreeStream(adaptor,"rule expressions");

		try {
			// src/parser/sqlParser.g:35:16: ( aggregator ^ LBRAC ! expression RBRAC !| LBRAC ! expression RBRAC ! operator ^ expression | LBRAC ! expression RBRAC !| DISTINCT ^ expression | function LBRAC expressions RBRAC -> ^( FUNCTION function expressions ) | column_name | INT | FLOAT | VARCHAR )
			int alt6=9;
			switch ( input.LA(1) ) {
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				alt6=1;
				}
				break;
			case LBRAC:
				{
				int LA6_2 = input.LA(2);
				if ( (synpred29_sqlParser()) ) {
					alt6=2;
				}
				else if ( (synpred30_sqlParser()) ) {
					alt6=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DISTINCT:
				{
				alt6=4;
				}
				break;
			case ID:
				{
				int LA6_4 = input.LA(2);
				if ( (synpred32_sqlParser()) ) {
					alt6=5;
				}
				else if ( (synpred33_sqlParser()) ) {
					alt6=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case QUAL_ID:
				{
				alt6=6;
				}
				break;
			case INT:
				{
				alt6=7;
				}
				break;
			case FLOAT:
				{
				alt6=8;
				}
				break;
			case VARCHAR:
				{
				alt6=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// src/parser/sqlParser.g:36:4: aggregator ^ LBRAC ! expression RBRAC !
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_aggregator_in_simple_operand323);
					aggregator25=aggregator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(aggregator25.getTree(), root_0);
					LBRAC26=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_simple_operand326); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_simple_operand329);
					expression27=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression27.getTree());

					RBRAC28=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_simple_operand331); if (state.failed) return retval;
					}
					break;
				case 2 :
					// src/parser/sqlParser.g:37:4: LBRAC ! expression RBRAC ! operator ^ expression
					{
					root_0 = (Object)adaptor.nil();


					LBRAC29=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_simple_operand337); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_simple_operand340);
					expression30=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression30.getTree());

					RBRAC31=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_simple_operand342); if (state.failed) return retval;
					pushFollow(FOLLOW_operator_in_simple_operand345);
					operator32=operator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(operator32.getTree(), root_0);
					pushFollow(FOLLOW_expression_in_simple_operand348);
					expression33=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression33.getTree());

					}
					break;
				case 3 :
					// src/parser/sqlParser.g:38:4: LBRAC ! expression RBRAC !
					{
					root_0 = (Object)adaptor.nil();


					LBRAC34=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_simple_operand353); if (state.failed) return retval;
					pushFollow(FOLLOW_expression_in_simple_operand356);
					expression35=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression35.getTree());

					RBRAC36=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_simple_operand358); if (state.failed) return retval;
					}
					break;
				case 4 :
					// src/parser/sqlParser.g:39:4: DISTINCT ^ expression
					{
					root_0 = (Object)adaptor.nil();


					DISTINCT37=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_simple_operand364); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DISTINCT37_tree = (Object)adaptor.create(DISTINCT37);
					root_0 = (Object)adaptor.becomeRoot(DISTINCT37_tree, root_0);
					}

					pushFollow(FOLLOW_expression_in_simple_operand367);
					expression38=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression38.getTree());

					}
					break;
				case 5 :
					// src/parser/sqlParser.g:40:4: function LBRAC expressions RBRAC
					{
					pushFollow(FOLLOW_function_in_simple_operand372);
					function39=function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_function.add(function39.getTree());
					LBRAC40=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_simple_operand374); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRAC.add(LBRAC40);

					pushFollow(FOLLOW_expressions_in_simple_operand376);
					expressions41=expressions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expressions.add(expressions41.getTree());
					RBRAC42=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_simple_operand378); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRAC.add(RBRAC42);

					// AST REWRITE
					// elements: function, expressions
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 40:37: -> ^( FUNCTION function expressions )
					{
						// src/parser/sqlParser.g:40:40: ^( FUNCTION function expressions )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
						adaptor.addChild(root_1, stream_function.nextTree());
						adaptor.addChild(root_1, stream_expressions.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// src/parser/sqlParser.g:41:4: column_name
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_name_in_simple_operand393);
					column_name43=column_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_name43.getTree());

					}
					break;
				case 7 :
					// src/parser/sqlParser.g:42:4: INT
					{
					root_0 = (Object)adaptor.nil();


					INT44=(Token)match(input,INT,FOLLOW_INT_in_simple_operand398); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT44_tree = (Object)adaptor.create(INT44);
					adaptor.addChild(root_0, INT44_tree);
					}

					}
					break;
				case 8 :
					// src/parser/sqlParser.g:43:4: FLOAT
					{
					root_0 = (Object)adaptor.nil();


					FLOAT45=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_simple_operand403); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOAT45_tree = (Object)adaptor.create(FLOAT45);
					adaptor.addChild(root_0, FLOAT45_tree);
					}

					}
					break;
				case 9 :
					// src/parser/sqlParser.g:44:4: VARCHAR
					{
					root_0 = (Object)adaptor.nil();


					VARCHAR46=(Token)match(input,VARCHAR,FOLLOW_VARCHAR_in_simple_operand408); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VARCHAR46_tree = (Object)adaptor.create(VARCHAR46);
					adaptor.addChild(root_0, VARCHAR46_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "simple_operand"


	public static class count_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "count"
	// src/parser/sqlParser.g:48:1: count : INT ;
	public final sqlParser.count_return count() throws RecognitionException {
		sqlParser.count_return retval = new sqlParser.count_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT47=null;

		Object INT47_tree=null;

		try {
			// src/parser/sqlParser.g:48:11: ( INT )
			// src/parser/sqlParser.g:48:13: INT
			{
			root_0 = (Object)adaptor.nil();


			INT47=(Token)match(input,INT,FOLLOW_INT_in_count423); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT47_tree = (Object)adaptor.create(INT47);
			adaptor.addChild(root_0, INT47_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "count"


	public static class start_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "start"
	// src/parser/sqlParser.g:49:1: start : INT ;
	public final sqlParser.start_return start() throws RecognitionException {
		sqlParser.start_return retval = new sqlParser.start_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT48=null;

		Object INT48_tree=null;

		try {
			// src/parser/sqlParser.g:49:11: ( INT )
			// src/parser/sqlParser.g:49:13: INT
			{
			root_0 = (Object)adaptor.nil();


			INT48=(Token)match(input,INT,FOLLOW_INT_in_start435); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT48_tree = (Object)adaptor.create(INT48);
			adaptor.addChild(root_0, INT48_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start"


	public static class star_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "star"
	// src/parser/sqlParser.g:50:1: star : MULTIPLY ;
	public final sqlParser.star_return star() throws RecognitionException {
		sqlParser.star_return retval = new sqlParser.star_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULTIPLY49=null;

		Object MULTIPLY49_tree=null;

		try {
			// src/parser/sqlParser.g:50:10: ( MULTIPLY )
			// src/parser/sqlParser.g:50:12: MULTIPLY
			{
			root_0 = (Object)adaptor.nil();


			MULTIPLY49=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_star447); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MULTIPLY49_tree = (Object)adaptor.create(MULTIPLY49);
			adaptor.addChild(root_0, MULTIPLY49_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "star"


	public static class aliased_expressions_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aliased_expressions"
	// src/parser/sqlParser.g:52:1: aliased_expressions : ( ( aliased_expression | expression ) COMMA ! aliased_expressions | ( aliased_expression | expression ) );
	public final sqlParser.aliased_expressions_return aliased_expressions() throws RecognitionException {
		sqlParser.aliased_expressions_return retval = new sqlParser.aliased_expressions_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA52=null;
		ParserRuleReturnScope aliased_expression50 =null;
		ParserRuleReturnScope expression51 =null;
		ParserRuleReturnScope aliased_expressions53 =null;
		ParserRuleReturnScope aliased_expression54 =null;
		ParserRuleReturnScope expression55 =null;

		Object COMMA52_tree=null;

		try {
			// src/parser/sqlParser.g:52:21: ( ( aliased_expression | expression ) COMMA ! aliased_expressions | ( aliased_expression | expression ) )
			int alt9=2;
			switch ( input.LA(1) ) {
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA9_1 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case LBRAC:
				{
				int LA9_2 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case DISTINCT:
				{
				int LA9_3 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case ID:
				{
				int LA9_4 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA9_5 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case INT:
				{
				int LA9_6 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA9_7 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			case VARCHAR:
				{
				int LA9_8 = input.LA(2);
				if ( (synpred37_sqlParser()) ) {
					alt9=1;
				}
				else if ( (true) ) {
					alt9=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// src/parser/sqlParser.g:52:23: ( aliased_expression | expression ) COMMA ! aliased_expressions
					{
					root_0 = (Object)adaptor.nil();


					// src/parser/sqlParser.g:52:23: ( aliased_expression | expression )
					int alt7=2;
					switch ( input.LA(1) ) {
					case AVG:
					case COUNT:
					case MAX:
					case MIN:
					case SUM:
						{
						int LA7_1 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case LBRAC:
						{
						int LA7_2 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case DISTINCT:
						{
						int LA7_3 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case ID:
						{
						int LA7_4 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case QUAL_ID:
						{
						int LA7_5 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case INT:
						{
						int LA7_6 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case FLOAT:
						{
						int LA7_7 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					case VARCHAR:
						{
						int LA7_8 = input.LA(2);
						if ( (synpred36_sqlParser()) ) {
							alt7=1;
						}
						else if ( (true) ) {
							alt7=2;
						}

						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}
					switch (alt7) {
						case 1 :
							// src/parser/sqlParser.g:52:24: aliased_expression
							{
							pushFollow(FOLLOW_aliased_expression_in_aliased_expressions457);
							aliased_expression50=aliased_expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, aliased_expression50.getTree());

							}
							break;
						case 2 :
							// src/parser/sqlParser.g:52:45: expression
							{
							pushFollow(FOLLOW_expression_in_aliased_expressions461);
							expression51=expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expression51.getTree());

							}
							break;

					}

					COMMA52=(Token)match(input,COMMA,FOLLOW_COMMA_in_aliased_expressions465); if (state.failed) return retval;
					pushFollow(FOLLOW_aliased_expressions_in_aliased_expressions468);
					aliased_expressions53=aliased_expressions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliased_expressions53.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:53:9: ( aliased_expression | expression )
					{
					root_0 = (Object)adaptor.nil();


					// src/parser/sqlParser.g:53:9: ( aliased_expression | expression )
					int alt8=2;
					switch ( input.LA(1) ) {
					case AVG:
					case COUNT:
					case MAX:
					case MIN:
					case SUM:
						{
						int LA8_1 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case LBRAC:
						{
						int LA8_2 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case DISTINCT:
						{
						int LA8_3 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case ID:
						{
						int LA8_4 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case QUAL_ID:
						{
						int LA8_5 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case INT:
						{
						int LA8_6 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case FLOAT:
						{
						int LA8_7 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					case VARCHAR:
						{
						int LA8_8 = input.LA(2);
						if ( (synpred38_sqlParser()) ) {
							alt8=1;
						}
						else if ( (true) ) {
							alt8=2;
						}

						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}
					switch (alt8) {
						case 1 :
							// src/parser/sqlParser.g:53:10: aliased_expression
							{
							pushFollow(FOLLOW_aliased_expression_in_aliased_expressions479);
							aliased_expression54=aliased_expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, aliased_expression54.getTree());

							}
							break;
						case 2 :
							// src/parser/sqlParser.g:53:31: expression
							{
							pushFollow(FOLLOW_expression_in_aliased_expressions483);
							expression55=expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expression55.getTree());

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aliased_expressions"


	public static class aliased_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aliased_expression"
	// src/parser/sqlParser.g:55:1: aliased_expression : ( expression AS alias -> ^( AS expression alias ) | expression alias -> ^( AS expression alias ) );
	public final sqlParser.aliased_expression_return aliased_expression() throws RecognitionException {
		sqlParser.aliased_expression_return retval = new sqlParser.aliased_expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AS57=null;
		ParserRuleReturnScope expression56 =null;
		ParserRuleReturnScope alias58 =null;
		ParserRuleReturnScope expression59 =null;
		ParserRuleReturnScope alias60 =null;

		Object AS57_tree=null;
		RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias");

		try {
			// src/parser/sqlParser.g:55:21: ( expression AS alias -> ^( AS expression alias ) | expression alias -> ^( AS expression alias ) )
			int alt10=2;
			switch ( input.LA(1) ) {
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA10_1 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case LBRAC:
				{
				int LA10_2 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case DISTINCT:
				{
				int LA10_3 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case ID:
				{
				int LA10_4 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA10_5 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case INT:
				{
				int LA10_6 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA10_7 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			case VARCHAR:
				{
				int LA10_8 = input.LA(2);
				if ( (synpred39_sqlParser()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// src/parser/sqlParser.g:55:23: expression AS alias
					{
					pushFollow(FOLLOW_expression_in_aliased_expression495);
					expression56=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression56.getTree());
					AS57=(Token)match(input,AS,FOLLOW_AS_in_aliased_expression497); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AS.add(AS57);

					pushFollow(FOLLOW_alias_in_aliased_expression499);
					alias58=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_alias.add(alias58.getTree());
					// AST REWRITE
					// elements: AS, alias, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:43: -> ^( AS expression alias )
					{
						// src/parser/sqlParser.g:55:46: ^( AS expression alias )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_AS.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_alias.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:56:10: expression alias
					{
					pushFollow(FOLLOW_expression_in_aliased_expression520);
					expression59=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression59.getTree());
					pushFollow(FOLLOW_alias_in_aliased_expression522);
					alias60=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_alias.add(alias60.getTree());
					// AST REWRITE
					// elements: expression, alias
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 56:27: -> ^( AS expression alias )
					{
						// src/parser/sqlParser.g:56:30: ^( AS expression alias )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AS, "AS"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_alias.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aliased_expression"


	public static class expressions_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expressions"
	// src/parser/sqlParser.g:58:1: expressions : ( expression COMMA ! expressions | expression );
	public final sqlParser.expressions_return expressions() throws RecognitionException {
		sqlParser.expressions_return retval = new sqlParser.expressions_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA62=null;
		ParserRuleReturnScope expression61 =null;
		ParserRuleReturnScope expressions63 =null;
		ParserRuleReturnScope expression64 =null;

		Object COMMA62_tree=null;

		try {
			// src/parser/sqlParser.g:58:13: ( expression COMMA ! expressions | expression )
			int alt11=2;
			switch ( input.LA(1) ) {
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA11_1 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case LBRAC:
				{
				int LA11_2 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case DISTINCT:
				{
				int LA11_3 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case ID:
				{
				int LA11_4 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA11_5 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case INT:
				{
				int LA11_6 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA11_7 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			case VARCHAR:
				{
				int LA11_8 = input.LA(2);
				if ( (synpred40_sqlParser()) ) {
					alt11=1;
				}
				else if ( (true) ) {
					alt11=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// src/parser/sqlParser.g:58:15: expression COMMA ! expressions
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_expressions541);
					expression61=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression61.getTree());

					COMMA62=(Token)match(input,COMMA,FOLLOW_COMMA_in_expressions544); if (state.failed) return retval;
					pushFollow(FOLLOW_expressions_in_expressions548);
					expressions63=expressions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expressions63.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:59:8: expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_expressions557);
					expression64=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression64.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expressions"


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// src/parser/sqlParser.g:62:1: function : ID ;
	public final sqlParser.function_return function() throws RecognitionException {
		sqlParser.function_return retval = new sqlParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID65=null;

		Object ID65_tree=null;

		try {
			// src/parser/sqlParser.g:63:2: ( ID )
			// src/parser/sqlParser.g:63:4: ID
			{
			root_0 = (Object)adaptor.nil();


			ID65=(Token)match(input,ID,FOLLOW_ID_in_function568); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID65_tree = (Object)adaptor.create(ID65);
			adaptor.addChild(root_0, ID65_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// src/parser/sqlParser.g:66:1: expression : ( simple_operand operator ^ expression | simple_operand );
	public final sqlParser.expression_return expression() throws RecognitionException {
		sqlParser.expression_return retval = new sqlParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope simple_operand66 =null;
		ParserRuleReturnScope operator67 =null;
		ParserRuleReturnScope expression68 =null;
		ParserRuleReturnScope simple_operand69 =null;


		try {
			// src/parser/sqlParser.g:66:13: ( simple_operand operator ^ expression | simple_operand )
			int alt12=2;
			switch ( input.LA(1) ) {
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA12_1 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case LBRAC:
				{
				int LA12_2 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case DISTINCT:
				{
				int LA12_3 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case ID:
				{
				int LA12_4 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA12_5 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case INT:
				{
				int LA12_6 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA12_7 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			case VARCHAR:
				{
				int LA12_8 = input.LA(2);
				if ( (synpred41_sqlParser()) ) {
					alt12=1;
				}
				else if ( (true) ) {
					alt12=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// src/parser/sqlParser.g:66:16: simple_operand operator ^ expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simple_operand_in_expression579);
					simple_operand66=simple_operand();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_operand66.getTree());

					pushFollow(FOLLOW_operator_in_expression581);
					operator67=operator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(operator67.getTree(), root_0);
					pushFollow(FOLLOW_expression_in_expression584);
					expression68=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression68.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:67:9: simple_operand
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_simple_operand_in_expression594);
					simple_operand69=simple_operand();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_operand69.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class order_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_expression"
	// src/parser/sqlParser.g:71:1: order_expression : ( expression ( ASC | DESC | USING order_operator ) order_expression | expression ( ASC | DESC | USING order_operator ) );
	public final sqlParser.order_expression_return order_expression() throws RecognitionException {
		sqlParser.order_expression_return retval = new sqlParser.order_expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASC71=null;
		Token DESC72=null;
		Token USING73=null;
		Token ASC77=null;
		Token DESC78=null;
		Token USING79=null;
		ParserRuleReturnScope expression70 =null;
		ParserRuleReturnScope order_operator74 =null;
		ParserRuleReturnScope order_expression75 =null;
		ParserRuleReturnScope expression76 =null;
		ParserRuleReturnScope order_operator80 =null;

		Object ASC71_tree=null;
		Object DESC72_tree=null;
		Object USING73_tree=null;
		Object ASC77_tree=null;
		Object DESC78_tree=null;
		Object USING79_tree=null;

		try {
			// src/parser/sqlParser.g:71:21: ( expression ( ASC | DESC | USING order_operator ) order_expression | expression ( ASC | DESC | USING order_operator ) )
			int alt15=2;
			switch ( input.LA(1) ) {
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA15_1 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case LBRAC:
				{
				int LA15_2 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case DISTINCT:
				{
				int LA15_3 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case ID:
				{
				int LA15_4 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA15_5 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case INT:
				{
				int LA15_6 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA15_7 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			case VARCHAR:
				{
				int LA15_8 = input.LA(2);
				if ( (synpred44_sqlParser()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// src/parser/sqlParser.g:71:23: expression ( ASC | DESC | USING order_operator ) order_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_order_expression612);
					expression70=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression70.getTree());

					// src/parser/sqlParser.g:71:34: ( ASC | DESC | USING order_operator )
					int alt13=3;
					switch ( input.LA(1) ) {
					case ASC:
						{
						alt13=1;
						}
						break;
					case DESC:
						{
						alt13=2;
						}
						break;
					case USING:
						{
						alt13=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}
					switch (alt13) {
						case 1 :
							// src/parser/sqlParser.g:71:36: ASC
							{
							ASC71=(Token)match(input,ASC,FOLLOW_ASC_in_order_expression616); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC71_tree = (Object)adaptor.create(ASC71);
							adaptor.addChild(root_0, ASC71_tree);
							}

							}
							break;
						case 2 :
							// src/parser/sqlParser.g:71:42: DESC
							{
							DESC72=(Token)match(input,DESC,FOLLOW_DESC_in_order_expression620); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC72_tree = (Object)adaptor.create(DESC72);
							adaptor.addChild(root_0, DESC72_tree);
							}

							}
							break;
						case 3 :
							// src/parser/sqlParser.g:71:49: USING order_operator
							{
							USING73=(Token)match(input,USING,FOLLOW_USING_in_order_expression624); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							USING73_tree = (Object)adaptor.create(USING73);
							adaptor.addChild(root_0, USING73_tree);
							}

							pushFollow(FOLLOW_order_operator_in_order_expression626);
							order_operator74=order_operator();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, order_operator74.getTree());

							}
							break;

					}

					pushFollow(FOLLOW_order_expression_in_order_expression630);
					order_expression75=order_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, order_expression75.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:72:9: expression ( ASC | DESC | USING order_operator )
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_order_expression640);
					expression76=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression76.getTree());

					// src/parser/sqlParser.g:72:20: ( ASC | DESC | USING order_operator )
					int alt14=3;
					switch ( input.LA(1) ) {
					case ASC:
						{
						alt14=1;
						}
						break;
					case DESC:
						{
						alt14=2;
						}
						break;
					case USING:
						{
						alt14=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}
					switch (alt14) {
						case 1 :
							// src/parser/sqlParser.g:72:22: ASC
							{
							ASC77=(Token)match(input,ASC,FOLLOW_ASC_in_order_expression644); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							ASC77_tree = (Object)adaptor.create(ASC77);
							adaptor.addChild(root_0, ASC77_tree);
							}

							}
							break;
						case 2 :
							// src/parser/sqlParser.g:72:28: DESC
							{
							DESC78=(Token)match(input,DESC,FOLLOW_DESC_in_order_expression648); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							DESC78_tree = (Object)adaptor.create(DESC78);
							adaptor.addChild(root_0, DESC78_tree);
							}

							}
							break;
						case 3 :
							// src/parser/sqlParser.g:72:35: USING order_operator
							{
							USING79=(Token)match(input,USING,FOLLOW_USING_in_order_expression652); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							USING79_tree = (Object)adaptor.create(USING79);
							adaptor.addChild(root_0, USING79_tree);
							}

							pushFollow(FOLLOW_order_operator_in_order_expression654);
							order_operator80=order_operator();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, order_operator80.getTree());

							}
							break;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_expression"


	public static class conditions_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "conditions"
	// src/parser/sqlParser.g:74:1: conditions : ( condition COMMA ! conditions | condition );
	public final sqlParser.conditions_return conditions() throws RecognitionException {
		sqlParser.conditions_return retval = new sqlParser.conditions_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA82=null;
		ParserRuleReturnScope condition81 =null;
		ParserRuleReturnScope conditions83 =null;
		ParserRuleReturnScope condition84 =null;

		Object COMMA82_tree=null;

		try {
			// src/parser/sqlParser.g:74:13: ( condition COMMA ! conditions | condition )
			int alt16=2;
			switch ( input.LA(1) ) {
			case LBRAC:
				{
				int LA16_1 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA16_2 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case DISTINCT:
				{
				int LA16_3 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case ID:
				{
				int LA16_4 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA16_5 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case INT:
				{
				int LA16_6 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case FLOAT:
				{
				int LA16_7 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			case VARCHAR:
				{
				int LA16_8 = input.LA(2);
				if ( (synpred47_sqlParser()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// src/parser/sqlParser.g:74:15: condition COMMA ! conditions
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_condition_in_conditions666);
					condition81=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, condition81.getTree());

					COMMA82=(Token)match(input,COMMA,FOLLOW_COMMA_in_conditions670); if (state.failed) return retval;
					pushFollow(FOLLOW_conditions_in_conditions674);
					conditions83=conditions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conditions83.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:75:8: condition
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_condition_in_conditions683);
					condition84=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, condition84.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "conditions"


	public static class condition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "condition"
	// src/parser/sqlParser.g:77:1: condition : ( LBRAC ! condition RBRAC ! AND ^ condition | expression comparator ^ expression AND ^ condition | LBRAC ! condition RBRAC !| expression comparator ^ expression );
	public final sqlParser.condition_return condition() throws RecognitionException {
		sqlParser.condition_return retval = new sqlParser.condition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRAC85=null;
		Token RBRAC87=null;
		Token AND88=null;
		Token AND93=null;
		Token LBRAC95=null;
		Token RBRAC97=null;
		ParserRuleReturnScope condition86 =null;
		ParserRuleReturnScope condition89 =null;
		ParserRuleReturnScope expression90 =null;
		ParserRuleReturnScope comparator91 =null;
		ParserRuleReturnScope expression92 =null;
		ParserRuleReturnScope condition94 =null;
		ParserRuleReturnScope condition96 =null;
		ParserRuleReturnScope expression98 =null;
		ParserRuleReturnScope comparator99 =null;
		ParserRuleReturnScope expression100 =null;

		Object LBRAC85_tree=null;
		Object RBRAC87_tree=null;
		Object AND88_tree=null;
		Object AND93_tree=null;
		Object LBRAC95_tree=null;
		Object RBRAC97_tree=null;

		try {
			// src/parser/sqlParser.g:77:13: ( LBRAC ! condition RBRAC ! AND ^ condition | expression comparator ^ expression AND ^ condition | LBRAC ! condition RBRAC !| expression comparator ^ expression )
			int alt17=4;
			switch ( input.LA(1) ) {
			case LBRAC:
				{
				int LA17_1 = input.LA(2);
				if ( (synpred48_sqlParser()) ) {
					alt17=1;
				}
				else if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (synpred50_sqlParser()) ) {
					alt17=3;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case AVG:
			case COUNT:
			case MAX:
			case MIN:
			case SUM:
				{
				int LA17_2 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case DISTINCT:
				{
				int LA17_3 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case ID:
				{
				int LA17_4 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA17_5 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case INT:
				{
				int LA17_6 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case FLOAT:
				{
				int LA17_7 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			case VARCHAR:
				{
				int LA17_8 = input.LA(2);
				if ( (synpred49_sqlParser()) ) {
					alt17=2;
				}
				else if ( (true) ) {
					alt17=4;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// src/parser/sqlParser.g:77:15: LBRAC ! condition RBRAC ! AND ^ condition
					{
					root_0 = (Object)adaptor.nil();


					LBRAC85=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_condition694); if (state.failed) return retval;
					pushFollow(FOLLOW_condition_in_condition697);
					condition86=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, condition86.getTree());

					RBRAC87=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_condition699); if (state.failed) return retval;
					AND88=(Token)match(input,AND,FOLLOW_AND_in_condition702); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND88_tree = (Object)adaptor.create(AND88);
					root_0 = (Object)adaptor.becomeRoot(AND88_tree, root_0);
					}

					pushFollow(FOLLOW_condition_in_condition706);
					condition89=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, condition89.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:78:8: expression comparator ^ expression AND ^ condition
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_condition715);
					expression90=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression90.getTree());

					pushFollow(FOLLOW_comparator_in_condition717);
					comparator91=comparator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(comparator91.getTree(), root_0);
					pushFollow(FOLLOW_expression_in_condition720);
					expression92=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression92.getTree());

					AND93=(Token)match(input,AND,FOLLOW_AND_in_condition722); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND93_tree = (Object)adaptor.create(AND93);
					root_0 = (Object)adaptor.becomeRoot(AND93_tree, root_0);
					}

					pushFollow(FOLLOW_condition_in_condition725);
					condition94=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, condition94.getTree());

					}
					break;
				case 3 :
					// src/parser/sqlParser.g:79:8: LBRAC ! condition RBRAC !
					{
					root_0 = (Object)adaptor.nil();


					LBRAC95=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_condition734); if (state.failed) return retval;
					pushFollow(FOLLOW_condition_in_condition737);
					condition96=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, condition96.getTree());

					RBRAC97=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_condition739); if (state.failed) return retval;
					}
					break;
				case 4 :
					// src/parser/sqlParser.g:80:8: expression comparator ^ expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_condition749);
					expression98=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression98.getTree());

					pushFollow(FOLLOW_comparator_in_condition751);
					comparator99=comparator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(comparator99.getTree(), root_0);
					pushFollow(FOLLOW_expression_in_condition754);
					expression100=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression100.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condition"


	public static class select_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "select"
	// src/parser/sqlParser.g:83:1: select : select_block ( from_block )? ( where_block )? ( group_block )? ( having_block )? ( union_intersect_except_block )? ( limit_block )? ( offset_block )? ;
	public final sqlParser.select_return select() throws RecognitionException {
		sqlParser.select_return retval = new sqlParser.select_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope select_block101 =null;
		ParserRuleReturnScope from_block102 =null;
		ParserRuleReturnScope where_block103 =null;
		ParserRuleReturnScope group_block104 =null;
		ParserRuleReturnScope having_block105 =null;
		ParserRuleReturnScope union_intersect_except_block106 =null;
		ParserRuleReturnScope limit_block107 =null;
		ParserRuleReturnScope offset_block108 =null;


		try {
			// src/parser/sqlParser.g:83:8: ( select_block ( from_block )? ( where_block )? ( group_block )? ( having_block )? ( union_intersect_except_block )? ( limit_block )? ( offset_block )? )
			// src/parser/sqlParser.g:83:12: select_block ( from_block )? ( where_block )? ( group_block )? ( having_block )? ( union_intersect_except_block )? ( limit_block )? ( offset_block )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_select_block_in_select770);
			select_block101=select_block();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, select_block101.getTree());

			// src/parser/sqlParser.g:84:6: ( from_block )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==FROM) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// src/parser/sqlParser.g:84:6: from_block
					{
					pushFollow(FOLLOW_from_block_in_select777);
					from_block102=from_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, from_block102.getTree());

					}
					break;

			}

			// src/parser/sqlParser.g:85:6: ( where_block )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==WHERE) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// src/parser/sqlParser.g:85:6: where_block
					{
					pushFollow(FOLLOW_where_block_in_select785);
					where_block103=where_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, where_block103.getTree());

					}
					break;

			}

			// src/parser/sqlParser.g:86:6: ( group_block )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==GROUP) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// src/parser/sqlParser.g:86:6: group_block
					{
					pushFollow(FOLLOW_group_block_in_select793);
					group_block104=group_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, group_block104.getTree());

					}
					break;

			}

			// src/parser/sqlParser.g:87:6: ( having_block )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==HAVING) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// src/parser/sqlParser.g:87:6: having_block
					{
					pushFollow(FOLLOW_having_block_in_select801);
					having_block105=having_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, having_block105.getTree());

					}
					break;

			}

			// src/parser/sqlParser.g:88:6: ( union_intersect_except_block )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==EXCEPT||LA22_0==INTERSECT||LA22_0==UNION) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// src/parser/sqlParser.g:88:6: union_intersect_except_block
					{
					pushFollow(FOLLOW_union_intersect_except_block_in_select809);
					union_intersect_except_block106=union_intersect_except_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, union_intersect_except_block106.getTree());

					}
					break;

			}

			// src/parser/sqlParser.g:89:6: ( limit_block )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==LIMIT) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// src/parser/sqlParser.g:89:6: limit_block
					{
					pushFollow(FOLLOW_limit_block_in_select817);
					limit_block107=limit_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, limit_block107.getTree());

					}
					break;

			}

			// src/parser/sqlParser.g:90:6: ( offset_block )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==OFFSET) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// src/parser/sqlParser.g:90:6: offset_block
					{
					pushFollow(FOLLOW_offset_block_in_select825);
					offset_block108=offset_block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, offset_block108.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "select"


	public static class select_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "select_block"
	// src/parser/sqlParser.g:93:1: select_block : SELECT ^ ( ALL | DISTINCT ( ON ! LBRAC ! expressions RBRAC !)? )? ( star | aliased_expressions ) ;
	public final sqlParser.select_block_return select_block() throws RecognitionException {
		sqlParser.select_block_return retval = new sqlParser.select_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SELECT109=null;
		Token ALL110=null;
		Token DISTINCT111=null;
		Token ON112=null;
		Token LBRAC113=null;
		Token RBRAC115=null;
		ParserRuleReturnScope expressions114 =null;
		ParserRuleReturnScope star116 =null;
		ParserRuleReturnScope aliased_expressions117 =null;

		Object SELECT109_tree=null;
		Object ALL110_tree=null;
		Object DISTINCT111_tree=null;
		Object ON112_tree=null;
		Object LBRAC113_tree=null;
		Object RBRAC115_tree=null;

		try {
			// src/parser/sqlParser.g:93:14: ( SELECT ^ ( ALL | DISTINCT ( ON ! LBRAC ! expressions RBRAC !)? )? ( star | aliased_expressions ) )
			// src/parser/sqlParser.g:93:18: SELECT ^ ( ALL | DISTINCT ( ON ! LBRAC ! expressions RBRAC !)? )? ( star | aliased_expressions )
			{
			root_0 = (Object)adaptor.nil();


			SELECT109=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_block842); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SELECT109_tree = (Object)adaptor.create(SELECT109);
			root_0 = (Object)adaptor.becomeRoot(SELECT109_tree, root_0);
			}

			// src/parser/sqlParser.g:93:26: ( ALL | DISTINCT ( ON ! LBRAC ! expressions RBRAC !)? )?
			int alt26=3;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==ALL) ) {
				alt26=1;
			}
			else if ( (LA26_0==DISTINCT) ) {
				int LA26_2 = input.LA(2);
				if ( (synpred60_sqlParser()) ) {
					alt26=2;
				}
			}
			switch (alt26) {
				case 1 :
					// src/parser/sqlParser.g:93:27: ALL
					{
					ALL110=(Token)match(input,ALL,FOLLOW_ALL_in_select_block846); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL110_tree = (Object)adaptor.create(ALL110);
					adaptor.addChild(root_0, ALL110_tree);
					}

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:93:33: DISTINCT ( ON ! LBRAC ! expressions RBRAC !)?
					{
					DISTINCT111=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_select_block850); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DISTINCT111_tree = (Object)adaptor.create(DISTINCT111);
					adaptor.addChild(root_0, DISTINCT111_tree);
					}

					// src/parser/sqlParser.g:93:42: ( ON ! LBRAC ! expressions RBRAC !)?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==ON) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// src/parser/sqlParser.g:93:44: ON ! LBRAC ! expressions RBRAC !
							{
							ON112=(Token)match(input,ON,FOLLOW_ON_in_select_block854); if (state.failed) return retval;
							LBRAC113=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_select_block857); if (state.failed) return retval;
							pushFollow(FOLLOW_expressions_in_select_block860);
							expressions114=expressions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expressions114.getTree());

							RBRAC115=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_select_block862); if (state.failed) return retval;
							}
							break;

					}

					}
					break;

			}

			// src/parser/sqlParser.g:93:80: ( star | aliased_expressions )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==MULTIPLY) ) {
				alt27=1;
			}
			else if ( (LA27_0==AVG||LA27_0==COUNT||LA27_0==DISTINCT||LA27_0==FLOAT||LA27_0==ID||LA27_0==INT||LA27_0==LBRAC||(LA27_0 >= MAX && LA27_0 <= MIN)||LA27_0==QUAL_ID||LA27_0==SUM||LA27_0==VARCHAR) ) {
				alt27=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// src/parser/sqlParser.g:93:81: star
					{
					pushFollow(FOLLOW_star_in_select_block872);
					star116=star();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, star116.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:93:88: aliased_expressions
					{
					pushFollow(FOLLOW_aliased_expressions_in_select_block876);
					aliased_expressions117=aliased_expressions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliased_expressions117.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "select_block"


	public static class from_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "from_block"
	// src/parser/sqlParser.g:94:1: from_block : FROM ^ from_items ;
	public final sqlParser.from_block_return from_block() throws RecognitionException {
		sqlParser.from_block_return retval = new sqlParser.from_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FROM118=null;
		ParserRuleReturnScope from_items119 =null;

		Object FROM118_tree=null;

		try {
			// src/parser/sqlParser.g:94:12: ( FROM ^ from_items )
			// src/parser/sqlParser.g:94:16: FROM ^ from_items
			{
			root_0 = (Object)adaptor.nil();


			FROM118=(Token)match(input,FROM,FOLLOW_FROM_in_from_block887); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FROM118_tree = (Object)adaptor.create(FROM118);
			root_0 = (Object)adaptor.becomeRoot(FROM118_tree, root_0);
			}

			pushFollow(FOLLOW_from_items_in_from_block890);
			from_items119=from_items();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, from_items119.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "from_block"


	public static class where_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "where_block"
	// src/parser/sqlParser.g:95:1: where_block : WHERE ^ condition ;
	public final sqlParser.where_block_return where_block() throws RecognitionException {
		sqlParser.where_block_return retval = new sqlParser.where_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token WHERE120=null;
		ParserRuleReturnScope condition121 =null;

		Object WHERE120_tree=null;

		try {
			// src/parser/sqlParser.g:95:13: ( WHERE ^ condition )
			// src/parser/sqlParser.g:95:17: WHERE ^ condition
			{
			root_0 = (Object)adaptor.nil();


			WHERE120=(Token)match(input,WHERE,FOLLOW_WHERE_in_where_block900); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WHERE120_tree = (Object)adaptor.create(WHERE120);
			root_0 = (Object)adaptor.becomeRoot(WHERE120_tree, root_0);
			}

			pushFollow(FOLLOW_condition_in_where_block903);
			condition121=condition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, condition121.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "where_block"


	public static class group_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "group_block"
	// src/parser/sqlParser.g:96:1: group_block : GROUP ^ BY ! expressions ;
	public final sqlParser.group_block_return group_block() throws RecognitionException {
		sqlParser.group_block_return retval = new sqlParser.group_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token GROUP122=null;
		Token BY123=null;
		ParserRuleReturnScope expressions124 =null;

		Object GROUP122_tree=null;
		Object BY123_tree=null;

		try {
			// src/parser/sqlParser.g:96:13: ( GROUP ^ BY ! expressions )
			// src/parser/sqlParser.g:96:17: GROUP ^ BY ! expressions
			{
			root_0 = (Object)adaptor.nil();


			GROUP122=(Token)match(input,GROUP,FOLLOW_GROUP_in_group_block913); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			GROUP122_tree = (Object)adaptor.create(GROUP122);
			root_0 = (Object)adaptor.becomeRoot(GROUP122_tree, root_0);
			}

			BY123=(Token)match(input,BY,FOLLOW_BY_in_group_block916); if (state.failed) return retval;
			pushFollow(FOLLOW_expressions_in_group_block919);
			expressions124=expressions();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expressions124.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "group_block"


	public static class having_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "having_block"
	// src/parser/sqlParser.g:97:1: having_block : HAVING ^ conditions ;
	public final sqlParser.having_block_return having_block() throws RecognitionException {
		sqlParser.having_block_return retval = new sqlParser.having_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token HAVING125=null;
		ParserRuleReturnScope conditions126 =null;

		Object HAVING125_tree=null;

		try {
			// src/parser/sqlParser.g:97:14: ( HAVING ^ conditions )
			// src/parser/sqlParser.g:97:18: HAVING ^ conditions
			{
			root_0 = (Object)adaptor.nil();


			HAVING125=(Token)match(input,HAVING,FOLLOW_HAVING_in_having_block929); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			HAVING125_tree = (Object)adaptor.create(HAVING125);
			root_0 = (Object)adaptor.becomeRoot(HAVING125_tree, root_0);
			}

			pushFollow(FOLLOW_conditions_in_having_block932);
			conditions126=conditions();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conditions126.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "having_block"


	public static class union_intersect_except_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "union_intersect_except_block"
	// src/parser/sqlParser.g:98:1: union_intersect_except_block : ( UNION ^| INTERSECT ^| EXCEPT ^) ( ALL )? LBRAC ! select RBRAC !;
	public final sqlParser.union_intersect_except_block_return union_intersect_except_block() throws RecognitionException {
		sqlParser.union_intersect_except_block_return retval = new sqlParser.union_intersect_except_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token UNION127=null;
		Token INTERSECT128=null;
		Token EXCEPT129=null;
		Token ALL130=null;
		Token LBRAC131=null;
		Token RBRAC133=null;
		ParserRuleReturnScope select132 =null;

		Object UNION127_tree=null;
		Object INTERSECT128_tree=null;
		Object EXCEPT129_tree=null;
		Object ALL130_tree=null;
		Object LBRAC131_tree=null;
		Object RBRAC133_tree=null;

		try {
			// src/parser/sqlParser.g:98:30: ( ( UNION ^| INTERSECT ^| EXCEPT ^) ( ALL )? LBRAC ! select RBRAC !)
			// src/parser/sqlParser.g:98:33: ( UNION ^| INTERSECT ^| EXCEPT ^) ( ALL )? LBRAC ! select RBRAC !
			{
			root_0 = (Object)adaptor.nil();


			// src/parser/sqlParser.g:98:33: ( UNION ^| INTERSECT ^| EXCEPT ^)
			int alt28=3;
			switch ( input.LA(1) ) {
			case UNION:
				{
				alt28=1;
				}
				break;
			case INTERSECT:
				{
				alt28=2;
				}
				break;
			case EXCEPT:
				{
				alt28=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// src/parser/sqlParser.g:98:34: UNION ^
					{
					UNION127=(Token)match(input,UNION,FOLLOW_UNION_in_union_intersect_except_block942); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UNION127_tree = (Object)adaptor.create(UNION127);
					root_0 = (Object)adaptor.becomeRoot(UNION127_tree, root_0);
					}

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:98:43: INTERSECT ^
					{
					INTERSECT128=(Token)match(input,INTERSECT,FOLLOW_INTERSECT_in_union_intersect_except_block947); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTERSECT128_tree = (Object)adaptor.create(INTERSECT128);
					root_0 = (Object)adaptor.becomeRoot(INTERSECT128_tree, root_0);
					}

					}
					break;
				case 3 :
					// src/parser/sqlParser.g:98:56: EXCEPT ^
					{
					EXCEPT129=(Token)match(input,EXCEPT,FOLLOW_EXCEPT_in_union_intersect_except_block952); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EXCEPT129_tree = (Object)adaptor.create(EXCEPT129);
					root_0 = (Object)adaptor.becomeRoot(EXCEPT129_tree, root_0);
					}

					}
					break;

			}

			// src/parser/sqlParser.g:98:65: ( ALL )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==ALL) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// src/parser/sqlParser.g:98:66: ALL
					{
					ALL130=(Token)match(input,ALL,FOLLOW_ALL_in_union_intersect_except_block957); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL130_tree = (Object)adaptor.create(ALL130);
					adaptor.addChild(root_0, ALL130_tree);
					}

					}
					break;

			}

			LBRAC131=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_union_intersect_except_block961); if (state.failed) return retval;
			pushFollow(FOLLOW_select_in_union_intersect_except_block964);
			select132=select();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, select132.getTree());

			RBRAC133=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_union_intersect_except_block966); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "union_intersect_except_block"


	public static class order_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "order_block"
	// src/parser/sqlParser.g:99:1: order_block : ORDER ^ BY ! order_expression ;
	public final sqlParser.order_block_return order_block() throws RecognitionException {
		sqlParser.order_block_return retval = new sqlParser.order_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ORDER134=null;
		Token BY135=null;
		ParserRuleReturnScope order_expression136 =null;

		Object ORDER134_tree=null;
		Object BY135_tree=null;

		try {
			// src/parser/sqlParser.g:99:13: ( ORDER ^ BY ! order_expression )
			// src/parser/sqlParser.g:99:17: ORDER ^ BY ! order_expression
			{
			root_0 = (Object)adaptor.nil();


			ORDER134=(Token)match(input,ORDER,FOLLOW_ORDER_in_order_block977); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ORDER134_tree = (Object)adaptor.create(ORDER134);
			root_0 = (Object)adaptor.becomeRoot(ORDER134_tree, root_0);
			}

			BY135=(Token)match(input,BY,FOLLOW_BY_in_order_block980); if (state.failed) return retval;
			pushFollow(FOLLOW_order_expression_in_order_block983);
			order_expression136=order_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, order_expression136.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order_block"


	public static class limit_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "limit_block"
	// src/parser/sqlParser.g:100:1: limit_block : LIMIT ^ ( count | ALL ) ;
	public final sqlParser.limit_block_return limit_block() throws RecognitionException {
		sqlParser.limit_block_return retval = new sqlParser.limit_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LIMIT137=null;
		Token ALL139=null;
		ParserRuleReturnScope count138 =null;

		Object LIMIT137_tree=null;
		Object ALL139_tree=null;

		try {
			// src/parser/sqlParser.g:100:13: ( LIMIT ^ ( count | ALL ) )
			// src/parser/sqlParser.g:100:17: LIMIT ^ ( count | ALL )
			{
			root_0 = (Object)adaptor.nil();


			LIMIT137=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_limit_block993); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LIMIT137_tree = (Object)adaptor.create(LIMIT137);
			root_0 = (Object)adaptor.becomeRoot(LIMIT137_tree, root_0);
			}

			// src/parser/sqlParser.g:100:24: ( count | ALL )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==INT) ) {
				alt30=1;
			}
			else if ( (LA30_0==ALL) ) {
				alt30=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// src/parser/sqlParser.g:100:26: count
					{
					pushFollow(FOLLOW_count_in_limit_block998);
					count138=count();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, count138.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:100:34: ALL
					{
					ALL139=(Token)match(input,ALL,FOLLOW_ALL_in_limit_block1002); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALL139_tree = (Object)adaptor.create(ALL139);
					adaptor.addChild(root_0, ALL139_tree);
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "limit_block"


	public static class offset_block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "offset_block"
	// src/parser/sqlParser.g:101:1: offset_block : OFFSET ^ start ;
	public final sqlParser.offset_block_return offset_block() throws RecognitionException {
		sqlParser.offset_block_return retval = new sqlParser.offset_block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OFFSET140=null;
		ParserRuleReturnScope start141 =null;

		Object OFFSET140_tree=null;

		try {
			// src/parser/sqlParser.g:101:14: ( OFFSET ^ start )
			// src/parser/sqlParser.g:101:18: OFFSET ^ start
			{
			root_0 = (Object)adaptor.nil();


			OFFSET140=(Token)match(input,OFFSET,FOLLOW_OFFSET_in_offset_block1014); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OFFSET140_tree = (Object)adaptor.create(OFFSET140);
			root_0 = (Object)adaptor.becomeRoot(OFFSET140_tree, root_0);
			}

			pushFollow(FOLLOW_start_in_offset_block1017);
			start141=start();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, start141.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "offset_block"


	public static class column_aliases_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "column_aliases"
	// src/parser/sqlParser.g:103:1: column_aliases : ( column_alias COMMA ! column_aliases | column_alias );
	public final sqlParser.column_aliases_return column_aliases() throws RecognitionException {
		sqlParser.column_aliases_return retval = new sqlParser.column_aliases_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA143=null;
		ParserRuleReturnScope column_alias142 =null;
		ParserRuleReturnScope column_aliases144 =null;
		ParserRuleReturnScope column_alias145 =null;

		Object COMMA143_tree=null;

		try {
			// src/parser/sqlParser.g:103:16: ( column_alias COMMA ! column_aliases | column_alias )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==ID) ) {
				int LA31_1 = input.LA(2);
				if ( (LA31_1==COMMA) ) {
					int LA31_2 = input.LA(3);
					if ( (LA31_2==ID) ) {
						int LA31_4 = input.LA(4);
						if ( (synpred66_sqlParser()) ) {
							alt31=1;
						}
						else if ( (true) ) {
							alt31=2;
						}

					}
					else if ( (LA31_2==LBRAC||LA31_2==ONLY||LA31_2==QUAL_ID) ) {
						alt31=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 31, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA31_1==EOF||LA31_1==CROSS||LA31_1==EXCEPT||LA31_1==FULL||LA31_1==GROUP||LA31_1==HAVING||LA31_1==INNER||(LA31_1 >= INTERSECT && LA31_1 <= JOIN)||LA31_1==LEFT||LA31_1==LIMIT||LA31_1==NATURAL||(LA31_1 >= OFFSET && LA31_1 <= ON)||(LA31_1 >= RBRAC && LA31_1 <= RIGHT)||LA31_1==UNION||LA31_1==USING||LA31_1==WHERE) ) {
					alt31=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 31, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// src/parser/sqlParser.g:103:18: column_alias COMMA ! column_aliases
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_alias_in_column_aliases1027);
					column_alias142=column_alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_alias142.getTree());

					COMMA143=(Token)match(input,COMMA,FOLLOW_COMMA_in_column_aliases1029); if (state.failed) return retval;
					pushFollow(FOLLOW_column_aliases_in_column_aliases1032);
					column_aliases144=column_aliases();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_aliases144.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:104:5: column_alias
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_alias_in_column_aliases1038);
					column_alias145=column_alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_alias145.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "column_aliases"


	public static class arguments_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arguments"
	// src/parser/sqlParser.g:106:1: arguments : ( argument COMMA ! arguments | argument );
	public final sqlParser.arguments_return arguments() throws RecognitionException {
		sqlParser.arguments_return retval = new sqlParser.arguments_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA147=null;
		ParserRuleReturnScope argument146 =null;
		ParserRuleReturnScope arguments148 =null;
		ParserRuleReturnScope argument149 =null;

		Object COMMA147_tree=null;

		try {
			// src/parser/sqlParser.g:106:11: ( argument COMMA ! arguments | argument )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==FLOAT||LA32_0==ID||LA32_0==INT) ) {
				int LA32_1 = input.LA(2);
				if ( (LA32_1==COMMA) ) {
					alt32=1;
				}
				else if ( (LA32_1==EOF||LA32_1==RBRAC) ) {
					alt32=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 32, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// src/parser/sqlParser.g:106:13: argument COMMA ! arguments
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_argument_in_arguments1047);
					argument146=argument();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, argument146.getTree());

					COMMA147=(Token)match(input,COMMA,FOLLOW_COMMA_in_arguments1049); if (state.failed) return retval;
					pushFollow(FOLLOW_arguments_in_arguments1052);
					arguments148=arguments();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, arguments148.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:107:5: argument
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_argument_in_arguments1058);
					argument149=argument();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, argument149.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arguments"


	public static class column_definitions_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "column_definitions"
	// src/parser/sqlParser.g:109:1: column_definitions : ( column_definition COMMA ! column_definitions | column_definition );
	public final sqlParser.column_definitions_return column_definitions() throws RecognitionException {
		sqlParser.column_definitions_return retval = new sqlParser.column_definitions_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA151=null;
		ParserRuleReturnScope column_definition150 =null;
		ParserRuleReturnScope column_definitions152 =null;
		ParserRuleReturnScope column_definition153 =null;

		Object COMMA151_tree=null;

		try {
			// src/parser/sqlParser.g:109:21: ( column_definition COMMA ! column_definitions | column_definition )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==ID||LA33_0==QUAL_ID) ) {
				int LA33_1 = input.LA(2);
				if ( (LA33_1==UNKNOWN) ) {
					int LA33_2 = input.LA(3);
					if ( (LA33_2==COMMA) ) {
						alt33=1;
					}
					else if ( (LA33_2==EOF||LA33_2==RBRAC) ) {
						alt33=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 33, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 33, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// src/parser/sqlParser.g:109:23: column_definition COMMA ! column_definitions
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_definition_in_column_definitions1068);
					column_definition150=column_definition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_definition150.getTree());

					COMMA151=(Token)match(input,COMMA,FOLLOW_COMMA_in_column_definitions1070); if (state.failed) return retval;
					pushFollow(FOLLOW_column_definitions_in_column_definitions1073);
					column_definitions152=column_definitions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_definitions152.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:110:9: column_definition
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_definition_in_column_definitions1083);
					column_definition153=column_definition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_definition153.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "column_definitions"


	public static class column_definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "column_definition"
	// src/parser/sqlParser.g:112:1: column_definition : column_name type ;
	public final sqlParser.column_definition_return column_definition() throws RecognitionException {
		sqlParser.column_definition_return retval = new sqlParser.column_definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope column_name154 =null;
		ParserRuleReturnScope type155 =null;


		try {
			// src/parser/sqlParser.g:112:21: ( column_name type )
			// src/parser/sqlParser.g:112:23: column_name type
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_column_name_in_column_definition1094);
			column_name154=column_name();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, column_name154.getTree());

			pushFollow(FOLLOW_type_in_column_definition1096);
			type155=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type155.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "column_definition"


	public static class join_columns_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_columns"
	// src/parser/sqlParser.g:114:1: join_columns : ( column_name COMMA ! join_columns | column_name );
	public final sqlParser.join_columns_return join_columns() throws RecognitionException {
		sqlParser.join_columns_return retval = new sqlParser.join_columns_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA157=null;
		ParserRuleReturnScope column_name156 =null;
		ParserRuleReturnScope join_columns158 =null;
		ParserRuleReturnScope column_name159 =null;

		Object COMMA157_tree=null;

		try {
			// src/parser/sqlParser.g:114:14: ( column_name COMMA ! join_columns | column_name )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==ID||LA34_0==QUAL_ID) ) {
				int LA34_1 = input.LA(2);
				if ( (LA34_1==COMMA) ) {
					alt34=1;
				}
				else if ( (LA34_1==EOF||LA34_1==RBRAC) ) {
					alt34=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// src/parser/sqlParser.g:114:16: column_name COMMA ! join_columns
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_name_in_join_columns1105);
					column_name156=column_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_name156.getTree());

					COMMA157=(Token)match(input,COMMA,FOLLOW_COMMA_in_join_columns1107); if (state.failed) return retval;
					pushFollow(FOLLOW_join_columns_in_join_columns1110);
					join_columns158=join_columns();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, join_columns158.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:115:5: column_name
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_column_name_in_join_columns1116);
					column_name159=column_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_name159.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_columns"


	public static class join_condition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "join_condition"
	// src/parser/sqlParser.g:117:1: join_condition : condition ;
	public final sqlParser.join_condition_return join_condition() throws RecognitionException {
		sqlParser.join_condition_return retval = new sqlParser.join_condition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope condition160 =null;


		try {
			// src/parser/sqlParser.g:117:16: ( condition )
			// src/parser/sqlParser.g:117:18: condition
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_condition_in_join_condition1125);
			condition160=condition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, condition160.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "join_condition"


	public static class from_items_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "from_items"
	// src/parser/sqlParser.g:119:1: from_items : ( from_item COMMA ! from_items | from_item );
	public final sqlParser.from_items_return from_items() throws RecognitionException {
		sqlParser.from_items_return retval = new sqlParser.from_items_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA162=null;
		ParserRuleReturnScope from_item161 =null;
		ParserRuleReturnScope from_items163 =null;
		ParserRuleReturnScope from_item164 =null;

		Object COMMA162_tree=null;

		try {
			// src/parser/sqlParser.g:119:12: ( from_item COMMA ! from_items | from_item )
			int alt35=2;
			switch ( input.LA(1) ) {
			case LBRAC:
				{
				int LA35_1 = input.LA(2);
				if ( (synpred70_sqlParser()) ) {
					alt35=1;
				}
				else if ( (true) ) {
					alt35=2;
				}

				}
				break;
			case ONLY:
				{
				int LA35_2 = input.LA(2);
				if ( (synpred70_sqlParser()) ) {
					alt35=1;
				}
				else if ( (true) ) {
					alt35=2;
				}

				}
				break;
			case ID:
				{
				int LA35_3 = input.LA(2);
				if ( (synpred70_sqlParser()) ) {
					alt35=1;
				}
				else if ( (true) ) {
					alt35=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA35_4 = input.LA(2);
				if ( (synpred70_sqlParser()) ) {
					alt35=1;
				}
				else if ( (true) ) {
					alt35=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// src/parser/sqlParser.g:119:14: from_item COMMA ! from_items
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_from_item_in_from_items1134);
					from_item161=from_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, from_item161.getTree());

					COMMA162=(Token)match(input,COMMA,FOLLOW_COMMA_in_from_items1136); if (state.failed) return retval;
					pushFollow(FOLLOW_from_items_in_from_items1139);
					from_items163=from_items();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, from_items163.getTree());

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:120:5: from_item
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_from_item_in_from_items1145);
					from_item164=from_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, from_item164.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "from_items"


	public static class from_item_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "from_item"
	// src/parser/sqlParser.g:122:1: from_item : ( from_item_basic ( NATURAL )? join_type from_item ( ON join_condition | USING LBRAC join_columns RBRAC )? -> ^( join_type from_item_basic from_item ( ^( ON join_condition ) )? ( ^( USING join_columns ) )? ) | from_item_basic );
	public final sqlParser.from_item_return from_item() throws RecognitionException {
		sqlParser.from_item_return retval = new sqlParser.from_item_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NATURAL166=null;
		Token ON169=null;
		Token USING171=null;
		Token LBRAC172=null;
		Token RBRAC174=null;
		ParserRuleReturnScope from_item_basic165 =null;
		ParserRuleReturnScope join_type167 =null;
		ParserRuleReturnScope from_item168 =null;
		ParserRuleReturnScope join_condition170 =null;
		ParserRuleReturnScope join_columns173 =null;
		ParserRuleReturnScope from_item_basic175 =null;

		Object NATURAL166_tree=null;
		Object ON169_tree=null;
		Object USING171_tree=null;
		Object LBRAC172_tree=null;
		Object RBRAC174_tree=null;
		RewriteRuleTokenStream stream_USING=new RewriteRuleTokenStream(adaptor,"token USING");
		RewriteRuleTokenStream stream_LBRAC=new RewriteRuleTokenStream(adaptor,"token LBRAC");
		RewriteRuleTokenStream stream_NATURAL=new RewriteRuleTokenStream(adaptor,"token NATURAL");
		RewriteRuleTokenStream stream_RBRAC=new RewriteRuleTokenStream(adaptor,"token RBRAC");
		RewriteRuleTokenStream stream_ON=new RewriteRuleTokenStream(adaptor,"token ON");
		RewriteRuleSubtreeStream stream_join_type=new RewriteRuleSubtreeStream(adaptor,"rule join_type");
		RewriteRuleSubtreeStream stream_from_item=new RewriteRuleSubtreeStream(adaptor,"rule from_item");
		RewriteRuleSubtreeStream stream_join_columns=new RewriteRuleSubtreeStream(adaptor,"rule join_columns");
		RewriteRuleSubtreeStream stream_from_item_basic=new RewriteRuleSubtreeStream(adaptor,"rule from_item_basic");
		RewriteRuleSubtreeStream stream_join_condition=new RewriteRuleSubtreeStream(adaptor,"rule join_condition");

		try {
			// src/parser/sqlParser.g:122:13: ( from_item_basic ( NATURAL )? join_type from_item ( ON join_condition | USING LBRAC join_columns RBRAC )? -> ^( join_type from_item_basic from_item ( ^( ON join_condition ) )? ( ^( USING join_columns ) )? ) | from_item_basic )
			int alt38=2;
			switch ( input.LA(1) ) {
			case LBRAC:
				{
				int LA38_1 = input.LA(2);
				if ( (synpred74_sqlParser()) ) {
					alt38=1;
				}
				else if ( (true) ) {
					alt38=2;
				}

				}
				break;
			case ONLY:
				{
				int LA38_2 = input.LA(2);
				if ( (synpred74_sqlParser()) ) {
					alt38=1;
				}
				else if ( (true) ) {
					alt38=2;
				}

				}
				break;
			case ID:
				{
				int LA38_3 = input.LA(2);
				if ( (synpred74_sqlParser()) ) {
					alt38=1;
				}
				else if ( (true) ) {
					alt38=2;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA38_4 = input.LA(2);
				if ( (synpred74_sqlParser()) ) {
					alt38=1;
				}
				else if ( (true) ) {
					alt38=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// src/parser/sqlParser.g:122:15: from_item_basic ( NATURAL )? join_type from_item ( ON join_condition | USING LBRAC join_columns RBRAC )?
					{
					pushFollow(FOLLOW_from_item_basic_in_from_item1156);
					from_item_basic165=from_item_basic();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_from_item_basic.add(from_item_basic165.getTree());
					// src/parser/sqlParser.g:122:31: ( NATURAL )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==NATURAL) ) {
						alt36=1;
					}
					switch (alt36) {
						case 1 :
							// src/parser/sqlParser.g:122:31: NATURAL
							{
							NATURAL166=(Token)match(input,NATURAL,FOLLOW_NATURAL_in_from_item1158); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_NATURAL.add(NATURAL166);

							}
							break;

					}

					pushFollow(FOLLOW_join_type_in_from_item1161);
					join_type167=join_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_join_type.add(join_type167.getTree());
					pushFollow(FOLLOW_from_item_in_from_item1163);
					from_item168=from_item();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_from_item.add(from_item168.getTree());
					// src/parser/sqlParser.g:122:60: ( ON join_condition | USING LBRAC join_columns RBRAC )?
					int alt37=3;
					int LA37_0 = input.LA(1);
					if ( (LA37_0==ON) ) {
						int LA37_1 = input.LA(2);
						if ( (synpred72_sqlParser()) ) {
							alt37=1;
						}
					}
					else if ( (LA37_0==USING) ) {
						int LA37_2 = input.LA(2);
						if ( (synpred73_sqlParser()) ) {
							alt37=2;
						}
					}
					switch (alt37) {
						case 1 :
							// src/parser/sqlParser.g:122:62: ON join_condition
							{
							ON169=(Token)match(input,ON,FOLLOW_ON_in_from_item1167); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ON.add(ON169);

							pushFollow(FOLLOW_join_condition_in_from_item1169);
							join_condition170=join_condition();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_join_condition.add(join_condition170.getTree());
							}
							break;
						case 2 :
							// src/parser/sqlParser.g:122:82: USING LBRAC join_columns RBRAC
							{
							USING171=(Token)match(input,USING,FOLLOW_USING_in_from_item1173); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_USING.add(USING171);

							LBRAC172=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item1175); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LBRAC.add(LBRAC172);

							pushFollow(FOLLOW_join_columns_in_from_item1177);
							join_columns173=join_columns();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_join_columns.add(join_columns173.getTree());
							RBRAC174=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item1179); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RBRAC.add(RBRAC174);

							}
							break;

					}

					// AST REWRITE
					// elements: from_item, join_type, join_columns, from_item_basic, join_condition, USING, ON
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 123:3: -> ^( join_type from_item_basic from_item ( ^( ON join_condition ) )? ( ^( USING join_columns ) )? )
					{
						// src/parser/sqlParser.g:123:6: ^( join_type from_item_basic from_item ( ^( ON join_condition ) )? ( ^( USING join_columns ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_join_type.nextNode(), root_1);
						adaptor.addChild(root_1, stream_from_item_basic.nextTree());
						adaptor.addChild(root_1, stream_from_item.nextTree());
						// src/parser/sqlParser.g:123:44: ( ^( ON join_condition ) )?
						if ( stream_join_condition.hasNext()||stream_ON.hasNext() ) {
							// src/parser/sqlParser.g:123:44: ^( ON join_condition )
							{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot(stream_ON.nextNode(), root_2);
							adaptor.addChild(root_2, stream_join_condition.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_join_condition.reset();
						stream_ON.reset();

						// src/parser/sqlParser.g:123:67: ( ^( USING join_columns ) )?
						if ( stream_join_columns.hasNext()||stream_USING.hasNext() ) {
							// src/parser/sqlParser.g:123:67: ^( USING join_columns )
							{
							Object root_2 = (Object)adaptor.nil();
							root_2 = (Object)adaptor.becomeRoot(stream_USING.nextNode(), root_2);
							adaptor.addChild(root_2, stream_join_columns.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_join_columns.reset();
						stream_USING.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:124:8: from_item_basic
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_from_item_basic_in_from_item1218);
					from_item_basic175=from_item_basic();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, from_item_basic175.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "from_item"


	public static class from_item_basic_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "from_item_basic"
	// src/parser/sqlParser.g:131:1: from_item_basic : ( LBRAC select RBRAC ( AS )? alias ( LBRAC column_aliases RBRAC )? -> ^( alias select ( column_aliases )? ) | ( ONLY )? table_name ( star )? ( AS )? alias ( LBRAC column_aliases RBRAC )? -> ^( alias table_name ( column_aliases )? ) | ( ONLY )? table_name ( star )? -> ^( table_name ) | function_name LBRAC ( arguments )? RBRAC ( AS )? alias ( LBRAC column_aliases | column_definitions RBRAC )? | function_name LBRAC ( arguments )? RBRAC AS LBRAC column_definitions RBRAC );
	public final sqlParser.from_item_basic_return from_item_basic() throws RecognitionException {
		sqlParser.from_item_basic_return retval = new sqlParser.from_item_basic_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRAC176=null;
		Token RBRAC178=null;
		Token AS179=null;
		Token LBRAC181=null;
		Token RBRAC183=null;
		Token ONLY184=null;
		Token AS187=null;
		Token LBRAC189=null;
		Token RBRAC191=null;
		Token ONLY192=null;
		Token LBRAC196=null;
		Token RBRAC198=null;
		Token AS199=null;
		Token LBRAC201=null;
		Token RBRAC204=null;
		Token LBRAC206=null;
		Token RBRAC208=null;
		Token AS209=null;
		Token LBRAC210=null;
		Token RBRAC212=null;
		ParserRuleReturnScope select177 =null;
		ParserRuleReturnScope alias180 =null;
		ParserRuleReturnScope column_aliases182 =null;
		ParserRuleReturnScope table_name185 =null;
		ParserRuleReturnScope star186 =null;
		ParserRuleReturnScope alias188 =null;
		ParserRuleReturnScope column_aliases190 =null;
		ParserRuleReturnScope table_name193 =null;
		ParserRuleReturnScope star194 =null;
		ParserRuleReturnScope function_name195 =null;
		ParserRuleReturnScope arguments197 =null;
		ParserRuleReturnScope alias200 =null;
		ParserRuleReturnScope column_aliases202 =null;
		ParserRuleReturnScope column_definitions203 =null;
		ParserRuleReturnScope function_name205 =null;
		ParserRuleReturnScope arguments207 =null;
		ParserRuleReturnScope column_definitions211 =null;

		Object LBRAC176_tree=null;
		Object RBRAC178_tree=null;
		Object AS179_tree=null;
		Object LBRAC181_tree=null;
		Object RBRAC183_tree=null;
		Object ONLY184_tree=null;
		Object AS187_tree=null;
		Object LBRAC189_tree=null;
		Object RBRAC191_tree=null;
		Object ONLY192_tree=null;
		Object LBRAC196_tree=null;
		Object RBRAC198_tree=null;
		Object AS199_tree=null;
		Object LBRAC201_tree=null;
		Object RBRAC204_tree=null;
		Object LBRAC206_tree=null;
		Object RBRAC208_tree=null;
		Object AS209_tree=null;
		Object LBRAC210_tree=null;
		Object RBRAC212_tree=null;
		RewriteRuleTokenStream stream_LBRAC=new RewriteRuleTokenStream(adaptor,"token LBRAC");
		RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
		RewriteRuleTokenStream stream_RBRAC=new RewriteRuleTokenStream(adaptor,"token RBRAC");
		RewriteRuleTokenStream stream_ONLY=new RewriteRuleTokenStream(adaptor,"token ONLY");
		RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
		RewriteRuleSubtreeStream stream_column_aliases=new RewriteRuleSubtreeStream(adaptor,"rule column_aliases");
		RewriteRuleSubtreeStream stream_star=new RewriteRuleSubtreeStream(adaptor,"rule star");
		RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias");
		RewriteRuleSubtreeStream stream_table_name=new RewriteRuleSubtreeStream(adaptor,"rule table_name");

		try {
			// src/parser/sqlParser.g:131:19: ( LBRAC select RBRAC ( AS )? alias ( LBRAC column_aliases RBRAC )? -> ^( alias select ( column_aliases )? ) | ( ONLY )? table_name ( star )? ( AS )? alias ( LBRAC column_aliases RBRAC )? -> ^( alias table_name ( column_aliases )? ) | ( ONLY )? table_name ( star )? -> ^( table_name ) | function_name LBRAC ( arguments )? RBRAC ( AS )? alias ( LBRAC column_aliases | column_definitions RBRAC )? | function_name LBRAC ( arguments )? RBRAC AS LBRAC column_definitions RBRAC )
			int alt51=5;
			switch ( input.LA(1) ) {
			case LBRAC:
				{
				alt51=1;
				}
				break;
			case ONLY:
				{
				int LA51_2 = input.LA(2);
				if ( (synpred82_sqlParser()) ) {
					alt51=2;
				}
				else if ( (synpred85_sqlParser()) ) {
					alt51=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 51, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ID:
				{
				int LA51_3 = input.LA(2);
				if ( (synpred82_sqlParser()) ) {
					alt51=2;
				}
				else if ( (synpred85_sqlParser()) ) {
					alt51=3;
				}
				else if ( (synpred90_sqlParser()) ) {
					alt51=4;
				}
				else if ( (true) ) {
					alt51=5;
				}

				}
				break;
			case QUAL_ID:
				{
				int LA51_4 = input.LA(2);
				if ( (synpred82_sqlParser()) ) {
					alt51=2;
				}
				else if ( (synpred85_sqlParser()) ) {
					alt51=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 51, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}
			switch (alt51) {
				case 1 :
					// src/parser/sqlParser.g:132:3: LBRAC select RBRAC ( AS )? alias ( LBRAC column_aliases RBRAC )?
					{
					LBRAC176=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1240); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRAC.add(LBRAC176);

					pushFollow(FOLLOW_select_in_from_item_basic1242);
					select177=select();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_select.add(select177.getTree());
					RBRAC178=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1244); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRAC.add(RBRAC178);

					// src/parser/sqlParser.g:132:22: ( AS )?
					int alt39=2;
					int LA39_0 = input.LA(1);
					if ( (LA39_0==AS) ) {
						alt39=1;
					}
					switch (alt39) {
						case 1 :
							// src/parser/sqlParser.g:132:22: AS
							{
							AS179=(Token)match(input,AS,FOLLOW_AS_in_from_item_basic1246); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_AS.add(AS179);

							}
							break;

					}

					pushFollow(FOLLOW_alias_in_from_item_basic1249);
					alias180=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_alias.add(alias180.getTree());
					// src/parser/sqlParser.g:132:32: ( LBRAC column_aliases RBRAC )?
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==LBRAC) ) {
						alt40=1;
					}
					switch (alt40) {
						case 1 :
							// src/parser/sqlParser.g:132:34: LBRAC column_aliases RBRAC
							{
							LBRAC181=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1253); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LBRAC.add(LBRAC181);

							pushFollow(FOLLOW_column_aliases_in_from_item_basic1255);
							column_aliases182=column_aliases();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_column_aliases.add(column_aliases182.getTree());
							RBRAC183=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1257); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RBRAC.add(RBRAC183);

							}
							break;

					}

					// AST REWRITE
					// elements: alias, column_aliases, select
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 133:3: -> ^( alias select ( column_aliases )? )
					{
						// src/parser/sqlParser.g:133:6: ^( alias select ( column_aliases )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_alias.nextNode(), root_1);
						adaptor.addChild(root_1, stream_select.nextTree());
						// src/parser/sqlParser.g:133:21: ( column_aliases )?
						if ( stream_column_aliases.hasNext() ) {
							adaptor.addChild(root_1, stream_column_aliases.nextTree());
						}
						stream_column_aliases.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// src/parser/sqlParser.g:134:8: ( ONLY )? table_name ( star )? ( AS )? alias ( LBRAC column_aliases RBRAC )?
					{
					// src/parser/sqlParser.g:134:8: ( ONLY )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==ONLY) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// src/parser/sqlParser.g:134:8: ONLY
							{
							ONLY184=(Token)match(input,ONLY,FOLLOW_ONLY_in_from_item_basic1282); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ONLY.add(ONLY184);

							}
							break;

					}

					pushFollow(FOLLOW_table_name_in_from_item_basic1285);
					table_name185=table_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_name.add(table_name185.getTree());
					// src/parser/sqlParser.g:134:25: ( star )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==MULTIPLY) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// src/parser/sqlParser.g:134:25: star
							{
							pushFollow(FOLLOW_star_in_from_item_basic1287);
							star186=star();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_star.add(star186.getTree());
							}
							break;

					}

					// src/parser/sqlParser.g:134:31: ( AS )?
					int alt43=2;
					int LA43_0 = input.LA(1);
					if ( (LA43_0==AS) ) {
						alt43=1;
					}
					switch (alt43) {
						case 1 :
							// src/parser/sqlParser.g:134:31: AS
							{
							AS187=(Token)match(input,AS,FOLLOW_AS_in_from_item_basic1290); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_AS.add(AS187);

							}
							break;

					}

					pushFollow(FOLLOW_alias_in_from_item_basic1293);
					alias188=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_alias.add(alias188.getTree());
					// src/parser/sqlParser.g:134:41: ( LBRAC column_aliases RBRAC )?
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==LBRAC) ) {
						alt44=1;
					}
					switch (alt44) {
						case 1 :
							// src/parser/sqlParser.g:134:43: LBRAC column_aliases RBRAC
							{
							LBRAC189=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1297); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LBRAC.add(LBRAC189);

							pushFollow(FOLLOW_column_aliases_in_from_item_basic1299);
							column_aliases190=column_aliases();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_column_aliases.add(column_aliases190.getTree());
							RBRAC191=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1301); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RBRAC.add(RBRAC191);

							}
							break;

					}

					// AST REWRITE
					// elements: alias, table_name, column_aliases
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 135:3: -> ^( alias table_name ( column_aliases )? )
					{
						// src/parser/sqlParser.g:135:6: ^( alias table_name ( column_aliases )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_alias.nextNode(), root_1);
						adaptor.addChild(root_1, stream_table_name.nextTree());
						// src/parser/sqlParser.g:135:25: ( column_aliases )?
						if ( stream_column_aliases.hasNext() ) {
							adaptor.addChild(root_1, stream_column_aliases.nextTree());
						}
						stream_column_aliases.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// src/parser/sqlParser.g:136:8: ( ONLY )? table_name ( star )?
					{
					// src/parser/sqlParser.g:136:8: ( ONLY )?
					int alt45=2;
					int LA45_0 = input.LA(1);
					if ( (LA45_0==ONLY) ) {
						alt45=1;
					}
					switch (alt45) {
						case 1 :
							// src/parser/sqlParser.g:136:8: ONLY
							{
							ONLY192=(Token)match(input,ONLY,FOLLOW_ONLY_in_from_item_basic1326); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ONLY.add(ONLY192);

							}
							break;

					}

					pushFollow(FOLLOW_table_name_in_from_item_basic1329);
					table_name193=table_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_name.add(table_name193.getTree());
					// src/parser/sqlParser.g:136:25: ( star )?
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( (LA46_0==MULTIPLY) ) {
						alt46=1;
					}
					switch (alt46) {
						case 1 :
							// src/parser/sqlParser.g:136:25: star
							{
							pushFollow(FOLLOW_star_in_from_item_basic1331);
							star194=star();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_star.add(star194.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: table_name
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 137:7: -> ^( table_name )
					{
						// src/parser/sqlParser.g:137:10: ^( table_name )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot(stream_table_name.nextNode(), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// src/parser/sqlParser.g:138:8: function_name LBRAC ( arguments )? RBRAC ( AS )? alias ( LBRAC column_aliases | column_definitions RBRAC )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_name_in_from_item_basic1353);
					function_name195=function_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_name195.getTree());

					LBRAC196=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1355); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRAC196_tree = (Object)adaptor.create(LBRAC196);
					adaptor.addChild(root_0, LBRAC196_tree);
					}

					// src/parser/sqlParser.g:138:28: ( arguments )?
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==FLOAT||LA47_0==ID||LA47_0==INT) ) {
						alt47=1;
					}
					switch (alt47) {
						case 1 :
							// src/parser/sqlParser.g:138:28: arguments
							{
							pushFollow(FOLLOW_arguments_in_from_item_basic1357);
							arguments197=arguments();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, arguments197.getTree());

							}
							break;

					}

					RBRAC198=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1360); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRAC198_tree = (Object)adaptor.create(RBRAC198);
					adaptor.addChild(root_0, RBRAC198_tree);
					}

					// src/parser/sqlParser.g:138:45: ( AS )?
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==AS) ) {
						alt48=1;
					}
					switch (alt48) {
						case 1 :
							// src/parser/sqlParser.g:138:45: AS
							{
							AS199=(Token)match(input,AS,FOLLOW_AS_in_from_item_basic1362); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							AS199_tree = (Object)adaptor.create(AS199);
							adaptor.addChild(root_0, AS199_tree);
							}

							}
							break;

					}

					pushFollow(FOLLOW_alias_in_from_item_basic1365);
					alias200=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, alias200.getTree());

					// src/parser/sqlParser.g:138:55: ( LBRAC column_aliases | column_definitions RBRAC )?
					int alt49=3;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==LBRAC) ) {
						alt49=1;
					}
					else if ( (LA49_0==ID||LA49_0==QUAL_ID) ) {
						alt49=2;
					}
					switch (alt49) {
						case 1 :
							// src/parser/sqlParser.g:138:57: LBRAC column_aliases
							{
							LBRAC201=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1369); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LBRAC201_tree = (Object)adaptor.create(LBRAC201);
							adaptor.addChild(root_0, LBRAC201_tree);
							}

							pushFollow(FOLLOW_column_aliases_in_from_item_basic1371);
							column_aliases202=column_aliases();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, column_aliases202.getTree());

							}
							break;
						case 2 :
							// src/parser/sqlParser.g:138:80: column_definitions RBRAC
							{
							pushFollow(FOLLOW_column_definitions_in_from_item_basic1375);
							column_definitions203=column_definitions();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, column_definitions203.getTree());

							RBRAC204=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1377); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							RBRAC204_tree = (Object)adaptor.create(RBRAC204);
							adaptor.addChild(root_0, RBRAC204_tree);
							}

							}
							break;

					}

					}
					break;
				case 5 :
					// src/parser/sqlParser.g:139:8: function_name LBRAC ( arguments )? RBRAC AS LBRAC column_definitions RBRAC
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_name_in_from_item_basic1389);
					function_name205=function_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_name205.getTree());

					LBRAC206=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1391); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRAC206_tree = (Object)adaptor.create(LBRAC206);
					adaptor.addChild(root_0, LBRAC206_tree);
					}

					// src/parser/sqlParser.g:139:28: ( arguments )?
					int alt50=2;
					int LA50_0 = input.LA(1);
					if ( (LA50_0==FLOAT||LA50_0==ID||LA50_0==INT) ) {
						alt50=1;
					}
					switch (alt50) {
						case 1 :
							// src/parser/sqlParser.g:139:28: arguments
							{
							pushFollow(FOLLOW_arguments_in_from_item_basic1393);
							arguments207=arguments();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, arguments207.getTree());

							}
							break;

					}

					RBRAC208=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1396); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRAC208_tree = (Object)adaptor.create(RBRAC208);
					adaptor.addChild(root_0, RBRAC208_tree);
					}

					AS209=(Token)match(input,AS,FOLLOW_AS_in_from_item_basic1398); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AS209_tree = (Object)adaptor.create(AS209);
					adaptor.addChild(root_0, AS209_tree);
					}

					LBRAC210=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_from_item_basic1400); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRAC210_tree = (Object)adaptor.create(LBRAC210);
					adaptor.addChild(root_0, LBRAC210_tree);
					}

					pushFollow(FOLLOW_column_definitions_in_from_item_basic1402);
					column_definitions211=column_definitions();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, column_definitions211.getTree());

					RBRAC212=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_from_item_basic1404); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRAC212_tree = (Object)adaptor.create(RBRAC212);
					adaptor.addChild(root_0, RBRAC212_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "from_item_basic"

	// $ANTLR start synpred29_sqlParser
	public final void synpred29_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:37:4: ( LBRAC expression RBRAC operator expression )
		// src/parser/sqlParser.g:37:4: LBRAC expression RBRAC operator expression
		{
		match(input,LBRAC,FOLLOW_LBRAC_in_synpred29_sqlParser337); if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred29_sqlParser340);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred29_sqlParser342); if (state.failed) return;

		pushFollow(FOLLOW_operator_in_synpred29_sqlParser345);
		operator();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred29_sqlParser348);
		expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred29_sqlParser

	// $ANTLR start synpred30_sqlParser
	public final void synpred30_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:38:4: ( LBRAC expression RBRAC )
		// src/parser/sqlParser.g:38:4: LBRAC expression RBRAC
		{
		match(input,LBRAC,FOLLOW_LBRAC_in_synpred30_sqlParser353); if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred30_sqlParser356);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred30_sqlParser358); if (state.failed) return;

		}

	}
	// $ANTLR end synpred30_sqlParser

	// $ANTLR start synpred32_sqlParser
	public final void synpred32_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:40:4: ( function LBRAC expressions RBRAC )
		// src/parser/sqlParser.g:40:4: function LBRAC expressions RBRAC
		{
		pushFollow(FOLLOW_function_in_synpred32_sqlParser372);
		function();
		state._fsp--;
		if (state.failed) return;

		match(input,LBRAC,FOLLOW_LBRAC_in_synpred32_sqlParser374); if (state.failed) return;

		pushFollow(FOLLOW_expressions_in_synpred32_sqlParser376);
		expressions();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred32_sqlParser378); if (state.failed) return;

		}

	}
	// $ANTLR end synpred32_sqlParser

	// $ANTLR start synpred33_sqlParser
	public final void synpred33_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:41:4: ( column_name )
		// src/parser/sqlParser.g:41:4: column_name
		{
		pushFollow(FOLLOW_column_name_in_synpred33_sqlParser393);
		column_name();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred33_sqlParser

	// $ANTLR start synpred36_sqlParser
	public final void synpred36_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:52:24: ( aliased_expression )
		// src/parser/sqlParser.g:52:24: aliased_expression
		{
		pushFollow(FOLLOW_aliased_expression_in_synpred36_sqlParser457);
		aliased_expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred36_sqlParser

	// $ANTLR start synpred37_sqlParser
	public final void synpred37_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:52:23: ( ( aliased_expression | expression ) COMMA aliased_expressions )
		// src/parser/sqlParser.g:52:23: ( aliased_expression | expression ) COMMA aliased_expressions
		{
		// src/parser/sqlParser.g:52:23: ( aliased_expression | expression )
		int alt56=2;
		switch ( input.LA(1) ) {
		case AVG:
		case COUNT:
		case MAX:
		case MIN:
		case SUM:
			{
			int LA56_1 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case LBRAC:
			{
			int LA56_2 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case DISTINCT:
			{
			int LA56_3 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case ID:
			{
			int LA56_4 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case QUAL_ID:
			{
			int LA56_5 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case INT:
			{
			int LA56_6 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case FLOAT:
			{
			int LA56_7 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		case VARCHAR:
			{
			int LA56_8 = input.LA(2);
			if ( (synpred36_sqlParser()) ) {
				alt56=1;
			}
			else if ( (true) ) {
				alt56=2;
			}

			}
			break;
		default:
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 56, 0, input);
			throw nvae;
		}
		switch (alt56) {
			case 1 :
				// src/parser/sqlParser.g:52:24: aliased_expression
				{
				pushFollow(FOLLOW_aliased_expression_in_synpred37_sqlParser457);
				aliased_expression();
				state._fsp--;
				if (state.failed) return;

				}
				break;
			case 2 :
				// src/parser/sqlParser.g:52:45: expression
				{
				pushFollow(FOLLOW_expression_in_synpred37_sqlParser461);
				expression();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,COMMA,FOLLOW_COMMA_in_synpred37_sqlParser465); if (state.failed) return;

		pushFollow(FOLLOW_aliased_expressions_in_synpred37_sqlParser468);
		aliased_expressions();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred37_sqlParser

	// $ANTLR start synpred38_sqlParser
	public final void synpred38_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:53:10: ( aliased_expression )
		// src/parser/sqlParser.g:53:10: aliased_expression
		{
		pushFollow(FOLLOW_aliased_expression_in_synpred38_sqlParser479);
		aliased_expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred38_sqlParser

	// $ANTLR start synpred39_sqlParser
	public final void synpred39_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:55:23: ( expression AS alias )
		// src/parser/sqlParser.g:55:23: expression AS alias
		{
		pushFollow(FOLLOW_expression_in_synpred39_sqlParser495);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,AS,FOLLOW_AS_in_synpred39_sqlParser497); if (state.failed) return;

		pushFollow(FOLLOW_alias_in_synpred39_sqlParser499);
		alias();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred39_sqlParser

	// $ANTLR start synpred40_sqlParser
	public final void synpred40_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:58:15: ( expression COMMA expressions )
		// src/parser/sqlParser.g:58:15: expression COMMA expressions
		{
		pushFollow(FOLLOW_expression_in_synpred40_sqlParser541);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,COMMA,FOLLOW_COMMA_in_synpred40_sqlParser544); if (state.failed) return;

		pushFollow(FOLLOW_expressions_in_synpred40_sqlParser548);
		expressions();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred40_sqlParser

	// $ANTLR start synpred41_sqlParser
	public final void synpred41_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:66:16: ( simple_operand operator expression )
		// src/parser/sqlParser.g:66:16: simple_operand operator expression
		{
		pushFollow(FOLLOW_simple_operand_in_synpred41_sqlParser579);
		simple_operand();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_operator_in_synpred41_sqlParser581);
		operator();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred41_sqlParser584);
		expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred41_sqlParser

	// $ANTLR start synpred44_sqlParser
	public final void synpred44_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:71:23: ( expression ( ASC | DESC | USING order_operator ) order_expression )
		// src/parser/sqlParser.g:71:23: expression ( ASC | DESC | USING order_operator ) order_expression
		{
		pushFollow(FOLLOW_expression_in_synpred44_sqlParser612);
		expression();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:71:34: ( ASC | DESC | USING order_operator )
		int alt57=3;
		switch ( input.LA(1) ) {
		case ASC:
			{
			alt57=1;
			}
			break;
		case DESC:
			{
			alt57=2;
			}
			break;
		case USING:
			{
			alt57=3;
			}
			break;
		default:
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 57, 0, input);
			throw nvae;
		}
		switch (alt57) {
			case 1 :
				// src/parser/sqlParser.g:71:36: ASC
				{
				match(input,ASC,FOLLOW_ASC_in_synpred44_sqlParser616); if (state.failed) return;

				}
				break;
			case 2 :
				// src/parser/sqlParser.g:71:42: DESC
				{
				match(input,DESC,FOLLOW_DESC_in_synpred44_sqlParser620); if (state.failed) return;

				}
				break;
			case 3 :
				// src/parser/sqlParser.g:71:49: USING order_operator
				{
				match(input,USING,FOLLOW_USING_in_synpred44_sqlParser624); if (state.failed) return;

				pushFollow(FOLLOW_order_operator_in_synpred44_sqlParser626);
				order_operator();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_order_expression_in_synpred44_sqlParser630);
		order_expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred44_sqlParser

	// $ANTLR start synpred47_sqlParser
	public final void synpred47_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:74:15: ( condition COMMA conditions )
		// src/parser/sqlParser.g:74:15: condition COMMA conditions
		{
		pushFollow(FOLLOW_condition_in_synpred47_sqlParser666);
		condition();
		state._fsp--;
		if (state.failed) return;

		match(input,COMMA,FOLLOW_COMMA_in_synpred47_sqlParser670); if (state.failed) return;

		pushFollow(FOLLOW_conditions_in_synpred47_sqlParser674);
		conditions();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred47_sqlParser

	// $ANTLR start synpred48_sqlParser
	public final void synpred48_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:77:15: ( LBRAC condition RBRAC AND condition )
		// src/parser/sqlParser.g:77:15: LBRAC condition RBRAC AND condition
		{
		match(input,LBRAC,FOLLOW_LBRAC_in_synpred48_sqlParser694); if (state.failed) return;

		pushFollow(FOLLOW_condition_in_synpred48_sqlParser697);
		condition();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred48_sqlParser699); if (state.failed) return;

		match(input,AND,FOLLOW_AND_in_synpred48_sqlParser702); if (state.failed) return;

		pushFollow(FOLLOW_condition_in_synpred48_sqlParser706);
		condition();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred48_sqlParser

	// $ANTLR start synpred49_sqlParser
	public final void synpred49_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:78:8: ( expression comparator expression AND condition )
		// src/parser/sqlParser.g:78:8: expression comparator expression AND condition
		{
		pushFollow(FOLLOW_expression_in_synpred49_sqlParser715);
		expression();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_comparator_in_synpred49_sqlParser717);
		comparator();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred49_sqlParser720);
		expression();
		state._fsp--;
		if (state.failed) return;

		match(input,AND,FOLLOW_AND_in_synpred49_sqlParser722); if (state.failed) return;

		pushFollow(FOLLOW_condition_in_synpred49_sqlParser725);
		condition();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred49_sqlParser

	// $ANTLR start synpred50_sqlParser
	public final void synpred50_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:79:8: ( LBRAC condition RBRAC )
		// src/parser/sqlParser.g:79:8: LBRAC condition RBRAC
		{
		match(input,LBRAC,FOLLOW_LBRAC_in_synpred50_sqlParser734); if (state.failed) return;

		pushFollow(FOLLOW_condition_in_synpred50_sqlParser737);
		condition();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred50_sqlParser739); if (state.failed) return;

		}

	}
	// $ANTLR end synpred50_sqlParser

	// $ANTLR start synpred60_sqlParser
	public final void synpred60_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:93:33: ( DISTINCT ( ON LBRAC expressions RBRAC )? )
		// src/parser/sqlParser.g:93:33: DISTINCT ( ON LBRAC expressions RBRAC )?
		{
		match(input,DISTINCT,FOLLOW_DISTINCT_in_synpred60_sqlParser850); if (state.failed) return;

		// src/parser/sqlParser.g:93:42: ( ON LBRAC expressions RBRAC )?
		int alt58=2;
		int LA58_0 = input.LA(1);
		if ( (LA58_0==ON) ) {
			alt58=1;
		}
		switch (alt58) {
			case 1 :
				// src/parser/sqlParser.g:93:44: ON LBRAC expressions RBRAC
				{
				match(input,ON,FOLLOW_ON_in_synpred60_sqlParser854); if (state.failed) return;

				match(input,LBRAC,FOLLOW_LBRAC_in_synpred60_sqlParser857); if (state.failed) return;

				pushFollow(FOLLOW_expressions_in_synpred60_sqlParser860);
				expressions();
				state._fsp--;
				if (state.failed) return;

				match(input,RBRAC,FOLLOW_RBRAC_in_synpred60_sqlParser862); if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred60_sqlParser

	// $ANTLR start synpred66_sqlParser
	public final void synpred66_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:103:18: ( column_alias COMMA column_aliases )
		// src/parser/sqlParser.g:103:18: column_alias COMMA column_aliases
		{
		pushFollow(FOLLOW_column_alias_in_synpred66_sqlParser1027);
		column_alias();
		state._fsp--;
		if (state.failed) return;

		match(input,COMMA,FOLLOW_COMMA_in_synpred66_sqlParser1029); if (state.failed) return;

		pushFollow(FOLLOW_column_aliases_in_synpred66_sqlParser1032);
		column_aliases();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred66_sqlParser

	// $ANTLR start synpred70_sqlParser
	public final void synpred70_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:119:14: ( from_item COMMA from_items )
		// src/parser/sqlParser.g:119:14: from_item COMMA from_items
		{
		pushFollow(FOLLOW_from_item_in_synpred70_sqlParser1134);
		from_item();
		state._fsp--;
		if (state.failed) return;

		match(input,COMMA,FOLLOW_COMMA_in_synpred70_sqlParser1136); if (state.failed) return;

		pushFollow(FOLLOW_from_items_in_synpred70_sqlParser1139);
		from_items();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred70_sqlParser

	// $ANTLR start synpred72_sqlParser
	public final void synpred72_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:122:62: ( ON join_condition )
		// src/parser/sqlParser.g:122:62: ON join_condition
		{
		match(input,ON,FOLLOW_ON_in_synpred72_sqlParser1167); if (state.failed) return;

		pushFollow(FOLLOW_join_condition_in_synpred72_sqlParser1169);
		join_condition();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred72_sqlParser

	// $ANTLR start synpred73_sqlParser
	public final void synpred73_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:122:82: ( USING LBRAC join_columns RBRAC )
		// src/parser/sqlParser.g:122:82: USING LBRAC join_columns RBRAC
		{
		match(input,USING,FOLLOW_USING_in_synpred73_sqlParser1173); if (state.failed) return;

		match(input,LBRAC,FOLLOW_LBRAC_in_synpred73_sqlParser1175); if (state.failed) return;

		pushFollow(FOLLOW_join_columns_in_synpred73_sqlParser1177);
		join_columns();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred73_sqlParser1179); if (state.failed) return;

		}

	}
	// $ANTLR end synpred73_sqlParser

	// $ANTLR start synpred74_sqlParser
	public final void synpred74_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:122:15: ( from_item_basic ( NATURAL )? join_type from_item ( ON join_condition | USING LBRAC join_columns RBRAC )? )
		// src/parser/sqlParser.g:122:15: from_item_basic ( NATURAL )? join_type from_item ( ON join_condition | USING LBRAC join_columns RBRAC )?
		{
		pushFollow(FOLLOW_from_item_basic_in_synpred74_sqlParser1156);
		from_item_basic();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:122:31: ( NATURAL )?
		int alt59=2;
		int LA59_0 = input.LA(1);
		if ( (LA59_0==NATURAL) ) {
			alt59=1;
		}
		switch (alt59) {
			case 1 :
				// src/parser/sqlParser.g:122:31: NATURAL
				{
				match(input,NATURAL,FOLLOW_NATURAL_in_synpred74_sqlParser1158); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_join_type_in_synpred74_sqlParser1161);
		join_type();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_from_item_in_synpred74_sqlParser1163);
		from_item();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:122:60: ( ON join_condition | USING LBRAC join_columns RBRAC )?
		int alt60=3;
		int LA60_0 = input.LA(1);
		if ( (LA60_0==ON) ) {
			alt60=1;
		}
		else if ( (LA60_0==USING) ) {
			alt60=2;
		}
		switch (alt60) {
			case 1 :
				// src/parser/sqlParser.g:122:62: ON join_condition
				{
				match(input,ON,FOLLOW_ON_in_synpred74_sqlParser1167); if (state.failed) return;

				pushFollow(FOLLOW_join_condition_in_synpred74_sqlParser1169);
				join_condition();
				state._fsp--;
				if (state.failed) return;

				}
				break;
			case 2 :
				// src/parser/sqlParser.g:122:82: USING LBRAC join_columns RBRAC
				{
				match(input,USING,FOLLOW_USING_in_synpred74_sqlParser1173); if (state.failed) return;

				match(input,LBRAC,FOLLOW_LBRAC_in_synpred74_sqlParser1175); if (state.failed) return;

				pushFollow(FOLLOW_join_columns_in_synpred74_sqlParser1177);
				join_columns();
				state._fsp--;
				if (state.failed) return;

				match(input,RBRAC,FOLLOW_RBRAC_in_synpred74_sqlParser1179); if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred74_sqlParser

	// $ANTLR start synpred82_sqlParser
	public final void synpred82_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:134:8: ( ( ONLY )? table_name ( star )? ( AS )? alias ( LBRAC column_aliases RBRAC )? )
		// src/parser/sqlParser.g:134:8: ( ONLY )? table_name ( star )? ( AS )? alias ( LBRAC column_aliases RBRAC )?
		{
		// src/parser/sqlParser.g:134:8: ( ONLY )?
		int alt63=2;
		int LA63_0 = input.LA(1);
		if ( (LA63_0==ONLY) ) {
			alt63=1;
		}
		switch (alt63) {
			case 1 :
				// src/parser/sqlParser.g:134:8: ONLY
				{
				match(input,ONLY,FOLLOW_ONLY_in_synpred82_sqlParser1282); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_table_name_in_synpred82_sqlParser1285);
		table_name();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:134:25: ( star )?
		int alt64=2;
		int LA64_0 = input.LA(1);
		if ( (LA64_0==MULTIPLY) ) {
			alt64=1;
		}
		switch (alt64) {
			case 1 :
				// src/parser/sqlParser.g:134:25: star
				{
				pushFollow(FOLLOW_star_in_synpred82_sqlParser1287);
				star();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		// src/parser/sqlParser.g:134:31: ( AS )?
		int alt65=2;
		int LA65_0 = input.LA(1);
		if ( (LA65_0==AS) ) {
			alt65=1;
		}
		switch (alt65) {
			case 1 :
				// src/parser/sqlParser.g:134:31: AS
				{
				match(input,AS,FOLLOW_AS_in_synpred82_sqlParser1290); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_alias_in_synpred82_sqlParser1293);
		alias();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:134:41: ( LBRAC column_aliases RBRAC )?
		int alt66=2;
		int LA66_0 = input.LA(1);
		if ( (LA66_0==LBRAC) ) {
			alt66=1;
		}
		switch (alt66) {
			case 1 :
				// src/parser/sqlParser.g:134:43: LBRAC column_aliases RBRAC
				{
				match(input,LBRAC,FOLLOW_LBRAC_in_synpred82_sqlParser1297); if (state.failed) return;

				pushFollow(FOLLOW_column_aliases_in_synpred82_sqlParser1299);
				column_aliases();
				state._fsp--;
				if (state.failed) return;

				match(input,RBRAC,FOLLOW_RBRAC_in_synpred82_sqlParser1301); if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred82_sqlParser

	// $ANTLR start synpred85_sqlParser
	public final void synpred85_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:136:8: ( ( ONLY )? table_name ( star )? )
		// src/parser/sqlParser.g:136:8: ( ONLY )? table_name ( star )?
		{
		// src/parser/sqlParser.g:136:8: ( ONLY )?
		int alt67=2;
		int LA67_0 = input.LA(1);
		if ( (LA67_0==ONLY) ) {
			alt67=1;
		}
		switch (alt67) {
			case 1 :
				// src/parser/sqlParser.g:136:8: ONLY
				{
				match(input,ONLY,FOLLOW_ONLY_in_synpred85_sqlParser1326); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_table_name_in_synpred85_sqlParser1329);
		table_name();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:136:25: ( star )?
		int alt68=2;
		int LA68_0 = input.LA(1);
		if ( (LA68_0==MULTIPLY) ) {
			alt68=1;
		}
		switch (alt68) {
			case 1 :
				// src/parser/sqlParser.g:136:25: star
				{
				pushFollow(FOLLOW_star_in_synpred85_sqlParser1331);
				star();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred85_sqlParser

	// $ANTLR start synpred90_sqlParser
	public final void synpred90_sqlParser_fragment() throws RecognitionException {
		// src/parser/sqlParser.g:138:8: ( function_name LBRAC ( arguments )? RBRAC ( AS )? alias ( LBRAC column_aliases | column_definitions RBRAC )? )
		// src/parser/sqlParser.g:138:8: function_name LBRAC ( arguments )? RBRAC ( AS )? alias ( LBRAC column_aliases | column_definitions RBRAC )?
		{
		pushFollow(FOLLOW_function_name_in_synpred90_sqlParser1353);
		function_name();
		state._fsp--;
		if (state.failed) return;

		match(input,LBRAC,FOLLOW_LBRAC_in_synpred90_sqlParser1355); if (state.failed) return;

		// src/parser/sqlParser.g:138:28: ( arguments )?
		int alt69=2;
		int LA69_0 = input.LA(1);
		if ( (LA69_0==FLOAT||LA69_0==ID||LA69_0==INT) ) {
			alt69=1;
		}
		switch (alt69) {
			case 1 :
				// src/parser/sqlParser.g:138:28: arguments
				{
				pushFollow(FOLLOW_arguments_in_synpred90_sqlParser1357);
				arguments();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		match(input,RBRAC,FOLLOW_RBRAC_in_synpred90_sqlParser1360); if (state.failed) return;

		// src/parser/sqlParser.g:138:45: ( AS )?
		int alt70=2;
		int LA70_0 = input.LA(1);
		if ( (LA70_0==AS) ) {
			alt70=1;
		}
		switch (alt70) {
			case 1 :
				// src/parser/sqlParser.g:138:45: AS
				{
				match(input,AS,FOLLOW_AS_in_synpred90_sqlParser1362); if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_alias_in_synpred90_sqlParser1365);
		alias();
		state._fsp--;
		if (state.failed) return;

		// src/parser/sqlParser.g:138:55: ( LBRAC column_aliases | column_definitions RBRAC )?
		int alt71=3;
		int LA71_0 = input.LA(1);
		if ( (LA71_0==LBRAC) ) {
			alt71=1;
		}
		else if ( (LA71_0==ID||LA71_0==QUAL_ID) ) {
			alt71=2;
		}
		switch (alt71) {
			case 1 :
				// src/parser/sqlParser.g:138:57: LBRAC column_aliases
				{
				match(input,LBRAC,FOLLOW_LBRAC_in_synpred90_sqlParser1369); if (state.failed) return;

				pushFollow(FOLLOW_column_aliases_in_synpred90_sqlParser1371);
				column_aliases();
				state._fsp--;
				if (state.failed) return;

				}
				break;
			case 2 :
				// src/parser/sqlParser.g:138:80: column_definitions RBRAC
				{
				pushFollow(FOLLOW_column_definitions_in_synpred90_sqlParser1375);
				column_definitions();
				state._fsp--;
				if (state.failed) return;

				match(input,RBRAC,FOLLOW_RBRAC_in_synpred90_sqlParser1377); if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred90_sqlParser

	// Delegated rules

	public final boolean synpred70_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred70_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred32_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred32_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred47_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred47_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred39_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred39_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred72_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred72_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred66_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred66_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred38_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred38_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred73_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred73_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred33_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred33_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred60_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred60_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred85_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred85_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred40_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred40_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred37_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred37_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred74_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred74_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred41_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred41_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred44_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred44_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred48_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred48_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred49_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred49_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred90_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred90_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred50_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred50_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred29_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred29_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred36_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred36_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred82_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred82_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred30_sqlParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred30_sqlParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_UNKNOWN_in_type161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_column_alias169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_alias178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_name186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INNER_in_join_type225 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_JOIN_in_join_type228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_in_join_type243 = new BitSet(new long[]{0x0800004000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_type245 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_JOIN_in_join_type248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHT_in_join_type263 = new BitSet(new long[]{0x0800004000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_type265 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_JOIN_in_join_type268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_in_join_type283 = new BitSet(new long[]{0x0800004000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_type285 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_JOIN_in_join_type288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CROSS_in_join_type303 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_JOIN_in_join_type305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aggregator_in_simple_operand323 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_simple_operand326 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_simple_operand329 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_simple_operand331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_simple_operand337 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_simple_operand340 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_simple_operand342 = new BitSet(new long[]{0x1001800000042000L});
	public static final BitSet FOLLOW_operator_in_simple_operand345 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_simple_operand348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_simple_operand353 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_simple_operand356 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_simple_operand358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_simple_operand364 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_simple_operand367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_simple_operand372 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_simple_operand374 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_simple_operand376 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_simple_operand378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_simple_operand393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_simple_operand398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_simple_operand403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARCHAR_in_simple_operand408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_count423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_start435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULTIPLY_in_star447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aliased_expression_in_aliased_expressions457 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_expression_in_aliased_expressions461 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_aliased_expressions465 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_aliased_expressions_in_aliased_expressions468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aliased_expression_in_aliased_expressions479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_aliased_expressions483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_aliased_expression495 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_AS_in_aliased_expression497 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_aliased_expression499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_aliased_expression520 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_aliased_expression522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_expressions541 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_expressions544 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_expressions548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_expressions557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_operand_in_expression579 = new BitSet(new long[]{0x1001800000042000L});
	public static final BitSet FOLLOW_operator_in_expression581 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_expression584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_operand_in_expression594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_order_expression612 = new BitSet(new long[]{0x0000000000010080L,0x0000000000000100L});
	public static final BitSet FOLLOW_ASC_in_order_expression616 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_DESC_in_order_expression620 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_USING_in_order_expression624 = new BitSet(new long[]{0x0000100080000000L});
	public static final BitSet FOLLOW_order_operator_in_order_expression626 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_order_expression_in_order_expression630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_order_expression640 = new BitSet(new long[]{0x0000000000010080L,0x0000000000000100L});
	public static final BitSet FOLLOW_ASC_in_order_expression644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_order_expression648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USING_in_order_expression652 = new BitSet(new long[]{0x0000100080000000L});
	public static final BitSet FOLLOW_order_operator_in_order_expression654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_conditions666 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_conditions670 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_conditions_in_conditions674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_conditions683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_condition694 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_condition697 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_condition699 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_condition702 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_condition706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_condition715 = new BitSet(new long[]{0x00041600A0100000L});
	public static final BitSet FOLLOW_comparator_in_condition717 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_condition720 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_condition722 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_condition725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_condition734 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_condition737 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_condition739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_condition749 = new BitSet(new long[]{0x00041600A0100000L});
	public static final BitSet FOLLOW_comparator_in_condition751 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_condition754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_block_in_select770 = new BitSet(new long[]{0x0040082144400002L,0x0000000000000420L});
	public static final BitSet FOLLOW_from_block_in_select777 = new BitSet(new long[]{0x0040082140400002L,0x0000000000000420L});
	public static final BitSet FOLLOW_where_block_in_select785 = new BitSet(new long[]{0x0040082140400002L,0x0000000000000020L});
	public static final BitSet FOLLOW_group_block_in_select793 = new BitSet(new long[]{0x0040082100400002L,0x0000000000000020L});
	public static final BitSet FOLLOW_having_block_in_select801 = new BitSet(new long[]{0x0040082000400002L,0x0000000000000020L});
	public static final BitSet FOLLOW_union_intersect_except_block_in_select809 = new BitSet(new long[]{0x0040080000000002L});
	public static final BitSet FOLLOW_limit_block_in_select817 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_offset_block_in_select825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_select_block842 = new BitSet(new long[]{0x2001609401024110L,0x0000000000000208L});
	public static final BitSet FOLLOW_ALL_in_select_block846 = new BitSet(new long[]{0x2001609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_DISTINCT_in_select_block850 = new BitSet(new long[]{0x2081609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_ON_in_select_block854 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_select_block857 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_select_block860 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_select_block862 = new BitSet(new long[]{0x2001609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_star_in_select_block872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aliased_expressions_in_select_block876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_from_block887 = new BitSet(new long[]{0x2100008400000000L});
	public static final BitSet FOLLOW_from_items_in_from_block890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_where_block900 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_where_block903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_group_block913 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_BY_in_group_block916 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_group_block919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HAVING_in_having_block929 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_conditions_in_having_block932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNION_in_union_intersect_except_block942 = new BitSet(new long[]{0x0000008000000010L});
	public static final BitSet FOLLOW_INTERSECT_in_union_intersect_except_block947 = new BitSet(new long[]{0x0000008000000010L});
	public static final BitSet FOLLOW_EXCEPT_in_union_intersect_except_block952 = new BitSet(new long[]{0x0000008000000010L});
	public static final BitSet FOLLOW_ALL_in_union_intersect_except_block957 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_union_intersect_except_block961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_select_in_union_intersect_except_block964 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_union_intersect_except_block966 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_in_order_block977 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_BY_in_order_block980 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_order_expression_in_order_block983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_limit_block993 = new BitSet(new long[]{0x0000001000000010L});
	public static final BitSet FOLLOW_count_in_limit_block998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_limit_block1002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OFFSET_in_offset_block1014 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_start_in_offset_block1017 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_alias_in_column_aliases1027 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_column_aliases1029 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_column_aliases1032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_alias_in_column_aliases1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argument_in_arguments1047 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_arguments1049 = new BitSet(new long[]{0x0000001401000000L});
	public static final BitSet FOLLOW_arguments_in_arguments1052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argument_in_arguments1058 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_definition_in_column_definitions1068 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_column_definitions1070 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_column_definitions_in_column_definitions1073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_definition_in_column_definitions1083 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_column_definition1094 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_type_in_column_definition1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_join_columns1105 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_join_columns1107 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_join_columns_in_join_columns1110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_join_columns1116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_join_condition1125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_item_in_from_items1134 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_from_items1136 = new BitSet(new long[]{0x2100008400000000L});
	public static final BitSet FOLLOW_from_items_in_from_items1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_item_in_from_items1145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_item_basic_in_from_item1156 = new BitSet(new long[]{0x8002014808008000L});
	public static final BitSet FOLLOW_NATURAL_in_from_item1158 = new BitSet(new long[]{0x8000014808008000L});
	public static final BitSet FOLLOW_join_type_in_from_item1161 = new BitSet(new long[]{0x2100008400000000L});
	public static final BitSet FOLLOW_from_item_in_from_item1163 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_ON_in_from_item1167 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_join_condition_in_from_item1169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USING_in_from_item1173 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_from_item1175 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_join_columns_in_from_item1177 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_item_basic_in_from_item1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_select_in_from_item_basic1242 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1244 = new BitSet(new long[]{0x0000000400000040L});
	public static final BitSet FOLLOW_AS_in_from_item_basic1246 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_from_item_basic1249 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1253 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_from_item_basic1255 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ONLY_in_from_item_basic1282 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_table_name_in_from_item_basic1285 = new BitSet(new long[]{0x0001000400000040L});
	public static final BitSet FOLLOW_star_in_from_item_basic1287 = new BitSet(new long[]{0x0000000400000040L});
	public static final BitSet FOLLOW_AS_in_from_item_basic1290 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_from_item_basic1293 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1297 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_from_item_basic1299 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ONLY_in_from_item_basic1326 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_table_name_in_from_item_basic1329 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_star_in_from_item_basic1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_name_in_from_item_basic1353 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1355 = new BitSet(new long[]{0x4000001401000000L});
	public static final BitSet FOLLOW_arguments_in_from_item_basic1357 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1360 = new BitSet(new long[]{0x0000000400000040L});
	public static final BitSet FOLLOW_AS_in_from_item_basic1362 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_from_item_basic1365 = new BitSet(new long[]{0x2000008400000002L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1369 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_from_item_basic1371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_definitions_in_from_item_basic1375 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_name_in_from_item_basic1389 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1391 = new BitSet(new long[]{0x4000001401000000L});
	public static final BitSet FOLLOW_arguments_in_from_item_basic1393 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1396 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_AS_in_from_item_basic1398 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_from_item_basic1400 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_column_definitions_in_from_item_basic1402 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_from_item_basic1404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_synpred29_sqlParser337 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_synpred29_sqlParser340 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred29_sqlParser342 = new BitSet(new long[]{0x1001800000042000L});
	public static final BitSet FOLLOW_operator_in_synpred29_sqlParser345 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_synpred29_sqlParser348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_synpred30_sqlParser353 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_synpred30_sqlParser356 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred30_sqlParser358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_synpred32_sqlParser372 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_synpred32_sqlParser374 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_synpred32_sqlParser376 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred32_sqlParser378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_synpred33_sqlParser393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aliased_expression_in_synpred36_sqlParser457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aliased_expression_in_synpred37_sqlParser457 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_expression_in_synpred37_sqlParser461 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_synpred37_sqlParser465 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_aliased_expressions_in_synpred37_sqlParser468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aliased_expression_in_synpred38_sqlParser479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred39_sqlParser495 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_AS_in_synpred39_sqlParser497 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_synpred39_sqlParser499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred40_sqlParser541 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_synpred40_sqlParser544 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_synpred40_sqlParser548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_simple_operand_in_synpred41_sqlParser579 = new BitSet(new long[]{0x1001800000042000L});
	public static final BitSet FOLLOW_operator_in_synpred41_sqlParser581 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_synpred41_sqlParser584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred44_sqlParser612 = new BitSet(new long[]{0x0000000000010080L,0x0000000000000100L});
	public static final BitSet FOLLOW_ASC_in_synpred44_sqlParser616 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_DESC_in_synpred44_sqlParser620 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_USING_in_synpred44_sqlParser624 = new BitSet(new long[]{0x0000100080000000L});
	public static final BitSet FOLLOW_order_operator_in_synpred44_sqlParser626 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_order_expression_in_synpred44_sqlParser630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_synpred47_sqlParser666 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_synpred47_sqlParser670 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_conditions_in_synpred47_sqlParser674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_synpred48_sqlParser694 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_synpred48_sqlParser697 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred48_sqlParser699 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_synpred48_sqlParser702 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_synpred48_sqlParser706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred49_sqlParser715 = new BitSet(new long[]{0x00041600A0100000L});
	public static final BitSet FOLLOW_comparator_in_synpred49_sqlParser717 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expression_in_synpred49_sqlParser720 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_AND_in_synpred49_sqlParser722 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_synpred49_sqlParser725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRAC_in_synpred50_sqlParser734 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_condition_in_synpred50_sqlParser737 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred50_sqlParser739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DISTINCT_in_synpred60_sqlParser850 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_ON_in_synpred60_sqlParser854 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_synpred60_sqlParser857 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_expressions_in_synpred60_sqlParser860 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred60_sqlParser862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_alias_in_synpred66_sqlParser1027 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_synpred66_sqlParser1029 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_synpred66_sqlParser1032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_item_in_synpred70_sqlParser1134 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_synpred70_sqlParser1136 = new BitSet(new long[]{0x2100008400000000L});
	public static final BitSet FOLLOW_from_items_in_synpred70_sqlParser1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ON_in_synpred72_sqlParser1167 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_join_condition_in_synpred72_sqlParser1169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USING_in_synpred73_sqlParser1173 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_synpred73_sqlParser1175 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_join_columns_in_synpred73_sqlParser1177 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred73_sqlParser1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_item_basic_in_synpred74_sqlParser1156 = new BitSet(new long[]{0x8002014808008000L});
	public static final BitSet FOLLOW_NATURAL_in_synpred74_sqlParser1158 = new BitSet(new long[]{0x8000014808008000L});
	public static final BitSet FOLLOW_join_type_in_synpred74_sqlParser1161 = new BitSet(new long[]{0x2100008400000000L});
	public static final BitSet FOLLOW_from_item_in_synpred74_sqlParser1163 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_ON_in_synpred74_sqlParser1167 = new BitSet(new long[]{0x2000609401024100L,0x0000000000000208L});
	public static final BitSet FOLLOW_join_condition_in_synpred74_sqlParser1169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USING_in_synpred74_sqlParser1173 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_synpred74_sqlParser1175 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_join_columns_in_synpred74_sqlParser1177 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred74_sqlParser1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ONLY_in_synpred82_sqlParser1282 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_table_name_in_synpred82_sqlParser1285 = new BitSet(new long[]{0x0001000400000040L});
	public static final BitSet FOLLOW_star_in_synpred82_sqlParser1287 = new BitSet(new long[]{0x0000000400000040L});
	public static final BitSet FOLLOW_AS_in_synpred82_sqlParser1290 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_synpred82_sqlParser1293 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_LBRAC_in_synpred82_sqlParser1297 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_synpred82_sqlParser1299 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred82_sqlParser1301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ONLY_in_synpred85_sqlParser1326 = new BitSet(new long[]{0x2000000400000000L});
	public static final BitSet FOLLOW_table_name_in_synpred85_sqlParser1329 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_star_in_synpred85_sqlParser1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_name_in_synpred90_sqlParser1353 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_LBRAC_in_synpred90_sqlParser1355 = new BitSet(new long[]{0x4000001401000000L});
	public static final BitSet FOLLOW_arguments_in_synpred90_sqlParser1357 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred90_sqlParser1360 = new BitSet(new long[]{0x0000000400000040L});
	public static final BitSet FOLLOW_AS_in_synpred90_sqlParser1362 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_alias_in_synpred90_sqlParser1365 = new BitSet(new long[]{0x2000008400000002L});
	public static final BitSet FOLLOW_LBRAC_in_synpred90_sqlParser1369 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_column_aliases_in_synpred90_sqlParser1371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_definitions_in_synpred90_sqlParser1375 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_RBRAC_in_synpred90_sqlParser1377 = new BitSet(new long[]{0x0000000000000002L});
}
