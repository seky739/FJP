package types;

import types.enums.ConditionalOperations;
import types.enums.StatementType;

import java.util.List;

public class IfCondition extends Statement {
    public Condition condition;

    public List<Statement> statements;
    public List<Statement> elseStatements;

    public IfCondition(){
        this.type = StatementType.IF;
    }
}
