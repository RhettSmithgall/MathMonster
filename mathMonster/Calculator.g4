
grammar Calculator;

// parser

start : expr | <EOF> ;

expr  : '-' expr         	  # UMINUS
      | '(' expr ')'          # PARENGRP
      | funcname '(' expr ')' # TRIGOPGRP
      | expr exop expr        # EXOPGRP
      | expr mulop expr       # MULOPGRP
      | expr addop expr  	  # ADDOPGRP
      | VARIABLE              # VARIABLEGRP
      | NUMBER                # DOUBLE
      | constant 	          # IRRATIONAL
      ;
      
equals: '=' ;

addop : '+' | '-' ;

mulop : '*' | '/' | '%' ;

exop: '^' ;

funcname
    : COS
    | TAN
    | SIN
    | ACOS
    | ATAN
    | ASIN
    | LOG
    | LN
    | SQRT
    ;

constant
    : PI
    | EULER
    ;

// lexer
VARIABLE: [a-zA-Z] ;

PI 
    : 'pi'
    ;

EULER
    : 'e'
    ;

COS
    : 'cos'
    ;

SIN
    : 'sin'
    ;

TAN
    : 'tan'
    ;

ACOS
    : 'acos'
    ;

ASIN
    : 'asin'
    ;

ATAN
    : 'atan'
    ;
LN
    : 'ln'
    ;

LOG
    : 'log'
    ;

SQRT
    : 'sqrt'
    ;


NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

WS : [ \r\n\t] + -> skip ;