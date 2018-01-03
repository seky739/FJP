package types;

import types.enums.StatementType;

import java.util.List;

public class ParallelAssignment extends Statement{
    public List<String> variables;
    public List<Integer> values;

    public ParallelAssignment(){
        this.type = StatementType.PARALEL_ASSIGNMENT;
    }
}
