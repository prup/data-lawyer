// $ANTLR 3.4 sqlLexer.g 2013-06-06 10:15:33

    package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class sqlLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public sqlLexer() {} 
    public sqlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public sqlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "sqlLexer.g"; }

    // $ANTLR start "UNKNOWN"
    public final void mUNKNOWN() throws RecognitionException {
        try {
            int _type = UNKNOWN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:7:9: ( '@#$%' )
            // sqlLexer.g:7:11: '@#$%'
            {
            match("@#$%"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNKNOWN"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:10:2: ( 'function' )
            // sqlLexer.g:10:4: 'function'
            {
            match("function"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:12:6: ( ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // sqlLexer.g:12:8: ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:13:5: ( ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // sqlLexer.g:13:7: ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:15:5: ( '.' )
            // sqlLexer.g:15:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "LBRAC"
    public final void mLBRAC() throws RecognitionException {
        try {
            int _type = LBRAC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:17:7: ( '(' )
            // sqlLexer.g:17:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRAC"

    // $ANTLR start "RBRAC"
    public final void mRBRAC() throws RecognitionException {
        try {
            int _type = RBRAC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:18:7: ( ')' )
            // sqlLexer.g:18:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRAC"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:19:7: ( ',' )
            // sqlLexer.g:19:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:20:5: ( '=' )
            // sqlLexer.g:20:7: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NEQ"
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:21:6: ( '<>' )
            // sqlLexer.g:21:8: '<>'
            {
            match("<>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEQ"

    // $ANTLR start "LIKE"
    public final void mLIKE() throws RecognitionException {
        try {
            int _type = LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:22:7: ( ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'k' | 'K' ) ( 'e' | 'E' ) )
            // sqlLexer.g:22:9: ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'k' | 'K' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LIKE"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:23:5: ( '<' )
            // sqlLexer.g:23:7: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:24:5: ( '>' )
            // sqlLexer.g:24:7: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LEQ"
    public final void mLEQ() throws RecognitionException {
        try {
            int _type = LEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:25:5: ( '<=' )
            // sqlLexer.g:25:7: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEQ"

    // $ANTLR start "GEQ"
    public final void mGEQ() throws RecognitionException {
        try {
            int _type = GEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:26:5: ( '>=' )
            // sqlLexer.g:26:7: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GEQ"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:27:10: ( '+' )
            // sqlLexer.g:27:14: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:28:11: ( '-' )
            // sqlLexer.g:28:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULTIPLY"
    public final void mMULTIPLY() throws RecognitionException {
        try {
            int _type = MULTIPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:29:13: ( '*' )
            // sqlLexer.g:29:15: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTIPLY"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:30:12: ( '/' )
            // sqlLexer.g:30:16: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "CONCA"
    public final void mCONCA() throws RecognitionException {
        try {
            int _type = CONCA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:32:2: ( '||' )
            // sqlLexer.g:32:5: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONCA"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:34:8: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 't' | 'T' ) )
            // sqlLexer.g:34:10: ( 's' | 'S' ) ( 'e' | 'E' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:35:5: ( ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // sqlLexer.g:35:7: ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:36:13: ( ( 'd' | 'D' ) ( 'i' | 'I' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) )
            // sqlLexer.g:36:15: ( 'd' | 'D' ) ( 'i' | 'I' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:37:4: ( ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // sqlLexer.g:37:6: ( 'o' | 'O' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:38:4: ( ( 'a' | 'A' ) ( 's' | 'S' ) )
            // sqlLexer.g:38:6: ( 'a' | 'A' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:40:6: ( ( 'f' | 'F' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'm' | 'M' ) )
            // sqlLexer.g:40:8: ( 'f' | 'F' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:42:7: ( ( 'w' | 'W' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // sqlLexer.g:42:9: ( 'w' | 'W' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:44:7: ( ( 'g' | 'G' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'p' | 'P' ) )
            // sqlLexer.g:44:9: ( 'g' | 'G' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'p' | 'P' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:45:4: ( ( 'b' | 'B' ) ( 'y' | 'Y' ) )
            // sqlLexer.g:45:6: ( 'b' | 'B' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "HAVING"
    public final void mHAVING() throws RecognitionException {
        try {
            int _type = HAVING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:46:8: ( ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'v' | 'V' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' ) )
            // sqlLexer.g:46:10: ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'v' | 'V' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HAVING"

    // $ANTLR start "UNION"
    public final void mUNION() throws RecognitionException {
        try {
            int _type = UNION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:48:7: ( ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // sqlLexer.g:48:9: ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNION"

    // $ANTLR start "INTERSECT"
    public final void mINTERSECT() throws RecognitionException {
        try {
            int _type = INTERSECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:49:13: ( ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 't' | 'T' ) )
            // sqlLexer.g:49:15: ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTERSECT"

    // $ANTLR start "EXCEPT"
    public final void mEXCEPT() throws RecognitionException {
        try {
            int _type = EXCEPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:50:8: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) )
            // sqlLexer.g:50:10: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXCEPT"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:52:7: ( ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // sqlLexer.g:52:9: ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:53:5: ( ( 'a' | 'A' ) ( 's' | 'S' ) ( 'c' | 'C' ) )
            // sqlLexer.g:53:7: ( 'a' | 'A' ) ( 's' | 'S' ) ( 'c' | 'C' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:54:6: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 's' | 'S' ) ( 'c' | 'C' ) )
            // sqlLexer.g:54:8: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 's' | 'S' ) ( 'c' | 'C' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:55:7: ( ( 'u' | 'U' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' ) )
            // sqlLexer.g:55:9: ( 'u' | 'U' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USING"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:56:7: ( ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'm' | 'M' ) ( 'i' | 'I' ) ( 't' | 'T' ) )
            // sqlLexer.g:56:9: ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'm' | 'M' ) ( 'i' | 'I' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "OFFSET"
    public final void mOFFSET() throws RecognitionException {
        try {
            int _type = OFFSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:57:8: ( ( 'o' | 'O' ) ( 'f' | 'F' ) ( 'f' | 'F' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // sqlLexer.g:57:10: ( 'o' | 'O' ) ( 'f' | 'F' ) ( 'f' | 'F' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OFFSET"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:59:5: ( ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // sqlLexer.g:59:7: ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "UPDATE"
    public final void mUPDATE() throws RecognitionException {
        try {
            int _type = UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:60:8: ( ( 'u' | 'U' ) ( 'p' | 'P' ) ( 'd' | 'D' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'e' | 'E' ) )
            // sqlLexer.g:60:10: ( 'u' | 'U' ) ( 'p' | 'P' ) ( 'd' | 'D' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UPDATE"

    // $ANTLR start "SHARE"
    public final void mSHARE() throws RecognitionException {
        try {
            int _type = SHARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:61:7: ( ( 's' | 'S' ) ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // sqlLexer.g:61:9: ( 's' | 'S' ) ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHARE"

    // $ANTLR start "NOWAIT"
    public final void mNOWAIT() throws RecognitionException {
        try {
            int _type = NOWAIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:62:8: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'w' | 'W' ) ( 'a' | 'A' ) ( 'i' | 'I' ) ( 't' | 'T' ) )
            // sqlLexer.g:62:10: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'w' | 'W' ) ( 'a' | 'A' ) ( 'i' | 'I' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOWAIT"

    // $ANTLR start "ONLY"
    public final void mONLY() throws RecognitionException {
        try {
            int _type = ONLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:63:6: ( ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'l' | 'L' ) ( 'y' | 'Y' ) )
            // sqlLexer.g:63:8: ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'l' | 'L' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ONLY"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:64:9: ( ( 'o' | 'O' ) ( 'f' | 'F' ) )
            // sqlLexer.g:64:11: ( 'o' | 'O' ) ( 'f' | 'F' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "NATURAL"
    public final void mNATURAL() throws RecognitionException {
        try {
            int _type = NATURAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:66:9: ( ( 'n' | 'N' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'l' | 'L' ) )
            // sqlLexer.g:66:11: ( 'n' | 'N' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NATURAL"

    // $ANTLR start "INNER"
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:67:7: ( ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // sqlLexer.g:67:9: ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INNER"

    // $ANTLR start "JOIN"
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:68:6: ( ( 'j' | 'J' ) ( 'o' | 'O' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // sqlLexer.g:68:8: ( 'j' | 'J' ) ( 'o' | 'O' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JOIN"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:69:6: ( ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 't' | 'T' ) )
            // sqlLexer.g:69:8: ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:70:7: ( ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'h' | 'H' ) ( 't' | 'T' ) )
            // sqlLexer.g:70:9: ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'h' | 'H' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:71:6: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // sqlLexer.g:71:8: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FULL"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:72:7: ( ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // sqlLexer.g:72:9: ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "CROSS"
    public final void mCROSS() throws RecognitionException {
        try {
            int _type = CROSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:73:7: ( ( 'c' | 'C' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 's' | 'S' ) ( 's' | 'S' ) )
            // sqlLexer.g:73:9: ( 'c' | 'C' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 's' | 'S' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CROSS"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:75:5: ( ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' ) )
            // sqlLexer.g:75:7: ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:76:5: ( ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' ) )
            // sqlLexer.g:76:7: ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAX"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:77:5: ( ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // sqlLexer.g:77:7: ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MIN"

    // $ANTLR start "AVG"
    public final void mAVG() throws RecognitionException {
        try {
            int _type = AVG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:78:5: ( ( 'a' | 'A' ) ( 'v' | 'V' ) ( 'g' | 'G' ) )
            // sqlLexer.g:78:7: ( 'a' | 'A' ) ( 'v' | 'V' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AVG"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:79:7: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 't' | 'T' ) )
            // sqlLexer.g:79:9: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:81:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // sqlLexer.g:81:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // sqlLexer.g:81:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // sqlLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "QUAL_ID"
    public final void mQUAL_ID() throws RecognitionException {
        try {
            int _type = QUAL_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:83:10: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // sqlLexer.g:83:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* '.' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // sqlLexer.g:83:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // sqlLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match('.'); 

            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // sqlLexer.g:83:98: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // sqlLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUAL_ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:85:5: ( ( '0' .. '9' )+ )
            // sqlLexer.g:85:7: ( '0' .. '9' )+
            {
            // sqlLexer.g:85:7: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // sqlLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:88:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // sqlLexer.g:88:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // sqlLexer.g:88:9: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // sqlLexer.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    match('.'); 

                    // sqlLexer.g:88:25: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // sqlLexer.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    // sqlLexer.g:88:37: ( EXPONENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // sqlLexer.g:88:37: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // sqlLexer.g:89:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // sqlLexer.g:89:13: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // sqlLexer.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    // sqlLexer.g:89:25: ( EXPONENT )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='E'||LA9_0=='e') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // sqlLexer.g:89:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // sqlLexer.g:90:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // sqlLexer.g:90:9: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // sqlLexer.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    mEXPONENT(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:93:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='/') ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1=='/') ) {
                    alt15=1;
                }
                else if ( (LA15_1=='*') ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // sqlLexer.g:93:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // sqlLexer.g:93:14: (~ ( '\\n' | '\\r' ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // sqlLexer.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    // sqlLexer.g:93:28: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // sqlLexer.g:93:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // sqlLexer.g:94:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // sqlLexer.g:94:14: ( options {greedy=false; } : . )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='*') ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1=='/') ) {
                                alt14=2;
                            }
                            else if ( ((LA14_1 >= '\u0000' && LA14_1 <= '.')||(LA14_1 >= '0' && LA14_1 <= '\uFFFF')) ) {
                                alt14=1;
                            }


                        }
                        else if ( ((LA14_0 >= '\u0000' && LA14_0 <= ')')||(LA14_0 >= '+' && LA14_0 <= '\uFFFF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // sqlLexer.g:94:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:97:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // sqlLexer.g:97:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "VARCHAR"
    public final void mVARCHAR() throws RecognitionException {
        try {
            int _type = VARCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:104:9: ( '\\'' ( WS | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '+' | '%' | ':' )* '\\'' )
            // sqlLexer.g:104:13: '\\'' ( WS | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '+' | '%' | ':' )* '\\''
            {
            match('\''); 

            // sqlLexer.g:104:18: ( WS | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' | '+' | '%' | ':' )*
            loop16:
            do {
                int alt16=10;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    {
                    alt16=1;
                    }
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt16=2;
                    }
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    {
                    alt16=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt16=4;
                    }
                    break;
                case '_':
                    {
                    alt16=5;
                    }
                    break;
                case '-':
                    {
                    alt16=6;
                    }
                    break;
                case '+':
                    {
                    alt16=7;
                    }
                    break;
                case '%':
                    {
                    alt16=8;
                    }
                    break;
                case ':':
                    {
                    alt16=9;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // sqlLexer.g:104:19: WS
            	    {
            	    mWS(); 


            	    }
            	    break;
            	case 2 :
            	    // sqlLexer.g:104:22: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;
            	case 3 :
            	    // sqlLexer.g:104:31: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }
            	    break;
            	case 4 :
            	    // sqlLexer.g:104:40: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;
            	case 5 :
            	    // sqlLexer.g:104:49: '_'
            	    {
            	    match('_'); 

            	    }
            	    break;
            	case 6 :
            	    // sqlLexer.g:104:53: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;
            	case 7 :
            	    // sqlLexer.g:104:57: '+'
            	    {
            	    match('+'); 

            	    }
            	    break;
            	case 8 :
            	    // sqlLexer.g:104:61: '%'
            	    {
            	    match('%'); 

            	    }
            	    break;
            	case 9 :
            	    // sqlLexer.g:104:65: ':'
            	    {
            	    match(':'); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARCHAR"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:107:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // sqlLexer.g:107:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // sqlLexer.g:107:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\\') ) {
                    alt17=1;
                }
                else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= '[')||(LA17_0 >= ']' && LA17_0 <= '\uFFFF')) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // sqlLexer.g:107:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // sqlLexer.g:107:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // sqlLexer.g:110:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // sqlLexer.g:110:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // sqlLexer.g:110:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\\') ) {
                alt18=1;
            }
            else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '&')||(LA18_0 >= '(' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // sqlLexer.g:110:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // sqlLexer.g:110:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // sqlLexer.g:114:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // sqlLexer.g:114:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // sqlLexer.g:114:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // sqlLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // sqlLexer.g:114:33: ( '0' .. '9' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // sqlLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // sqlLexer.g:117:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // sqlLexer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // sqlLexer.g:121:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt21=1;
                    }
                    break;
                case 'u':
                    {
                    alt21=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt21=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // sqlLexer.g:121:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // sqlLexer.g:122:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // sqlLexer.g:123:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // sqlLexer.g:128:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\\') ) {
                int LA22_1 = input.LA(2);

                if ( ((LA22_1 >= '0' && LA22_1 <= '3')) ) {
                    int LA22_2 = input.LA(3);

                    if ( ((LA22_2 >= '0' && LA22_2 <= '7')) ) {
                        int LA22_4 = input.LA(4);

                        if ( ((LA22_4 >= '0' && LA22_4 <= '7')) ) {
                            alt22=1;
                        }
                        else {
                            alt22=2;
                        }
                    }
                    else {
                        alt22=3;
                    }
                }
                else if ( ((LA22_1 >= '4' && LA22_1 <= '7')) ) {
                    int LA22_3 = input.LA(3);

                    if ( ((LA22_3 >= '0' && LA22_3 <= '7')) ) {
                        alt22=2;
                    }
                    else {
                        alt22=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // sqlLexer.g:128:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // sqlLexer.g:129:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // sqlLexer.g:130:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // sqlLexer.g:135:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // sqlLexer.g:135:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // sqlLexer.g:1:8: ( UNKNOWN | FUNCTION | AND | OR | DOT | LBRAC | RBRAC | COMMA | EQ | NEQ | LIKE | LT | GT | LEQ | GEQ | PLUS | MINUS | MULTIPLY | DIVIDE | CONCA | SELECT | ALL | DISTINCT | ON | AS | FROM | WHERE | GROUP | BY | HAVING | UNION | INTERSECT | EXCEPT | ORDER | ASC | DESC | USING | LIMIT | OFFSET | FOR | UPDATE | SHARE | NOWAIT | ONLY | OF | NATURAL | INNER | JOIN | LEFT | RIGHT | FULL | OUTER | CROSS | SUM | MAX | MIN | AVG | COUNT | ID | QUAL_ID | INT | FLOAT | COMMENT | WS | VARCHAR | STRING | CHAR )
        int alt23=67;
        alt23 = dfa23.predict(input);
        switch (alt23) {
            case 1 :
                // sqlLexer.g:1:10: UNKNOWN
                {
                mUNKNOWN(); 


                }
                break;
            case 2 :
                // sqlLexer.g:1:18: FUNCTION
                {
                mFUNCTION(); 


                }
                break;
            case 3 :
                // sqlLexer.g:1:27: AND
                {
                mAND(); 


                }
                break;
            case 4 :
                // sqlLexer.g:1:31: OR
                {
                mOR(); 


                }
                break;
            case 5 :
                // sqlLexer.g:1:34: DOT
                {
                mDOT(); 


                }
                break;
            case 6 :
                // sqlLexer.g:1:38: LBRAC
                {
                mLBRAC(); 


                }
                break;
            case 7 :
                // sqlLexer.g:1:44: RBRAC
                {
                mRBRAC(); 


                }
                break;
            case 8 :
                // sqlLexer.g:1:50: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 9 :
                // sqlLexer.g:1:56: EQ
                {
                mEQ(); 


                }
                break;
            case 10 :
                // sqlLexer.g:1:59: NEQ
                {
                mNEQ(); 


                }
                break;
            case 11 :
                // sqlLexer.g:1:63: LIKE
                {
                mLIKE(); 


                }
                break;
            case 12 :
                // sqlLexer.g:1:68: LT
                {
                mLT(); 


                }
                break;
            case 13 :
                // sqlLexer.g:1:71: GT
                {
                mGT(); 


                }
                break;
            case 14 :
                // sqlLexer.g:1:74: LEQ
                {
                mLEQ(); 


                }
                break;
            case 15 :
                // sqlLexer.g:1:78: GEQ
                {
                mGEQ(); 


                }
                break;
            case 16 :
                // sqlLexer.g:1:82: PLUS
                {
                mPLUS(); 


                }
                break;
            case 17 :
                // sqlLexer.g:1:87: MINUS
                {
                mMINUS(); 


                }
                break;
            case 18 :
                // sqlLexer.g:1:93: MULTIPLY
                {
                mMULTIPLY(); 


                }
                break;
            case 19 :
                // sqlLexer.g:1:102: DIVIDE
                {
                mDIVIDE(); 


                }
                break;
            case 20 :
                // sqlLexer.g:1:109: CONCA
                {
                mCONCA(); 


                }
                break;
            case 21 :
                // sqlLexer.g:1:115: SELECT
                {
                mSELECT(); 


                }
                break;
            case 22 :
                // sqlLexer.g:1:122: ALL
                {
                mALL(); 


                }
                break;
            case 23 :
                // sqlLexer.g:1:126: DISTINCT
                {
                mDISTINCT(); 


                }
                break;
            case 24 :
                // sqlLexer.g:1:135: ON
                {
                mON(); 


                }
                break;
            case 25 :
                // sqlLexer.g:1:138: AS
                {
                mAS(); 


                }
                break;
            case 26 :
                // sqlLexer.g:1:141: FROM
                {
                mFROM(); 


                }
                break;
            case 27 :
                // sqlLexer.g:1:146: WHERE
                {
                mWHERE(); 


                }
                break;
            case 28 :
                // sqlLexer.g:1:152: GROUP
                {
                mGROUP(); 


                }
                break;
            case 29 :
                // sqlLexer.g:1:158: BY
                {
                mBY(); 


                }
                break;
            case 30 :
                // sqlLexer.g:1:161: HAVING
                {
                mHAVING(); 


                }
                break;
            case 31 :
                // sqlLexer.g:1:168: UNION
                {
                mUNION(); 


                }
                break;
            case 32 :
                // sqlLexer.g:1:174: INTERSECT
                {
                mINTERSECT(); 


                }
                break;
            case 33 :
                // sqlLexer.g:1:184: EXCEPT
                {
                mEXCEPT(); 


                }
                break;
            case 34 :
                // sqlLexer.g:1:191: ORDER
                {
                mORDER(); 


                }
                break;
            case 35 :
                // sqlLexer.g:1:197: ASC
                {
                mASC(); 


                }
                break;
            case 36 :
                // sqlLexer.g:1:201: DESC
                {
                mDESC(); 


                }
                break;
            case 37 :
                // sqlLexer.g:1:206: USING
                {
                mUSING(); 


                }
                break;
            case 38 :
                // sqlLexer.g:1:212: LIMIT
                {
                mLIMIT(); 


                }
                break;
            case 39 :
                // sqlLexer.g:1:218: OFFSET
                {
                mOFFSET(); 


                }
                break;
            case 40 :
                // sqlLexer.g:1:225: FOR
                {
                mFOR(); 


                }
                break;
            case 41 :
                // sqlLexer.g:1:229: UPDATE
                {
                mUPDATE(); 


                }
                break;
            case 42 :
                // sqlLexer.g:1:236: SHARE
                {
                mSHARE(); 


                }
                break;
            case 43 :
                // sqlLexer.g:1:242: NOWAIT
                {
                mNOWAIT(); 


                }
                break;
            case 44 :
                // sqlLexer.g:1:249: ONLY
                {
                mONLY(); 


                }
                break;
            case 45 :
                // sqlLexer.g:1:254: OF
                {
                mOF(); 


                }
                break;
            case 46 :
                // sqlLexer.g:1:257: NATURAL
                {
                mNATURAL(); 


                }
                break;
            case 47 :
                // sqlLexer.g:1:265: INNER
                {
                mINNER(); 


                }
                break;
            case 48 :
                // sqlLexer.g:1:271: JOIN
                {
                mJOIN(); 


                }
                break;
            case 49 :
                // sqlLexer.g:1:276: LEFT
                {
                mLEFT(); 


                }
                break;
            case 50 :
                // sqlLexer.g:1:281: RIGHT
                {
                mRIGHT(); 


                }
                break;
            case 51 :
                // sqlLexer.g:1:287: FULL
                {
                mFULL(); 


                }
                break;
            case 52 :
                // sqlLexer.g:1:292: OUTER
                {
                mOUTER(); 


                }
                break;
            case 53 :
                // sqlLexer.g:1:298: CROSS
                {
                mCROSS(); 


                }
                break;
            case 54 :
                // sqlLexer.g:1:304: SUM
                {
                mSUM(); 


                }
                break;
            case 55 :
                // sqlLexer.g:1:308: MAX
                {
                mMAX(); 


                }
                break;
            case 56 :
                // sqlLexer.g:1:312: MIN
                {
                mMIN(); 


                }
                break;
            case 57 :
                // sqlLexer.g:1:316: AVG
                {
                mAVG(); 


                }
                break;
            case 58 :
                // sqlLexer.g:1:320: COUNT
                {
                mCOUNT(); 


                }
                break;
            case 59 :
                // sqlLexer.g:1:326: ID
                {
                mID(); 


                }
                break;
            case 60 :
                // sqlLexer.g:1:329: QUAL_ID
                {
                mQUAL_ID(); 


                }
                break;
            case 61 :
                // sqlLexer.g:1:337: INT
                {
                mINT(); 


                }
                break;
            case 62 :
                // sqlLexer.g:1:341: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 63 :
                // sqlLexer.g:1:347: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 64 :
                // sqlLexer.g:1:355: WS
                {
                mWS(); 


                }
                break;
            case 65 :
                // sqlLexer.g:1:358: VARCHAR
                {
                mVARCHAR(); 


                }
                break;
            case 66 :
                // sqlLexer.g:1:366: STRING
                {
                mSTRING(); 


                }
                break;
            case 67 :
                // sqlLexer.g:1:373: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA11_eotS =
        "\5\uffff";
    static final String DFA11_eofS =
        "\5\uffff";
    static final String DFA11_minS =
        "\2\56\3\uffff";
    static final String DFA11_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA11_specialS =
        "\5\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "87:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA23_eotS =
        "\2\uffff\3\53\1\65\4\uffff\1\71\1\53\1\75\3\uffff\1\77\1\uffff\20"+
        "\53\1\126\3\uffff\5\53\2\uffff\2\53\1\151\1\53\1\154\1\156\1\160"+
        "\1\53\5\uffff\2\53\4\uffff\7\53\1\174\16\53\14\uffff\3\53\1\u0090"+
        "\1\u0091\1\u0092\1\u0093\1\uffff\1\u0094\1\53\1\uffff\1\53\1\uffff"+
        "\1\53\1\uffff\6\53\1\u009e\4\53\1\uffff\15\53\1\u00b0\1\u00b1\1"+
        "\uffff\1\53\1\u00b3\1\u00b4\5\uffff\1\53\1\u00b6\2\53\1\u00b9\1"+
        "\53\1\u00bb\2\53\1\uffff\1\53\1\u00bf\13\53\1\u00cb\3\53\2\uffff"+
        "\1\53\2\uffff\1\u00d0\1\uffff\1\53\1\u00d2\1\uffff\1\u00d3\1\uffff"+
        "\1\53\1\u00d5\1\53\1\uffff\1\u00d7\1\u00d8\1\53\1\u00da\1\u00db"+
        "\2\53\1\u00de\3\53\1\uffff\1\u00e2\1\u00e3\1\u00e4\1\53\1\uffff"+
        "\1\u00e6\2\uffff\1\u00e7\1\uffff\1\53\2\uffff\1\u00e9\2\uffff\1"+
        "\u00ea\1\53\1\uffff\1\u00ec\1\u00ed\1\53\3\uffff\1\53\2\uffff\1"+
        "\53\2\uffff\1\53\2\uffff\1\u00f2\1\u00f3\1\u00f4\1\53\3\uffff\1"+
        "\u00f6\1\uffff";
    static final String DFA23_eofS =
        "\u00f7\uffff";
    static final String DFA23_minS =
        "\1\11\1\uffff\3\56\1\60\4\uffff\1\75\1\56\1\75\3\uffff\1\52\1\uffff"+
        "\21\56\1\uffff\1\0\1\uffff\5\56\2\uffff\10\56\5\uffff\2\56\4\uffff"+
        "\26\56\1\uffff\11\11\2\uffff\7\56\1\uffff\2\56\1\uffff\1\56\1\uffff"+
        "\1\56\1\uffff\13\56\1\uffff\17\56\1\uffff\3\56\5\uffff\11\56\1\uffff"+
        "\21\56\2\uffff\1\56\2\uffff\1\56\1\uffff\2\56\1\uffff\1\56\1\uffff"+
        "\3\56\1\uffff\13\56\1\uffff\4\56\1\uffff\1\56\2\uffff\1\56\1\uffff"+
        "\1\56\2\uffff\1\56\2\uffff\2\56\1\uffff\3\56\3\uffff\1\56\2\uffff"+
        "\1\56\2\uffff\1\56\2\uffff\4\56\3\uffff\1\56\1\uffff";
    static final String DFA23_maxS =
        "\1\174\1\uffff\3\172\1\71\4\uffff\1\76\1\172\1\75\3\uffff\1\57\1"+
        "\uffff\20\172\1\145\1\uffff\1\uffff\1\uffff\5\172\2\uffff\10\172"+
        "\5\uffff\2\172\4\uffff\26\172\1\uffff\11\172\2\uffff\7\172\1\uffff"+
        "\2\172\1\uffff\1\172\1\uffff\1\172\1\uffff\13\172\1\uffff\17\172"+
        "\1\uffff\3\172\5\uffff\11\172\1\uffff\21\172\2\uffff\1\172\2\uffff"+
        "\1\172\1\uffff\2\172\1\uffff\1\172\1\uffff\3\172\1\uffff\13\172"+
        "\1\uffff\4\172\1\uffff\1\172\2\uffff\1\172\1\uffff\1\172\2\uffff"+
        "\1\172\2\uffff\2\172\1\uffff\3\172\3\uffff\1\172\2\uffff\1\172\2"+
        "\uffff\1\172\2\uffff\4\172\3\uffff\1\172\1\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\4\uffff\1\6\1\7\1\10\1\11\3\uffff\1\20\1\21\1\22\1"+
        "\uffff\1\24\21\uffff\1\100\1\uffff\1\102\5\uffff\1\73\1\74\10\uffff"+
        "\1\5\1\76\1\12\1\16\1\14\2\uffff\1\17\1\15\1\77\1\23\26\uffff\1"+
        "\75\11\uffff\1\101\1\103\7\uffff\1\31\2\uffff\1\4\1\uffff\1\30\1"+
        "\uffff\1\55\13\uffff\1\35\17\uffff\1\101\3\uffff\1\50\1\3\1\26\1"+
        "\43\1\71\11\uffff\1\66\21\uffff\1\67\1\70\1\uffff\1\63\1\32\1\uffff"+
        "\1\54\2\uffff\1\13\1\uffff\1\61\3\uffff\1\44\13\uffff\1\60\4\uffff"+
        "\1\42\1\uffff\1\64\1\46\1\uffff\1\52\1\uffff\1\33\1\34\1\uffff\1"+
        "\37\1\45\2\uffff\1\57\3\uffff\1\62\1\65\1\72\1\uffff\1\47\1\25\1"+
        "\uffff\1\36\1\51\1\uffff\1\41\1\53\4\uffff\1\56\1\2\1\27\1\uffff"+
        "\1\40";
    static final String DFA23_specialS =
        "\44\uffff\1\0\u00d2\uffff}>";
    static final String[] DFA23_transitionS = {
            "\2\43\2\uffff\1\43\22\uffff\1\43\1\uffff\1\45\4\uffff\1\44\1"+
            "\6\1\7\1\17\1\15\1\10\1\16\1\5\1\20\12\42\2\uffff\1\12\1\11"+
            "\1\14\1\uffff\1\1\1\3\1\27\1\37\1\23\1\33\1\24\1\26\1\30\1\32"+
            "\1\35\1\41\1\13\1\40\1\34\1\4\2\41\1\36\1\22\1\41\1\31\1\41"+
            "\1\25\3\41\4\uffff\1\41\1\uffff\1\3\1\27\1\37\1\23\1\33\1\2"+
            "\1\26\1\30\1\32\1\35\1\41\1\13\1\40\1\34\1\4\2\41\1\36\1\22"+
            "\1\41\1\31\1\41\1\25\3\41\1\uffff\1\21",
            "",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\50\2\52\1\47\2\52\1\51"+
            "\5\52\4\uffff\1\52\1\uffff\16\52\1\50\2\52\1\47\2\52\1\46\5"+
            "\52",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\56\1\52\1\55\4\52\1\57"+
            "\2\52\1\60\4\52\4\uffff\1\52\1\uffff\13\52\1\56\1\52\1\55\4"+
            "\52\1\57\2\52\1\60\4\52",
            "\1\54\1\uffff\12\52\7\uffff\5\52\1\63\7\52\1\62\3\52\1\61\2"+
            "\52\1\64\5\52\4\uffff\1\52\1\uffff\5\52\1\63\7\52\1\62\3\52"+
            "\1\61\2\52\1\64\5\52",
            "\12\66",
            "",
            "",
            "",
            "",
            "\1\70\1\67",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\73\3\52\1\72\21\52\4\uffff"+
            "\1\52\1\uffff\4\52\1\73\3\52\1\72\21\52",
            "\1\74",
            "",
            "",
            "",
            "\1\76\4\uffff\1\76",
            "",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\100\2\52\1\101\14\52\1\102"+
            "\5\52\4\uffff\1\52\1\uffff\4\52\1\100\2\52\1\101\14\52\1\102"+
            "\5\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\104\3\52\1\103\21\52\4\uffff"+
            "\1\52\1\uffff\4\52\1\104\3\52\1\103\21\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\50\2\52\1\47\2\52\1\51"+
            "\5\52\4\uffff\1\52\1\uffff\16\52\1\50\2\52\1\47\2\52\1\51\5"+
            "\52",
            "\1\54\1\uffff\12\52\7\uffff\7\52\1\105\22\52\4\uffff\1\52\1"+
            "\uffff\7\52\1\105\22\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\106\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\106\10\52",
            "\1\54\1\uffff\12\52\7\uffff\30\52\1\107\1\52\4\uffff\1\52\1"+
            "\uffff\30\52\1\107\1\52",
            "\1\54\1\uffff\12\52\7\uffff\1\110\31\52\4\uffff\1\52\1\uffff"+
            "\1\110\31\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\111\1\52\1\113\2\52\1\112"+
            "\7\52\4\uffff\1\52\1\uffff\15\52\1\111\1\52\1\113\2\52\1\112"+
            "\7\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\114\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\114\14\52",
            "\1\54\1\uffff\12\52\7\uffff\27\52\1\115\2\52\4\uffff\1\52\1"+
            "\uffff\27\52\1\115\2\52",
            "\1\54\1\uffff\12\52\7\uffff\1\117\15\52\1\116\13\52\4\uffff"+
            "\1\52\1\uffff\1\117\15\52\1\116\13\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\120\13\52\4\uffff\1\52"+
            "\1\uffff\16\52\1\120\13\52",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\121\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\121\21\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\123\2\52\1\122\10\52\4"+
            "\uffff\1\52\1\uffff\16\52\1\123\2\52\1\122\10\52",
            "\1\54\1\uffff\12\52\7\uffff\1\124\7\52\1\125\21\52\4\uffff"+
            "\1\52\1\uffff\1\124\7\52\1\125\21\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\66\1\uffff\12\42\13\uffff\1\66\37\uffff\1\66",
            "",
            "\11\141\2\127\2\141\1\127\22\141\1\127\4\141\1\136\1\141\1"+
            "\140\3\141\1\135\1\141\1\134\2\141\12\132\1\137\6\141\32\131"+
            "\4\141\1\133\1\141\32\130\uff85\141",
            "",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\143\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\143\1\52\1\142\14\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\144\13\52\4\uffff\1\52"+
            "\1\uffff\16\52\1\144\13\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\145\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\145\10\52",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\143\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\143\16\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\3\52\1\146\26\52\4\uffff\1\52\1"+
            "\uffff\3\52\1\146\26\52",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\147\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\147\16\52",
            "\1\54\1\uffff\12\52\7\uffff\2\52\1\150\27\52\4\uffff\1\52\1"+
            "\uffff\2\52\1\150\27\52",
            "\1\54\1\uffff\12\52\7\uffff\6\52\1\152\23\52\4\uffff\1\52\1"+
            "\uffff\6\52\1\152\23\52",
            "\1\54\1\uffff\12\52\7\uffff\3\52\1\153\26\52\4\uffff\1\52\1"+
            "\uffff\3\52\1\153\26\52",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\155\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\155\16\52",
            "\1\54\1\uffff\12\52\7\uffff\5\52\1\157\24\52\4\uffff\1\52\1"+
            "\uffff\5\52\1\157\24\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\161\6\52\4\uffff\1\52\1"+
            "\uffff\23\52\1\161\6\52",
            "",
            "",
            "",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\12\52\1\162\1\52\1\163\15\52\4"+
            "\uffff\1\52\1\uffff\12\52\1\162\1\52\1\163\15\52",
            "\1\54\1\uffff\12\52\7\uffff\5\52\1\164\24\52\4\uffff\1\52\1"+
            "\uffff\5\52\1\164\24\52",
            "",
            "",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\165\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\165\16\52",
            "\1\54\1\uffff\12\52\7\uffff\1\166\31\52\4\uffff\1\52\1\uffff"+
            "\1\166\31\52",
            "\1\54\1\uffff\12\52\7\uffff\14\52\1\167\15\52\4\uffff\1\52"+
            "\1\uffff\14\52\1\167\15\52",
            "\1\54\1\uffff\12\52\7\uffff\22\52\1\170\7\52\4\uffff\1\52\1"+
            "\uffff\22\52\1\170\7\52",
            "\1\54\1\uffff\12\52\7\uffff\22\52\1\171\7\52\4\uffff\1\52\1"+
            "\uffff\22\52\1\171\7\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\172\25\52\4\uffff\1\52\1"+
            "\uffff\4\52\1\172\25\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\173\13\52\4\uffff\1\52"+
            "\1\uffff\16\52\1\173\13\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\25\52\1\175\4\52\4\uffff\1\52\1"+
            "\uffff\25\52\1\175\4\52",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\176\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\176\21\52",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\177\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\177\21\52",
            "\1\54\1\uffff\12\52\7\uffff\3\52\1\u0080\26\52\4\uffff\1\52"+
            "\1\uffff\3\52\1\u0080\26\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u0082\5\52\1\u0081\6\52"+
            "\4\uffff\1\52\1\uffff\15\52\1\u0082\5\52\1\u0081\6\52",
            "\1\54\1\uffff\12\52\7\uffff\2\52\1\u0083\27\52\4\uffff\1\52"+
            "\1\uffff\2\52\1\u0083\27\52",
            "\1\54\1\uffff\12\52\7\uffff\26\52\1\u0084\3\52\4\uffff\1\52"+
            "\1\uffff\26\52\1\u0084\3\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u0085\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u0085\6\52",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\u0086\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\u0086\21\52",
            "\1\54\1\uffff\12\52\7\uffff\6\52\1\u0087\23\52\4\uffff\1\52"+
            "\1\uffff\6\52\1\u0087\23\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\u0088\13\52\4\uffff\1\52"+
            "\1\uffff\16\52\1\u0088\13\52",
            "\1\54\1\uffff\12\52\7\uffff\24\52\1\u0089\5\52\4\uffff\1\52"+
            "\1\uffff\24\52\1\u0089\5\52",
            "\1\54\1\uffff\12\52\7\uffff\27\52\1\u008a\2\52\4\uffff\1\52"+
            "\1\uffff\27\52\1\u008a\2\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u008b\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u008b\14\52",
            "",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "\2\140\2\uffff\1\140\22\uffff\1\140\4\uffff\1\140\1\uffff\1"+
            "\u008c\3\uffff\1\140\1\uffff\1\140\2\uffff\13\140\6\uffff\32"+
            "\140\4\uffff\1\140\1\uffff\32\140",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\2\52"+
            "\1\u008d\27\52",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\u008e\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\u008e\16\52",
            "\1\54\1\uffff\12\52\7\uffff\14\52\1\u008f\15\52\4\uffff\1\52"+
            "\1\uffff\14\52\1\u008f\15\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u0095\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u0095\25\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\30\52\1\u0096\1\52\4\uffff\1\52"+
            "\1\uffff\30\52\1\u0096\1\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\22\52\1\u0097\7\52\4\uffff\1\52"+
            "\1\uffff\22\52\1\u0097\7\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u0098\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u0098\25\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u0099\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u0099\25\52",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\u009a\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\u009a\21\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u009b\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u009b\6\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u009c\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u009c\25\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u009d\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u009d\10\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u009f\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u009f\6\52",
            "\1\54\1\uffff\12\52\7\uffff\2\52\1\u00a0\27\52\4\uffff\1\52"+
            "\1\uffff\2\52\1\u00a0\27\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u00a1\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u00a1\10\52",
            "\1\54\1\uffff\12\52\7\uffff\24\52\1\u00a2\5\52\4\uffff\1\52"+
            "\1\uffff\24\52\1\u00a2\5\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\u00a3\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\u00a3\21\52",
            "\1\54\1\uffff\12\52\7\uffff\16\52\1\u00a4\13\52\4\uffff\1\52"+
            "\1\uffff\16\52\1\u00a4\13\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u00a5\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u00a5\14\52",
            "\1\54\1\uffff\12\52\7\uffff\1\u00a6\31\52\4\uffff\1\52\1\uffff"+
            "\1\u00a6\31\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00a7\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00a7\25\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00a8\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00a8\25\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00a9\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00a9\25\52",
            "\1\54\1\uffff\12\52\7\uffff\1\u00aa\31\52\4\uffff\1\52\1\uffff"+
            "\1\u00aa\31\52",
            "\1\54\1\uffff\12\52\7\uffff\24\52\1\u00ab\5\52\4\uffff\1\52"+
            "\1\uffff\24\52\1\u00ab\5\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u00ac\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u00ac\14\52",
            "\1\54\1\uffff\12\52\7\uffff\7\52\1\u00ad\22\52\4\uffff\1\52"+
            "\1\uffff\7\52\1\u00ad\22\52",
            "\1\54\1\uffff\12\52\7\uffff\22\52\1\u00ae\7\52\4\uffff\1\52"+
            "\1\uffff\22\52\1\u00ae\7\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u00af\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u00af\14\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\23\52"+
            "\1\u00b2\6\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u00b5\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u00b5\10\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00b7\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00b7\25\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u00b8\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u00b8\10\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00ba\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00ba\6\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\2\52\1\u00bc\27\52\4\uffff\1\52"+
            "\1\uffff\2\52\1\u00bc\27\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00bd\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00bd\25\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\u00be\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\u00be\21\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00c0\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00c0\25\52",
            "\1\54\1\uffff\12\52\7\uffff\17\52\1\u00c1\12\52\4\uffff\1\52"+
            "\1\uffff\17\52\1\u00c1\12\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u00c2\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u00c2\14\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u00c3\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u00c3\14\52",
            "\1\54\1\uffff\12\52\7\uffff\6\52\1\u00c4\23\52\4\uffff\1\52"+
            "\1\uffff\6\52\1\u00c4\23\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00c5\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00c5\6\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u00c6\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u00c6\10\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u00c7\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u00c7\10\52",
            "\1\54\1\uffff\12\52\7\uffff\17\52\1\u00c8\12\52\4\uffff\1\52"+
            "\1\uffff\17\52\1\u00c8\12\52",
            "\1\54\1\uffff\12\52\7\uffff\10\52\1\u00c9\21\52\4\uffff\1\52"+
            "\1\uffff\10\52\1\u00c9\21\52",
            "\1\54\1\uffff\12\52\7\uffff\21\52\1\u00ca\10\52\4\uffff\1\52"+
            "\1\uffff\21\52\1\u00ca\10\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00cc\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00cc\6\52",
            "\1\54\1\uffff\12\52\7\uffff\22\52\1\u00cd\7\52\4\uffff\1\52"+
            "\1\uffff\22\52\1\u00cd\7\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00ce\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00ce\6\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\10\52"+
            "\1\u00cf\21\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00d1\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00d1\6\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00d4\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00d4\6\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\15\52\1\u00d6\14\52\4\uffff\1\52"+
            "\1\uffff\15\52\1\u00d6\14\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\6\52\1\u00d9\23\52\4\uffff\1\52"+
            "\1\uffff\6\52\1\u00d9\23\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00dc\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00dc\25\52",
            "\1\54\1\uffff\12\52\7\uffff\22\52\1\u00dd\7\52\4\uffff\1\52"+
            "\1\uffff\22\52\1\u00dd\7\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00df\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00df\6\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00e0\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00e0\6\52",
            "\1\54\1\uffff\12\52\7\uffff\1\u00e1\31\52\4\uffff\1\52\1\uffff"+
            "\1\u00e1\31\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\16\52"+
            "\1\u00e5\13\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\2\52\1\u00e8\27\52\4\uffff\1\52"+
            "\1\uffff\2\52\1\u00e8\27\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\4\52\1\u00eb\25\52\4\uffff\1\52"+
            "\1\uffff\4\52\1\u00eb\25\52",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\13\52\1\u00ee\16\52\4\uffff\1\52"+
            "\1\uffff\13\52\1\u00ee\16\52",
            "",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\15\52"+
            "\1\u00ef\14\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00f0\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00f0\6\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\2\52\1\u00f1\27\52\4\uffff\1\52"+
            "\1\uffff\2\52\1\u00f1\27\52",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\54\1\uffff\12\52\7\uffff\23\52\1\u00f5\6\52\4\uffff\1\52"+
            "\1\uffff\23\52\1\u00f5\6\52",
            "",
            "",
            "",
            "\1\54\1\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( UNKNOWN | FUNCTION | AND | OR | DOT | LBRAC | RBRAC | COMMA | EQ | NEQ | LIKE | LT | GT | LEQ | GEQ | PLUS | MINUS | MULTIPLY | DIVIDE | CONCA | SELECT | ALL | DISTINCT | ON | AS | FROM | WHERE | GROUP | BY | HAVING | UNION | INTERSECT | EXCEPT | ORDER | ASC | DESC | USING | LIMIT | OFFSET | FOR | UPDATE | SHARE | NOWAIT | ONLY | OF | NATURAL | INNER | JOIN | LEFT | RIGHT | FULL | OUTER | CROSS | SUM | MAX | MIN | AVG | COUNT | ID | QUAL_ID | INT | FLOAT | COMMENT | WS | VARCHAR | STRING | CHAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_36 = input.LA(1);

                        s = -1;
                        if ( ((LA23_36 >= '\t' && LA23_36 <= '\n')||LA23_36=='\r'||LA23_36==' ') ) {s = 87;}

                        else if ( ((LA23_36 >= 'a' && LA23_36 <= 'z')) ) {s = 88;}

                        else if ( ((LA23_36 >= 'A' && LA23_36 <= 'Z')) ) {s = 89;}

                        else if ( ((LA23_36 >= '0' && LA23_36 <= '9')) ) {s = 90;}

                        else if ( (LA23_36=='_') ) {s = 91;}

                        else if ( (LA23_36=='-') ) {s = 92;}

                        else if ( (LA23_36=='+') ) {s = 93;}

                        else if ( (LA23_36=='%') ) {s = 94;}

                        else if ( (LA23_36==':') ) {s = 95;}

                        else if ( (LA23_36=='\'') ) {s = 96;}

                        else if ( ((LA23_36 >= '\u0000' && LA23_36 <= '\b')||(LA23_36 >= '\u000B' && LA23_36 <= '\f')||(LA23_36 >= '\u000E' && LA23_36 <= '\u001F')||(LA23_36 >= '!' && LA23_36 <= '$')||LA23_36=='&'||(LA23_36 >= '(' && LA23_36 <= '*')||LA23_36==','||(LA23_36 >= '.' && LA23_36 <= '/')||(LA23_36 >= ';' && LA23_36 <= '@')||(LA23_36 >= '[' && LA23_36 <= '^')||LA23_36=='`'||(LA23_36 >= '{' && LA23_36 <= '\uFFFF')) ) {s = 97;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}