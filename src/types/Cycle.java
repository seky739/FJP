package types;

import java.util.List;

public class Cycle extends Statement{

    public Condition condition;
    public Assignment assignment; // for cycle
    public List<Statement> statements;
}
