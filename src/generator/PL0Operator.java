package generator;

public enum PL0Operator {
    UNARY_SUBSRACTION(1),   // unarni minus
    ADDITION(2),            // plus
    SUBSTRACTION(3),        // minus
    MULTIPLICATION(4),      // krat
    DIVISION(5),            // deleno
    MODULO(6),              // modulo
    ODD_NUMBER(7),          // test lichosti
    EQUAL(8),               // test rovnosti
    NEQUAL(9),              // test nerovnosti
    LESS_THAN(10),          // mensi
    GREATER_EQUAL(11),      // vetsi rovno
    GREATER_THAN(12),       // vetsi
    LESS_EQUAL(13)          // mensi rovno
    ;

    private final int code;
    PL0Operator(int code){ this.code = code; }
    public int getCode(){
        return code;
    }
}