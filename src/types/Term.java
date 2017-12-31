package types;


import types.enums.ValueOperations;

import java.util.List;

public class Term  {
    public List<Factor> factors;
    public List<ValueOperations> operations;

    public int getFactorCount(){
        return factors.size();
    }
}
