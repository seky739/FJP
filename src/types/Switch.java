package types;

import java.util.List;

public class Switch extends Statement {
    public List<Condition> cases;
    public Condition defaultCondition;
}
