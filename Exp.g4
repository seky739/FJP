grammar Exp;
program : block '.' ;



block :  ('const' type IDENT ':=' NUMBER  (',' IDENT ':=' NUMBER)* ';')*
        |(type IDENT (',' IDENT)* ';')*
        | ('function' IDENT '(' (type IDENT (',' type IDENT)* )? ')' ':' type | 'void' ';' block ';' )* statement;




statement :  IDENT ':=' multipleAssigned ';'
              | 'call' IDENT
              | 'begin' statement (';' statement )* 'end'
              | 'if' condition 'then' statement+ ('else' statement+)?
              | 'while' '(' condition ')' 'do' statement
			  | 'repeat' statement 'until' '(' condition ')'
			  | 'do' statement 'while' '(' condition ')'
			  | 'for' '(' IDENT ':=' NUMBER ';' condition ';'  forStatement ')' statement // forStatement by mel byt tak abych nemohl volat funkci nebo delat ruzny bordel
			  | 'switch' '(' condition ')' '{' cas* defaultcas'}'
			  | IDENT ':=' '(' condition ')' '?' expression ':' expression ';'
			  | '{' IDENT (',' IDENT)+ '}' '=' '{' (NUMBER | BOOLVALUE) (',' (NUMBER | BOOLVALUE))+ '}' // tady by melo byt expression aby to bylo a=1 {a,b,c}={a++,++a,a+1} bacha na ssemantiku
			  | 'return' retrn? ';'
			;



retrn : IDENT;

forStatement :	IDENT ':=' expression;

cas : 'case' NUMBER ':' statement* 'break'';';

defaultcas: 'default' ':' statement* 'break'';';


multipleAssigned  : (IDENT ':=')* expression;

condition : expression ('='|'#'|'<'|'<='|'>'|'>=') expression;

type : 'boolean'
        | ' int';

expression : ( '+'|'-') term ( ('+'|'-') term)*;

term : factor (('*'|'/') factor)*;

factor : IDENT
        | NUMBER
        | '(' expression ')';

IDENT : ([a-z]
        |[ A-Z])([a-z]
        | [A-Z]
        |[0-9])*;

NUMBER : [0-9][0-9]*;
BOOLVALUE : 'true' | 'false';

WhiteSpace : (' '|'\t') -> skip;
NewLine : ('\r'?'\n'|'\r') -> skip;


