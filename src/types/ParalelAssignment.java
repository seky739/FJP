package types;

import types.enums.StatementType;

import java.util.List;

public class ParalelAssignment extends Assignment{
    public List<VariableDef> variables;
    public List<Integer> values;

    public ParalelAssignment(){
        this.type = StatementType.PARALEL_ASSIGNMENT;
    }
}
