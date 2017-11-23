package types.enums;

public enum AlgebraicOperations {
    ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION,UNKNOWN;

    public static AlgebraicOperations getOperation(String value){
        switch(value){
            case "+": return ADDITION;
            case "-": return SUBSTRACTION;
            case "*": return MULTIPLICATION;
            case "/": return DIVISION;
            default: return UNKNOWN;
        }
    }


}
