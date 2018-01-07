package types;

import generator.IGenerable;
import types.enums.StatementType;

import java.util.List;

public class Assignment extends Statement {
    // multiple
    // a := b := c := 5;
    public List<String> varNames;
    public Expression expression;

    public Assignment(){
        this.type = StatementType.ASSIGNMENT;
    }

}
