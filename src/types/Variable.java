package types;

import types.enums.VarType;

public class Variable extends Identificator {
    public VarType type;
    public boolean isConstant;
    public int value;
    public boolean initialized;
}
