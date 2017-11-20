package types;

import java.util.List;

public class Assignment extends Statement{
    // multiple
    public List<String> varNames;
    public List<Expression> expressions;
}
