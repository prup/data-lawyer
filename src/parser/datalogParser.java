// $ANTLR 3.4 /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g 2012-05-18 21:57:56

    package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class datalogParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOT", "CHAR", "COMMA", "COMMENT", "COUNT", "EQ", "ESC_SEQ", "EXPONENT", "FLOAT", "GEQ", "GT", "HEX_DIGIT", "ID", "INT", "ISEQUAL", "LBRAC", "LEQ", "OCTAL_ESC", "RBRAC", "STRING", "SUM", "UNICODE_ESC", "WS"
    };

    public static final int EOF=-1;
    public static final int BOT=4;
    public static final int CHAR=5;
    public static final int COMMA=6;
    public static final int COMMENT=7;
    public static final int COUNT=8;
    public static final int EQ=9;
    public static final int ESC_SEQ=10;
    public static final int EXPONENT=11;
    public static final int FLOAT=12;
    public static final int GEQ=13;
    public static final int GT=14;
    public static final int HEX_DIGIT=15;
    public static final int ID=16;
    public static final int INT=17;
    public static final int ISEQUAL=18;
    public static final int LBRAC=19;
    public static final int LEQ=20;
    public static final int OCTAL_ESC=21;
    public static final int RBRAC=22;
    public static final int STRING=23;
    public static final int SUM=24;
    public static final int UNICODE_ESC=25;
    public static final int WS=26;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public datalogParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public datalogParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return datalogParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g"; }


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:15:1: query : headpredicate ( ISEQUAL | EQ ) ^ body ;
    public final datalogParser.query_return query() throws RecognitionException {
        datalogParser.query_return retval = new datalogParser.query_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set2=null;
        datalogParser.headpredicate_return headpredicate1 =null;

        datalogParser.body_return body3 =null;


        Object set2_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:15:7: ( headpredicate ( ISEQUAL | EQ ) ^ body )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:15:9: headpredicate ( ISEQUAL | EQ ) ^ body
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_headpredicate_in_query52);
            headpredicate1=headpredicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, headpredicate1.getTree());

            set2=(Token)input.LT(1);

            set2=(Token)input.LT(1);

            if ( input.LA(1)==EQ||input.LA(1)==ISEQUAL ) {
                input.consume();
                if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(set2)
                , root_0);
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            pushFollow(FOLLOW_body_in_query64);
            body3=body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());

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
    // $ANTLR end "query"


    public static class headpredicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headpredicate"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:17:1: headpredicate : ( ID ^ LBRAC ! headvarlist RBRAC !| BOT ^);
    public final datalogParser.headpredicate_return headpredicate() throws RecognitionException {
        datalogParser.headpredicate_return retval = new datalogParser.headpredicate_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID4=null;
        Token LBRAC5=null;
        Token RBRAC7=null;
        Token BOT8=null;
        datalogParser.headvarlist_return headvarlist6 =null;


        Object ID4_tree=null;
        Object LBRAC5_tree=null;
        Object RBRAC7_tree=null;
        Object BOT8_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:17:15: ( ID ^ LBRAC ! headvarlist RBRAC !| BOT ^)
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==BOT) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:17:17: ID ^ LBRAC ! headvarlist RBRAC !
                    {
                    root_0 = (Object)adaptor.nil();


                    ID4=(Token)match(input,ID,FOLLOW_ID_in_headpredicate72); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID4_tree = 
                    (Object)adaptor.create(ID4)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(ID4_tree, root_0);
                    }

                    LBRAC5=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_headpredicate75); if (state.failed) return retval;

                    pushFollow(FOLLOW_headvarlist_in_headpredicate78);
                    headvarlist6=headvarlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, headvarlist6.getTree());

                    RBRAC7=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_headpredicate80); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:18:7: BOT ^
                    {
                    root_0 = (Object)adaptor.nil();


                    BOT8=(Token)match(input,BOT,FOLLOW_BOT_in_headpredicate89); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOT8_tree = 
                    (Object)adaptor.create(BOT8)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(BOT8_tree, root_0);
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
    // $ANTLR end "headpredicate"


    public static class headvarlist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headvarlist"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:21:1: headvarlist : ( ( ID | aggregatevar ) COMMA ! headvarlist | ( ID | aggregatevar ) |);
    public final datalogParser.headvarlist_return headvarlist() throws RecognitionException {
        datalogParser.headvarlist_return retval = new datalogParser.headvarlist_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID9=null;
        Token COMMA11=null;
        Token ID13=null;
        datalogParser.aggregatevar_return aggregatevar10 =null;

        datalogParser.headvarlist_return headvarlist12 =null;

        datalogParser.aggregatevar_return aggregatevar14 =null;


        Object ID9_tree=null;
        Object COMMA11_tree=null;
        Object ID13_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:21:13: ( ( ID | aggregatevar ) COMMA ! headvarlist | ( ID | aggregatevar ) |)
            int alt4=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==COMMA) ) {
                    alt4=1;
                }
                else if ( (LA4_1==EOF||LA4_1==RBRAC) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
                }
                break;
            case COUNT:
            case SUM:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==LBRAC) ) {
                    int LA4_6 = input.LA(3);

                    if ( (LA4_6==ID) ) {
                        int LA4_7 = input.LA(4);

                        if ( (LA4_7==RBRAC) ) {
                            int LA4_8 = input.LA(5);

                            if ( (LA4_8==COMMA) ) {
                                alt4=1;
                            }
                            else if ( (LA4_8==EOF||LA4_8==RBRAC) ) {
                                alt4=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 8, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 7, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 6, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }
                }
                break;
            case EOF:
            case RBRAC:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:21:15: ( ID | aggregatevar ) COMMA ! headvarlist
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:21:15: ( ID | aggregatevar )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==ID) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==COUNT||LA2_0==SUM) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;

                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:21:16: ID
                            {
                            ID9=(Token)match(input,ID,FOLLOW_ID_in_headvarlist104); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ID9_tree = 
                            (Object)adaptor.create(ID9)
                            ;
                            adaptor.addChild(root_0, ID9_tree);
                            }

                            }
                            break;
                        case 2 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:21:21: aggregatevar
                            {
                            pushFollow(FOLLOW_aggregatevar_in_headvarlist108);
                            aggregatevar10=aggregatevar();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, aggregatevar10.getTree());

                            }
                            break;

                    }


                    COMMA11=(Token)match(input,COMMA,FOLLOW_COMMA_in_headvarlist111); if (state.failed) return retval;

                    pushFollow(FOLLOW_headvarlist_in_headvarlist114);
                    headvarlist12=headvarlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, headvarlist12.getTree());

                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:22:7: ( ID | aggregatevar )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:22:7: ( ID | aggregatevar )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==ID) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==COUNT||LA3_0==SUM) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;

                    }
                    switch (alt3) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:22:8: ID
                            {
                            ID13=(Token)match(input,ID,FOLLOW_ID_in_headvarlist123); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ID13_tree = 
                            (Object)adaptor.create(ID13)
                            ;
                            adaptor.addChild(root_0, ID13_tree);
                            }

                            }
                            break;
                        case 2 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:22:13: aggregatevar
                            {
                            pushFollow(FOLLOW_aggregatevar_in_headvarlist127);
                            aggregatevar14=aggregatevar();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, aggregatevar14.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:24:5: 
                    {
                    root_0 = (Object)adaptor.nil();


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
    // $ANTLR end "headvarlist"


    public static class aggregatevar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aggregatevar"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:25:1: aggregatevar : aggregate ^ LBRAC ! ID RBRAC !;
    public final datalogParser.aggregatevar_return aggregatevar() throws RecognitionException {
        datalogParser.aggregatevar_return retval = new datalogParser.aggregatevar_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LBRAC16=null;
        Token ID17=null;
        Token RBRAC18=null;
        datalogParser.aggregate_return aggregate15 =null;


        Object LBRAC16_tree=null;
        Object ID17_tree=null;
        Object RBRAC18_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:25:14: ( aggregate ^ LBRAC ! ID RBRAC !)
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:25:17: aggregate ^ LBRAC ! ID RBRAC !
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_aggregate_in_aggregatevar149);
            aggregate15=aggregate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(aggregate15.getTree(), root_0);

            LBRAC16=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_aggregatevar152); if (state.failed) return retval;

            ID17=(Token)match(input,ID,FOLLOW_ID_in_aggregatevar155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID17_tree = 
            (Object)adaptor.create(ID17)
            ;
            adaptor.addChild(root_0, ID17_tree);
            }

            RBRAC18=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_aggregatevar157); if (state.failed) return retval;

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
    // $ANTLR end "aggregatevar"


    public static class aggregate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aggregate"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:28:1: aggregate : ( SUM | COUNT );
    public final datalogParser.aggregate_return aggregate() throws RecognitionException {
        datalogParser.aggregate_return retval = new datalogParser.aggregate_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set19=null;

        Object set19_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:28:11: ( SUM | COUNT )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:
            {
            root_0 = (Object)adaptor.nil();


            set19=(Token)input.LT(1);

            if ( input.LA(1)==COUNT||input.LA(1)==SUM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set19)
                );
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
    // $ANTLR end "aggregate"


    public static class body_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "body"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:1: body : ( ( predicate | clause ) COMMA ! body | ( predicate | clause ) body | ( predicate | clause ) );
    public final datalogParser.body_return body() throws RecognitionException {
        datalogParser.body_return retval = new datalogParser.body_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA22=null;
        datalogParser.predicate_return predicate20 =null;

        datalogParser.clause_return clause21 =null;

        datalogParser.body_return body23 =null;

        datalogParser.predicate_return predicate24 =null;

        datalogParser.clause_return clause25 =null;

        datalogParser.body_return body26 =null;

        datalogParser.predicate_return predicate27 =null;

        datalogParser.clause_return clause28 =null;


        Object COMMA22_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:6: ( ( predicate | clause ) COMMA ! body | ( predicate | clause ) body | ( predicate | clause ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                int LA8_1 = input.LA(2);

                if ( (synpred9_datalogParser()) ) {
                    alt8=1;
                }
                else if ( (synpred11_datalogParser()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:8: ( predicate | clause ) COMMA ! body
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:8: ( predicate | clause )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==ID) ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1==LBRAC) ) {
                            alt5=1;
                        }
                        else if ( (LA5_1==EQ||(LA5_1 >= GEQ && LA5_1 <= GT)||LA5_1==LEQ) ) {
                            alt5=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;

                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:9: predicate
                            {
                            pushFollow(FOLLOW_predicate_in_body185);
                            predicate20=predicate();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate20.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:21: clause
                            {
                            pushFollow(FOLLOW_clause_in_body189);
                            clause21=clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, clause21.getTree());

                            }
                            break;

                    }


                    COMMA22=(Token)match(input,COMMA,FOLLOW_COMMA_in_body192); if (state.failed) return retval;

                    pushFollow(FOLLOW_body_in_body195);
                    body23=body();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body23.getTree());

                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:4: ( predicate | clause ) body
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:4: ( predicate | clause )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==ID) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==LBRAC) ) {
                            alt6=1;
                        }
                        else if ( (LA6_1==EQ||(LA6_1 >= GEQ && LA6_1 <= GT)||LA6_1==LEQ) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;

                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:5: predicate
                            {
                            pushFollow(FOLLOW_predicate_in_body201);
                            predicate24=predicate();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate24.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:17: clause
                            {
                            pushFollow(FOLLOW_clause_in_body205);
                            clause25=clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, clause25.getTree());

                            }
                            break;

                    }


                    pushFollow(FOLLOW_body_in_body208);
                    body26=body();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body26.getTree());

                    }
                    break;
                case 3 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:32:7: ( predicate | clause )
                    {
                    root_0 = (Object)adaptor.nil();


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:32:7: ( predicate | clause )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==ID) ) {
                        int LA7_1 = input.LA(2);

                        if ( (LA7_1==LBRAC) ) {
                            alt7=1;
                        }
                        else if ( (LA7_1==EQ||(LA7_1 >= GEQ && LA7_1 <= GT)||LA7_1==LEQ) ) {
                            alt7=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:32:8: predicate
                            {
                            pushFollow(FOLLOW_predicate_in_body218);
                            predicate27=predicate();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate27.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:32:20: clause
                            {
                            pushFollow(FOLLOW_clause_in_body222);
                            clause28=clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, clause28.getTree());

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
    // $ANTLR end "body"


    public static class predicate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "predicate"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:35:1: predicate : ID ^ LBRAC ! varlist RBRAC !;
    public final datalogParser.predicate_return predicate() throws RecognitionException {
        datalogParser.predicate_return retval = new datalogParser.predicate_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID29=null;
        Token LBRAC30=null;
        Token RBRAC32=null;
        datalogParser.varlist_return varlist31 =null;


        Object ID29_tree=null;
        Object LBRAC30_tree=null;
        Object RBRAC32_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:35:11: ( ID ^ LBRAC ! varlist RBRAC !)
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:35:13: ID ^ LBRAC ! varlist RBRAC !
            {
            root_0 = (Object)adaptor.nil();


            ID29=(Token)match(input,ID,FOLLOW_ID_in_predicate237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID29_tree = 
            (Object)adaptor.create(ID29)
            ;
            root_0 = (Object)adaptor.becomeRoot(ID29_tree, root_0);
            }

            LBRAC30=(Token)match(input,LBRAC,FOLLOW_LBRAC_in_predicate240); if (state.failed) return retval;

            pushFollow(FOLLOW_varlist_in_predicate243);
            varlist31=varlist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varlist31.getTree());

            RBRAC32=(Token)match(input,RBRAC,FOLLOW_RBRAC_in_predicate245); if (state.failed) return retval;

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
    // $ANTLR end "predicate"


    public static class varlist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "varlist"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:37:1: varlist : ( ID COMMA ! varlist | ID |);
    public final datalogParser.varlist_return varlist() throws RecognitionException {
        datalogParser.varlist_return retval = new datalogParser.varlist_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID33=null;
        Token COMMA34=null;
        Token ID36=null;
        datalogParser.varlist_return varlist35 =null;


        Object ID33_tree=null;
        Object COMMA34_tree=null;
        Object ID36_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:37:9: ( ID COMMA ! varlist | ID |)
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==COMMA) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||LA9_1==RBRAC) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA9_0==EOF||LA9_0==RBRAC) ) {
                alt9=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:37:11: ID COMMA ! varlist
                    {
                    root_0 = (Object)adaptor.nil();


                    ID33=(Token)match(input,ID,FOLLOW_ID_in_varlist254); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID33_tree = 
                    (Object)adaptor.create(ID33)
                    ;
                    adaptor.addChild(root_0, ID33_tree);
                    }

                    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_varlist256); if (state.failed) return retval;

                    pushFollow(FOLLOW_varlist_in_varlist259);
                    varlist35=varlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varlist35.getTree());

                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:38:7: ID
                    {
                    root_0 = (Object)adaptor.nil();


                    ID36=(Token)match(input,ID,FOLLOW_ID_in_varlist267); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID36_tree = 
                    (Object)adaptor.create(ID36)
                    ;
                    adaptor.addChild(root_0, ID36_tree);
                    }

                    }
                    break;
                case 3 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:40:5: 
                    {
                    root_0 = (Object)adaptor.nil();


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
    // $ANTLR end "varlist"


    public static class clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "clause"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:42:1: clause : ID ( EQ ^ STRING | compare ^ ( INT | FLOAT | ID ) ) ;
    public final datalogParser.clause_return clause() throws RecognitionException {
        datalogParser.clause_return retval = new datalogParser.clause_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID37=null;
        Token EQ38=null;
        Token STRING39=null;
        Token set41=null;
        datalogParser.compare_return compare40 =null;


        Object ID37_tree=null;
        Object EQ38_tree=null;
        Object STRING39_tree=null;
        Object set41_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:42:8: ( ID ( EQ ^ STRING | compare ^ ( INT | FLOAT | ID ) ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:42:10: ID ( EQ ^ STRING | compare ^ ( INT | FLOAT | ID ) )
            {
            root_0 = (Object)adaptor.nil();


            ID37=(Token)match(input,ID,FOLLOW_ID_in_clause287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID37_tree = 
            (Object)adaptor.create(ID37)
            ;
            adaptor.addChild(root_0, ID37_tree);
            }

            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:42:13: ( EQ ^ STRING | compare ^ ( INT | FLOAT | ID ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==EQ) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==STRING) ) {
                    alt10=1;
                }
                else if ( (LA10_1==FLOAT||(LA10_1 >= ID && LA10_1 <= INT)) ) {
                    alt10=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA10_0 >= GEQ && LA10_0 <= GT)||LA10_0==LEQ) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:42:14: EQ ^ STRING
                    {
                    EQ38=(Token)match(input,EQ,FOLLOW_EQ_in_clause290); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQ38_tree = 
                    (Object)adaptor.create(EQ38)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(EQ38_tree, root_0);
                    }

                    STRING39=(Token)match(input,STRING,FOLLOW_STRING_in_clause293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING39_tree = 
                    (Object)adaptor.create(STRING39)
                    ;
                    adaptor.addChild(root_0, STRING39_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:42:27: compare ^ ( INT | FLOAT | ID )
                    {
                    pushFollow(FOLLOW_compare_in_clause297);
                    compare40=compare();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(compare40.getTree(), root_0);

                    set41=(Token)input.LT(1);

                    if ( input.LA(1)==FLOAT||(input.LA(1) >= ID && input.LA(1) <= INT) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                        (Object)adaptor.create(set41)
                        );
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // $ANTLR end "clause"


    public static class compare_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "compare"
    // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:44:1: compare : ( EQ | GT | LEQ | GEQ ) ;
    public final datalogParser.compare_return compare() throws RecognitionException {
        datalogParser.compare_return retval = new datalogParser.compare_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set42=null;

        Object set42_tree=null;

        try {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:44:9: ( ( EQ | GT | LEQ | GEQ ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:
            {
            root_0 = (Object)adaptor.nil();


            set42=(Token)input.LT(1);

            if ( input.LA(1)==EQ||(input.LA(1) >= GEQ && input.LA(1) <= GT)||input.LA(1)==LEQ ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set42)
                );
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
    // $ANTLR end "compare"

    // $ANTLR start synpred9_datalogParser
    public final void synpred9_datalogParser_fragment() throws RecognitionException {
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:8: ( ( predicate | clause ) COMMA body )
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:8: ( predicate | clause ) COMMA body
        {
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:8: ( predicate | clause )
        int alt13=2;
        int LA13_0 = input.LA(1);

        if ( (LA13_0==ID) ) {
            int LA13_1 = input.LA(2);

            if ( (LA13_1==LBRAC) ) {
                alt13=1;
            }
            else if ( (LA13_1==EQ||(LA13_1 >= GEQ && LA13_1 <= GT)||LA13_1==LEQ) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 1, input);

                throw nvae;

            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 13, 0, input);

            throw nvae;

        }
        switch (alt13) {
            case 1 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:9: predicate
                {
                pushFollow(FOLLOW_predicate_in_synpred9_datalogParser185);
                predicate();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:30:21: clause
                {
                pushFollow(FOLLOW_clause_in_synpred9_datalogParser189);
                clause();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,COMMA,FOLLOW_COMMA_in_synpred9_datalogParser192); if (state.failed) return ;

        pushFollow(FOLLOW_body_in_synpred9_datalogParser195);
        body();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_datalogParser

    // $ANTLR start synpred11_datalogParser
    public final void synpred11_datalogParser_fragment() throws RecognitionException {
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:4: ( ( predicate | clause ) body )
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:4: ( predicate | clause ) body
        {
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:4: ( predicate | clause )
        int alt14=2;
        int LA14_0 = input.LA(1);

        if ( (LA14_0==ID) ) {
            int LA14_1 = input.LA(2);

            if ( (LA14_1==LBRAC) ) {
                alt14=1;
            }
            else if ( (LA14_1==EQ||(LA14_1 >= GEQ && LA14_1 <= GT)||LA14_1==LEQ) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 1, input);

                throw nvae;

            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 14, 0, input);

            throw nvae;

        }
        switch (alt14) {
            case 1 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:5: predicate
                {
                pushFollow(FOLLOW_predicate_in_synpred11_datalogParser201);
                predicate();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogParser.g:31:17: clause
                {
                pushFollow(FOLLOW_clause_in_synpred11_datalogParser205);
                clause();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_body_in_synpred11_datalogParser208);
        body();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred11_datalogParser

    // Delegated rules

    public final boolean synpred11_datalogParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_datalogParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_datalogParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_datalogParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_headpredicate_in_query52 = new BitSet(new long[]{0x0000000000040200L});
    public static final BitSet FOLLOW_set_in_query54 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_body_in_query64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_headpredicate72 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LBRAC_in_headpredicate75 = new BitSet(new long[]{0x0000000001410100L});
    public static final BitSet FOLLOW_headvarlist_in_headpredicate78 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRAC_in_headpredicate80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOT_in_headpredicate89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_headvarlist104 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_aggregatevar_in_headvarlist108 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_headvarlist111 = new BitSet(new long[]{0x0000000001010100L});
    public static final BitSet FOLLOW_headvarlist_in_headvarlist114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_headvarlist123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aggregatevar_in_headvarlist127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aggregate_in_aggregatevar149 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LBRAC_in_aggregatevar152 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_aggregatevar155 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRAC_in_aggregatevar157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_body185 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_clause_in_body189 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_body192 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_body_in_body195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_body201 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_clause_in_body205 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_body_in_body208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_body218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clause_in_body222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_predicate237 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LBRAC_in_predicate240 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_varlist_in_predicate243 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRAC_in_predicate245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varlist254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_varlist256 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_varlist_in_varlist259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varlist267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_clause287 = new BitSet(new long[]{0x0000000000106200L});
    public static final BitSet FOLLOW_EQ_in_clause290 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_STRING_in_clause293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compare_in_clause297 = new BitSet(new long[]{0x0000000000031000L});
    public static final BitSet FOLLOW_set_in_clause300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred9_datalogParser185 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_clause_in_synpred9_datalogParser189 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_synpred9_datalogParser192 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_body_in_synpred9_datalogParser195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_synpred11_datalogParser201 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_clause_in_synpred11_datalogParser205 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_body_in_synpred11_datalogParser208 = new BitSet(new long[]{0x0000000000000002L});

}