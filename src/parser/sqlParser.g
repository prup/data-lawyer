parser grammar sqlParser;

// We use the sqlLexer and generate as AST.
options {
    tokenVocab = sqlLexer;
    backtrack = true;
    output = AST;
}

@header {
    package parser;
}


aggregator	: SUM | COUNT | MAX | MIN | AVG ;
comparator	: EQ | GT | LEQ | GEQ | LT | NEQ | LIKE;
order_operator	: GT | LT ;
operator	: PLUS| MINUS | MULTIPLY | DIVIDE | CONCA;

column_name	: ID | QUAL_ID ;
type		: UNKNOWN ;
column_alias	: ID ;
alias		: ID ;
function_name	: ID ;
argument	: INT | FLOAT | ID ;
table_name	: ID | QUAL_ID ;

join_type   : INNER? JOIN -> ^(JOIN)
	    | LEFT OUTER? JOIN -> ^(LEFT)
	    | RIGHT OUTER? JOIN -> ^(RIGHT)
	    | FULL OUTER? JOIN -> ^(FULL)
	    | CROSS JOIN!
	    ;

simple_operand	:
	  aggregator^ LBRAC! expression RBRAC!
	| LBRAC! expression RBRAC! operator^ expression
	| LBRAC! expression RBRAC!
	| DISTINCT^ expression
	| function LBRAC expressions RBRAC -> ^(FUNCTION function expressions)
	| column_name
	| INT
	| FLOAT
	| VARCHAR

	;

count	    : INT ;
start	    : INT ;
star	    : MULTIPLY ;

aliased_expressions :	(aliased_expression | expression ) COMMA! aliased_expressions
		    |	(aliased_expression | expression ) ;

aliased_expression  :	expression AS alias -> ^(AS expression alias)
 		    |	expression alias -> ^(AS expression alias) ;

expressions :	expression  COMMA!  expressions
	    |	expression ;


function
	:	ID;


expression  :  simple_operand operator^ expression
	    | 	simple_operand
	    ;


order_expression    :	expression ( ASC | DESC | USING order_operator ) order_expression
		    |	expression ( ASC | DESC | USING order_operator ) ;

conditions  :	condition   COMMA!  conditions
	    |	condition ;

condition   : LBRAC! condition RBRAC! AND^  condition
	    | expression comparator^ expression AND^ condition
	    | LBRAC! condition RBRAC!
	    | expression comparator^ expression
	    ;

select	:   select_block
	    from_block?
	    where_block?
	    group_block?
	    having_block?
	    union_intersect_except_block?
	    limit_block?
	    offset_block?
	    ;

select_block	:   SELECT^ (ALL | DISTINCT ( ON! LBRAC! expressions RBRAC! )? )? (star | aliased_expressions) ;
from_block	:   FROM^ from_items ;
where_block	:   WHERE^ condition ;
group_block	:   GROUP^ BY! expressions ;
having_block	:   HAVING^ conditions ;
union_intersect_except_block	:  (UNION^ | INTERSECT^ | EXCEPT^) (ALL)? LBRAC! select RBRAC! ;
order_block	:   ORDER^ BY! order_expression ;
limit_block	:   LIMIT^ ( count | ALL ) ;
offset_block	:   OFFSET^ start  ;

column_aliases	: column_alias COMMA! column_aliases
		| column_alias ;

arguments	: argument COMMA! arguments
		| argument ;

column_definitions  : column_definition COMMA! column_definitions
		    | column_definition ;

column_definition   : column_name type ;

join_columns	: column_name COMMA! join_columns
		| column_name ;

join_condition	: condition ;

from_items	: from_item COMMA! from_items
		| from_item ;

from_item   : from_item_basic NATURAL? join_type from_item ( ON join_condition | USING LBRAC join_columns RBRAC )?
		-> ^(join_type from_item_basic from_item ^(ON join_condition)?  ^(USING join_columns)?)
	    | from_item_basic
	    ;

// The first two rules could be compressed into one single rule. They are kept
// separate for handling the aliases properly. Note that the order matches, the
// parser will try to match the first rule before it moves on to the second
// one.
from_item_basic   :
		LBRAC select RBRAC AS? alias ( LBRAC column_aliases RBRAC )?
		-> ^(alias select column_aliases?)
	    |	ONLY? table_name star? AS? alias ( LBRAC column_aliases RBRAC )?
		-> ^(alias table_name column_aliases?)
	    |	ONLY? table_name star?
	    	-> ^(table_name)
	    |	function_name LBRAC arguments? RBRAC AS? alias ( LBRAC column_aliases | column_definitions RBRAC )?
	    |	function_name LBRAC arguments? RBRAC AS LBRAC column_definitions RBRAC  ;
