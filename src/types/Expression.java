package types;

import types.enums.AlgebraicOperations;

import java.util.List;

public class Expression extends Statement{
    public List<VariableDef> variableDefs;
    public List<AlgebraicOperations> operations;

    public List<Term> terms;
}
