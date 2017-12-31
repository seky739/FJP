package types;

import types.enums.ConditionalOperations;

public class Condition extends Expression {

    public ConditionalOperations operation;

    public Expression leftPart, rightPart;

}
