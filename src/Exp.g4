grammar Exp;
program : block '.' ;


block :  variableDef* method+
;

variableDef : variableConst? TYPE IDENT (ASSIGN variableValue)? END_STATEMENT ;
variableConst: 'const';
variableValue: NUMBER|BOOLVALUE;

method: 'function' IDENT '(' (parameter (',' parameter)*)? ')' ':' returnParam  variableDef* '{' statement+ '}';
parameter: TYPE IDENT;
returnParam: TYPE | 'void';

statement :  assignment
              | callStatement END_STATEMENT
              | ifCondition
              | whileStatement
			  | repeatStatement
			  | doWhileStatement
			  | forStatement
			  | switchStatement
			  | ternaryOperation
			  | paralelAssignment
			  | retrn
			  | unaryOperation END_STATEMENT
			;

forStatement: 'for' '('condition';' unaryOperation ')' '{' statement+ '}'; // predelal jsem for aby to bylo mene problematicke
whileStatement: 'while' '('condition')' 'do' '{' statement+ '}';
doWhileStatement: 'do' statement+ 'while' '('condition')' END_STATEMENT;
repeatStatement: 'repeat' '{' statement+ '}' 'until' '(' condition ')' END_STATEMENT;
ifCondition: 'if' '('condition')' '{' (statement)+ '}' (elseStatement)? ;
switchStatement: 'switch' '(' IDENT ')' '{' (cas)* defaultcas'}';
ternaryOperation: IDENT ':=' '(' condition ')' '?' expression ':' expression END_STATEMENT; //TODO neni
callStatement: 'call' IDENT;
elseStatement: 'else' '{' (statement)+ '}';


assignment: IDENT multipleAssignment* ASSIGN (expression|callStatement);
multipleAssignment  : ASSIGN IDENT;
paralelAssignment: '{' IDENT (',' IDENT)+ '}' ASSIGN '{' (expression) (',' (expression))+ '}' END_STATEMENT; //TODO neni


cas : 'case' NUMBER ':' (statement)* 'break'END_STATEMENT;
defaultcas: 'default' ':' (statement)* 'break'END_STATEMENT;

retrn : 'return' IDENT? END_STATEMENT; // return something; / return;
unaryOperation: IDENT unaryOperator; //TODO neni
unaryOperator: '++' | '--'; //TODO neni

condition : expression COMPARATOR expression;

expression : PREOPERATION?term (PREOPERATION term)* //TODO pridelat unarni znamenko pred cislem ... potom
        | NEGATION?factor (BOOLOPERATION NEGATION?factor)*
        ; //TODO mozna jeste neco chybi.. zatim mi nic nenapada

term : factor (MULDIV factor)*; //pridano kvuli operaci nasobeni a deleni

factor : BOOLVALUE
        | NUMBER
        | callStatement //TODO check
        | '(' expression ')'
        | IDENT;

//lexer rules

BOOLVALUE : 'true' | 'false';
TYPE : 'bool' | 'int';
COMPARATOR: '='|'#'|'<'|'<='|'>'|'>=';
PREOPERATION: '+' | '-' ;
BOOLOPERATION: '|' | '&';
MULDIV : '*' | '/';
ASSIGN: ':=';
END_STATEMENT: ';';
NEGATION: '!';
// this lexer rules have to be in the last place
IDENT : ([a-zA-Z])([a-zA-Z0-9])*;
NUMBER : [0-9]+;

// skipped tokens
WS :   [ \t\r\n] -> skip ;



