package types;

import types.enums.StatementType;
import types.enums.ValueOperations;

import java.util.List;

public class Expression extends Statement{
    public List<Term> terms;
    public List<ValueOperations> operations;

    public Expression(){
        this.type = StatementType.EXPRESSION;
    }
    public int getTermCount(){
        return terms.size();
    }

    public boolean isOperationEmpty(){
        return operations == null || operations.size() == 0;
    }

    public boolean isSingleTerm(){
        return terms.size() == 1;
    }
}
