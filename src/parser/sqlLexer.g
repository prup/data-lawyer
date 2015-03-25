lexer grammar sqlLexer;

@header {
    package parser;
}

UNKNOWN	: '@#$%' ;

FUNCTION 
	: 'function';

AND 	: ('a' | 'A') ('n' | 'N') ('d' | 'D') ;
OR 	: ('o' | 'O') ('r' | 'R') ;

DOT	:   '.'	;

LBRAC	: '(' ;
RBRAC	: ')' ;
COMMA	: ',' ;
EQ  : '=';
NEQ  : '<>';
LIKE 	:	('l' | 'L') ('i' | 'I') ('k' | 'K') ('e' | 'E');
LT  : '<';
GT  : '>';
LEQ	: '<=';
GEQ	: '>=';
PLUS	    :   '+';
MINUS	    :   '-';
MULTIPLY    :	'*';
DIVIDE	    :   '/';
CONCA       
	:	 '||';

SELECT	: ('s' | 'S') ('e' | 'E') ('l' | 'L') ('e' | 'E') ('c' | 'C') ('t' | 'T');
ALL	: ('a' | 'A') ('l' | 'L') ('l' | 'L');
DISTINCT    : ('d' | 'D') ('i' | 'I') ('s' | 'S') ('t' | 'T') ('i' | 'I') ('n' | 'N') ('c' | 'C') ('t' | 'T');
ON	: ('o' | 'O') ('n' | 'N');
AS	: ('a' | 'A') ('s' | 'S');

FROM	: ('f' | 'F') ('r' | 'R') ('o' | 'O') ('m' | 'M');

WHERE	: ('w' | 'W') ('h' | 'H') ('e' | 'E') ('r' | 'R') ('e' | 'E');

GROUP	: ('g' | 'G') ('r' | 'R') ('o' | 'O') ('u' | 'U') ('p' | 'P');
BY	: ('b' | 'B') ('y' | 'Y');
HAVING	: ('h' | 'H') ('a' | 'A') ('v' | 'V') ('i' | 'I') ('n' | 'N') ('g' | 'G');

UNION	: ('u' | 'U') ('n' | 'N') ('i' | 'I') ('o' | 'O') ('n' | 'N');
INTERSECT   : ('i' | 'I') ('n' | 'N') ('t' | 'T') ('e' | 'E') ('r' | 'R') ('s' | 'S') ('e' | 'E') ('c' | 'C') ('t' | 'T');
EXCEPT	: ('e' | 'E') ('x' | 'X') ('c' | 'C') ('e' | 'E') ('p' | 'P') ('t' | 'T');

ORDER	: ('o' | 'O') ('r' | 'R') ('d' | 'D') ('e' | 'E') ('r' | 'R');
ASC	: ('a' | 'A') ('s' | 'S') ('c' | 'C');
DESC	: ('d' | 'D') ('e' | 'E') ('s' | 'S') ('c' | 'C');
USING	: ('u' | 'U') ('s' | 'S') ('i' | 'I') ('n' | 'N') ('g' | 'G');
LIMIT	: ('l' | 'L') ('i' | 'I') ('m' | 'M') ('i' | 'I') ('t' | 'T');
OFFSET	: ('o' | 'O') ('f' | 'F') ('f' | 'F') ('s' | 'S') ('e' | 'E') ('t' | 'T');

FOR	: ('f' | 'F') ('o' | 'O') ('r' | 'R');
UPDATE	: ('u' | 'U') ('p' | 'P') ('d' | 'D') ('a' | 'A') ('t' | 'T') ('e' | 'E');
SHARE	: ('s' | 'S') ('h' | 'H') ('a' | 'A') ('r' | 'R') ('e' | 'E');
NOWAIT	: ('n' | 'N') ('o' | 'O') ('w' | 'W') ('a' | 'A') ('i' | 'I') ('t' | 'T');
ONLY	: ('o' | 'O') ('n' | 'N') ('l' | 'L') ('y' | 'Y');
OF      : ('o' | 'O') ('f' | 'F');

NATURAL	: ('n' | 'N') ('a' | 'A') ('t' | 'T') ('u' | 'U') ('r' | 'R') ('a' | 'A') ('l' | 'L');
INNER	: ('i' | 'I') ('n' | 'N') ('n' | 'N') ('e' | 'E') ('r' | 'R')  ;
JOIN	: ('j' | 'J') ('o' | 'O') ('i' | 'I') ('n' | 'N')  ;
LEFT	: ('l' | 'L') ('e' | 'E') ('f' | 'F') ('t' | 'T')  ;
RIGHT	: ('r' | 'R') ('i' | 'I') ('g' | 'G') ('h' | 'H') ('t' | 'T')  ;
FULL	: ('f' | 'F') ('u' | 'U') ('l' | 'L') ('l' | 'L')  ;
OUTER	: ('o' | 'O') ('u' | 'U') ('t' | 'T') ('e' | 'E') ('r' | 'R')  ;
CROSS	: ('c' | 'C') ('r' | 'R') ('o' | 'O') ('s' | 'S') ('s' | 'S')  ;

SUM	: ('s' | 'S') ('u' | 'U') ('m' | 'M')  ;
MAX	: ('m' | 'M') ('a' | 'A') ('x' | 'X')  ;
MIN	: ('m' | 'M') ('i' | 'I') ('n' | 'N')  ;
AVG	: ('a' | 'A') ('v' | 'V') ('g' | 'G')  ;
COUNT	: ('c' | 'C') ('o' | 'O') ('u' | 'U') ('n' | 'N') ('t' | 'T');

ID      : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

QUAL_ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* '.' ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*  ;

INT :	'0'..'9'+ ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
       ) {$channel=HIDDEN;} // The hidden channel, when enaabled ignores whitespace.
    ;

VARCHAR	:   '\'' (WS|'a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'+'|'%'|':')* '\'';

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
