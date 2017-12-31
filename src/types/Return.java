package types;

import types.enums.StatementType;

public class Return extends Statement {
    public VariableDef value;

    public Return(){
        this.type = StatementType.RETURN;
    }
}
