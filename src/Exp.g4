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
callStatement: 'call' IDENT '(' callParam? ')';
elseStatement: 'else' '{' (statement)+ '}';

callParam: (IDENT (',' IDENT)*);
assignment: IDENT multipleAssignment* ASSIGN (expression|callStatement) END_STATEMENT;
multipleAssignment  : ASSIGN IDENT;
paralelAssignment: '{' IDENT (',' IDENT)+ '}' ASSIGN '{' (variableValue) (',' (variableValue))+ '}' END_STATEMENT; //TODO neni


cas : 'case' NUMBER ':' (statement)* 'break'END_STATEMENT;
defaultcas: 'default' ':' (statement)* 'break'END_STATEMENT;

retrn : 'return' IDENT? END_STATEMENT; // return something; / return;
unaryOperation: unaryOperator IDENT; //TODO neni
unaryOperator: '++' | '--'; //TODO neni

condition : expression COMPARATOR expression;

expression : term ((PREOPERATION|BOOLOPERATION) term)* //TODO pridelat unarni znamenko pred cislem ... potom
        ; //TODO mozna jeste neco chybi.. zatim mi nic nenapada

term : factor (MULDIV factor)*; //pridano kvuli operaci nasobeni a deleni

factor : NEGATION? BOOLVALUE
        | PREOPERATION? NUMBER
        | callStatement //TODO check
        | '(' expression ')'
        | (NEGATION|PREOPERATION)? IDENT;

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



