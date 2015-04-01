package parser;


/**
 * What does an AST node look like? They are operators. With input columns,
 * output columns, operations. Operations are defined for each output column.
 * So, we have an array of output columns and a corresponding array of
 * operations.
 * 
 * So, we have classes for the operations and for columns.
 * 
 * Can't we restrict one column modification per node? Creates many more trees.
 * And in general, it is a good idea to think of every data structure as a set.
 * Allows for easy extensibility, space savings, and easier sophisticated logic.
 * 
 * So, we allow multiple operations to be permitted at a single operator. But, I
 * am leaning towards restricted the multiple operators at a particular node to
 * be of the same type. So, if you have a computed expression, we do not merge
 * it with a selection on predicates.
 * 
 * So, what does this permit us to do? Represent n-way joins for one and
 * multiple aggregates, multiple single-value transformations, all selection
 * criteria for joins and for individual tables and for grouped columns having
 * conditions.
 * 
 * How do we represent constants? Represent them as columns from another
 * relation? So, where do we store this information? Do we carry it around? Do
 * we need this constant's value. Should the logical optimizer need to worry
 * about this value? Do we use a global metadata structure?
 * 
 * I am going with the metadata approach. Why? Because then it allows us to do
 * things in a need-to-know basis and forces the proper compartmentalization of
 * the different functions that lead to query execution.
 * 
 * @author prasang
 * 
 */
