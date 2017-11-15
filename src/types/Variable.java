package types;

import types.enums.VarType;

public class Variable extends Identificator {
    public VarType type;
    public boolean isConstant;
    public int value; // for bool value, 0 = false, otherwise = true
    public boolean initialized; // assigned?

    public String toString(){
        return ((isConstant) ? "constant ":"") + type.getValue()+ " " + name + " = " + value;
    }
}
