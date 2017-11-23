package types;

import types.enums.ConditionalOperations;

import java.util.List;

public class IfCondition  {
    public Condition condition;

    public List<Statement> statements;
    public List<Statement> elseStatements;
}
