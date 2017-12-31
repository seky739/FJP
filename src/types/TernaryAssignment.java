package types;

import types.enums.StatementType;

public class TernaryAssignment extends Statement{

    public VariableDef variableDef;
    public Condition condition;
    public Expression trueExpression, falseExpression;

    public TernaryAssignment(){
        this.type = StatementType.TERNARY;
    }
}
