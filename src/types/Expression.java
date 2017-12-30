package types;

import types.enums.ValueOperations;

import java.util.List;

public class Expression extends Statement{
    public List<Term> terms;
    public List<ValueOperations> operations;

    public int getTermCount(){
        return terms.size();
    }
}
