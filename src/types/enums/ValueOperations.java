package types.enums;

public enum ValueOperations {
    ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, OR, AND, UNKNOWN;

    public static ValueOperations getOperation(String value){
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
