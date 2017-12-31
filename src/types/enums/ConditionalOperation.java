package types.enums;

public enum ConditionalOperation {
    EQUAL(8),NOT_EQUAL(9), GREATER_THAN(12), GREATER_OR_EQUAL(11), LESS_THAN(10), LESS_OR_EQUAL(13), UNKNOWN(0);

    private final int value;

    ConditionalOperation(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }


    public static ConditionalOperation getValue(String val){
        switch (val){


            case "=" :
                return EQUAL;

            case "!=" :
                return NOT_EQUAL;

            case ">" :
                return GREATER_THAN;

            case ">=" :
                return GREATER_OR_EQUAL;

            case "<" :
                return LESS_THAN;

            case "<=" :
                return LESS_OR_EQUAL;

            default: return UNKNOWN;
        }

    }
}

