package types;

import java.util.List;

public class Cycle extends Statement{

    public Condition condition;
    public UnaryOperation increment; // in for cycle
    public List<Statement> statements;
}
