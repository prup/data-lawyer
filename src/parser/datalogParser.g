parser grammar datalogParser;

// We use the datalogLexer and generate as AST.
options {
	tokenVocab = datalogLexer;
    backtrack = true;
	output = AST;
}

@header {
    package parser;
}


query : headpredicate (ISEQUAL | EQ)^  body;

headpredicate : ID^ LBRAC! headvarlist RBRAC!
    | BOT^
    ;

headvarlist	: (ID | aggregatevar) COMMA! headvarlist
    | (ID | aggregatevar) 
    | 
    ;
aggregatevar :  aggregate^ LBRAC! ID RBRAC!
	;
    
aggregate : SUM | COUNT;

body : (predicate | clause) COMMA! body
	| (predicate | clause) body 
    | (predicate | clause) 
   	;

predicate : ID^ LBRAC! varlist RBRAC!;

varlist : ID COMMA! varlist
    | ID 
    |
    ;

clause : ID (EQ^ STRING | compare^ (INT | FLOAT | ID));

compare	: (EQ | GT | LEQ | GEQ);
