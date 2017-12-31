package types;

import types.enums.StatementType;

public class UnaryOperation extends Statement{
    public VariableDef variable;
    public boolean increment;
    public boolean isPreorder;

    public UnaryOperation(){
        variable = null;
        increment = true;
        isPreorder = true;
        this.type = StatementType.UNARY;
    }
}
