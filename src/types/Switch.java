package types;

import java.util.List;

public class Switch extends Statement {
    public int value; // switch (value){...}
    public List<Expression> cases;
    public Expression defaultExpression;
}
