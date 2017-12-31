package types;

import types.enums.ConditionalOperation;

public class Condition extends Expression {

    public ConditionalOperation operation;

    public Expression leftPart, rightPart;

}
