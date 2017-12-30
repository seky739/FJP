package types;


import types.enums.ValueOperations;

import java.util.List;

public class Term  {
    public List<Factor> factor;
    public List<ValueOperations> operations;

    public int getFactorCount(){
        return factor.size();
    }
}
