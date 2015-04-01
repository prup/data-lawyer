// $ANTLR 3.4 /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g 2012-05-18 21:57:55

    package parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class datalogLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public datalogLexer() {} 
    public datalogLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public datalogLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g"; }

    // $ANTLR start "BOT"
    public final void mBOT() throws RecognitionException {
        try {
            int _type = BOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:8:5: ( 'B' 'O' 'T' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:8:7: 'B' 'O' 'T'
            {
            match('B'); 

            match('O'); 

            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOT"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:9:5: ( ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:9:7: ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' )
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

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:10:7: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 't' | 'T' ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:10:9: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 't' | 'T' )
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

    // $ANTLR start "LBRAC"
    public final void mLBRAC() throws RecognitionException {
        try {
            int _type = LBRAC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:11:7: ( '(' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:11:9: '('
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:12:7: ( ')' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:12:9: ')'
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

    // $ANTLR start "ISEQUAL"
    public final void mISEQUAL() throws RecognitionException {
        try {
            int _type = ISEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:9: ( ( ':' '=' | ':' '-' | ':' | '-' ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:11: ( ':' '=' | ':' '-' | ':' | '-' )
            {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:11: ( ':' '=' | ':' '-' | ':' | '-' )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==':') ) {
                switch ( input.LA(2) ) {
                case '=':
                    {
                    alt1=1;
                    }
                    break;
                case '-':
                    {
                    alt1=2;
                    }
                    break;
                default:
                    alt1=3;
                }

            }
            else if ( (LA1_0=='-') ) {
                alt1=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:13: ':' '='
                    {
                    match(':'); 

                    match('='); 

                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:23: ':' '-'
                    {
                    match(':'); 

                    match('-'); 

                    }
                    break;
                case 3 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:33: ':'
                    {
                    match(':'); 

                    }
                    break;
                case 4 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:13:39: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ISEQUAL"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:14:7: ( ',' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:14:9: ','
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:15:4: ( '=' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:15:6: '='
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

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:16:4: ( '>' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:16:6: '>'
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:17:5: ( '<=' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:17:7: '<='
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:18:5: ( '>=' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:18:7: '>='
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:21:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:21:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:21:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:24:5: ( ( '0' .. '9' )+ )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:24:7: ( '0' .. '9' )+
            {
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:24:7: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:28:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:28:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                    {
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:28:9: ( '0' .. '9' )+
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
                    	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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


                    match('.'); 

                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:28:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
                    	    break loop5;
                        }
                    } while (true);


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:28:37: ( EXPONENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:28:37: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:29:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                    {
                    match('.'); 

                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:29:13: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:29:25: ( EXPONENT )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='E'||LA8_0=='e') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:29:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:30:9: ( '0' .. '9' )+ EXPONENT
                    {
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:30:9: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:34:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='/') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='/') ) {
                    alt14=1;
                }
                else if ( (LA14_1=='*') ) {
                    alt14=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:34:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:34:14: (~ ( '\\n' | '\\r' ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
                    	    break loop11;
                        }
                    } while (true);


                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:34:28: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:34:28: '\\r'
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
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:35:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:35:14: ( options {greedy=false; } : . )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='*') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='/') ) {
                                alt13=2;
                            }
                            else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '.')||(LA13_1 >= '0' && LA13_1 <= '\uFFFF')) ) {
                                alt13=1;
                            }


                        }
                        else if ( ((LA13_0 >= '\u0000' && LA13_0 <= ')')||(LA13_0 >= '+' && LA13_0 <= '\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:35:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:38:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:38:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:46:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:46:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:46:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\\') ) {
                    alt15=1;
                }
                else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '!')||(LA15_0 >= '#' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:46:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:46:24: ~ ( '\\\\' | '\"' )
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
            	    break loop15;
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:49:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:49:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:49:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                alt16=1;
            }
            else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '&')||(LA16_0 >= '(' && LA16_0 <= '[')||(LA16_0 >= ']' && LA16_0 <= '\uFFFF')) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:49:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:49:25: ~ ( '\\'' | '\\\\' )
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:53:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:53:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:53:22: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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


            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:53:33: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:56:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:60:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\\') ) {
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
                    alt19=1;
                    }
                    break;
                case 'u':
                    {
                    alt19=2;
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
                    alt19=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:60:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:61:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:62:9: OCTAL_ESC
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:67:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\\') ) {
                int LA20_1 = input.LA(2);

                if ( ((LA20_1 >= '0' && LA20_1 <= '3')) ) {
                    int LA20_2 = input.LA(3);

                    if ( ((LA20_2 >= '0' && LA20_2 <= '7')) ) {
                        int LA20_4 = input.LA(4);

                        if ( ((LA20_4 >= '0' && LA20_4 <= '7')) ) {
                            alt20=1;
                        }
                        else {
                            alt20=2;
                        }
                    }
                    else {
                        alt20=3;
                    }
                }
                else if ( ((LA20_1 >= '4' && LA20_1 <= '7')) ) {
                    int LA20_3 = input.LA(3);

                    if ( ((LA20_3 >= '0' && LA20_3 <= '7')) ) {
                        alt20=2;
                    }
                    else {
                        alt20=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:67:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
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
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:68:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
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
                    // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:69:9: '\\\\' ( '0' .. '7' )
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
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:74:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:74:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
        // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:8: ( BOT | SUM | COUNT | LBRAC | RBRAC | ISEQUAL | COMMA | EQ | GT | LEQ | GEQ | ID | INT | FLOAT | COMMENT | WS | STRING | CHAR )
        int alt21=18;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:10: BOT
                {
                mBOT(); 


                }
                break;
            case 2 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:14: SUM
                {
                mSUM(); 


                }
                break;
            case 3 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:18: COUNT
                {
                mCOUNT(); 


                }
                break;
            case 4 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:24: LBRAC
                {
                mLBRAC(); 


                }
                break;
            case 5 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:30: RBRAC
                {
                mRBRAC(); 


                }
                break;
            case 6 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:36: ISEQUAL
                {
                mISEQUAL(); 


                }
                break;
            case 7 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:44: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 8 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:50: EQ
                {
                mEQ(); 


                }
                break;
            case 9 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:53: GT
                {
                mGT(); 


                }
                break;
            case 10 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:56: LEQ
                {
                mLEQ(); 


                }
                break;
            case 11 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:60: GEQ
                {
                mGEQ(); 


                }
                break;
            case 12 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:64: ID
                {
                mID(); 


                }
                break;
            case 13 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:67: INT
                {
                mINT(); 


                }
                break;
            case 14 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:71: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 15 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:77: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 16 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:85: WS
                {
                mWS(); 


                }
                break;
            case 17 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:88: STRING
                {
                mSTRING(); 


                }
                break;
            case 18 :
                // /Users/prasang/Documents/workspace/drm/src/parser/datalogLexer.g:1:95: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA10_eotS =
        "\5\uffff";
    static final String DFA10_eofS =
        "\5\uffff";
    static final String DFA10_minS =
        "\2\56\3\uffff";
    static final String DFA10_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA10_specialS =
        "\5\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "27:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\3\13\5\uffff\1\26\2\uffff\1\27\5\uffff\3\13\3\uffff\1\33"+
        "\1\34\1\13\2\uffff\1\13\1\37\1\uffff";
    static final String DFA21_eofS =
        "\40\uffff";
    static final String DFA21_minS =
        "\1\11\1\117\1\125\1\117\5\uffff\1\75\2\uffff\1\56\5\uffff\1\124"+
        "\1\115\1\125\3\uffff\2\60\1\116\2\uffff\1\124\1\60\1\uffff";
    static final String DFA21_maxS =
        "\1\172\1\117\1\165\1\157\5\uffff\1\75\2\uffff\1\145\5\uffff\1\124"+
        "\1\155\1\165\3\uffff\2\172\1\156\2\uffff\1\164\1\172\1\uffff";
    static final String DFA21_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\14\1\uffff\1\16\1\17"+
        "\1\20\1\21\1\22\3\uffff\1\13\1\11\1\15\3\uffff\1\1\1\2\2\uffff\1"+
        "\3";
    static final String DFA21_specialS =
        "\40\uffff}>";
    static final String[] DFA21_transitionS = {
            "\2\17\2\uffff\1\17\22\uffff\1\17\1\uffff\1\20\4\uffff\1\21\1"+
            "\4\1\5\2\uffff\1\7\1\6\1\15\1\16\12\14\1\6\1\uffff\1\12\1\10"+
            "\1\11\2\uffff\1\13\1\1\1\3\17\13\1\2\7\13\4\uffff\1\13\1\uffff"+
            "\2\13\1\3\17\13\1\2\7\13",
            "\1\22",
            "\1\23\37\uffff\1\23",
            "\1\24\37\uffff\1\24",
            "",
            "",
            "",
            "",
            "",
            "\1\25",
            "",
            "",
            "\1\15\1\uffff\12\14\13\uffff\1\15\37\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\30",
            "\1\31\37\uffff\1\31",
            "\1\32\37\uffff\1\32",
            "",
            "",
            "",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\1\35\37\uffff\1\35",
            "",
            "",
            "\1\36\37\uffff\1\36",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( BOT | SUM | COUNT | LBRAC | RBRAC | ISEQUAL | COMMA | EQ | GT | LEQ | GEQ | ID | INT | FLOAT | COMMENT | WS | STRING | CHAR );";
        }
    }
 

}