package types.enums;

public enum ValueOperations {
    ADDITION(2), SUBSTRACTION(3), MULTIPLICATION(4), DIVISION(5), OR(2), AND(4), UNKNOWN(8);


    private final int value;

    ValueOperations(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static ValueOperations getOperationByChar(String value){
        switch(value){
            case "+": return ADDITION;
            case "-": return SUBSTRACTION;
            case "*": return MULTIPLICATION;
            case "/": return DIVISION;
            case "||": return OR;
            case "&&": return AND;

            default: return UNKNOWN;
        }
    }


}
