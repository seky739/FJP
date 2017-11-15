package types.enums;

public enum VarType {
    NUMBER("int"),
    BOOL("bool"),
    VOID("void"); // <-- only for return

    private final String value;
    VarType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static VarType getType(String textValue){
        if(textValue.equalsIgnoreCase(NUMBER.value)){
            return NUMBER;
        }else {
            return BOOL;
        }
    }
}
