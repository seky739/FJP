package types;

import types.enums.StatementType;

import java.util.List;

public class Call extends Statement {

    public String functionName;
    public List<String> parameters;

    public Call(){
        this.type = StatementType.CALL;
    }
}
