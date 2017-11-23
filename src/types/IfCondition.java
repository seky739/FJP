package types;

import types.enums.ConditionalOperations;

public class IfCondition extends Condition {
    public ConditionalOperations operation;

    public Expression leftPart, rightPart;

    public boolean isNegation;
}
