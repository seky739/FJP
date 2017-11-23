package types.enums;

public enum ConditionalOperations {
    EQUAL,NOT_EQUAL, GREATER_THAN, GREATER_OR_EQUAL, LESS_THAN, LESS_OR_EQUAL, UNKNOWN;

    public static ConditionalOperations getValue(String val){
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

