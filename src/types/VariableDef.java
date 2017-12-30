package types;

import types.enums.FactorType;
import types.enums.VarType;

public class VariableDef extends Identifier {
    public VarType type;
    public boolean isConstant;
    public int value; // for bool value, 0 = false, otherwise = true
    public boolean initialized; // assigned?
    public boolean negative;

    public VariableDef(){
        isConstant = false;
        value = 0;
        initialized = false;
        negative = false;
    }

    public String toString(){
        return ((isConstant) ? "constant ":"") + type.getValue()+ " " + name + " = " + value;
    }

    public FactorType getFactorType(){
        if(isConstant){
            if(type == VarType.NUMBER){
                return FactorType.NUMBER;
            }else {
                return FactorType.BOOLEAN;
            }
        }else {
            return FactorType.VARIABLE;
        }
    }

    public void setConstantBool(String value){
        this.type = VarType.BOOL;
        this.isConstant = true;
        this.initialized = false;
        if(value.equalsIgnoreCase("true")){
            this.value = 1;
        }else {
            this.value = 0;
        }
    }

    public void setConstantNumber(String value){
        this.type = VarType.NUMBER;
        this.isConstant = true;
        this.initialized = false;
        this.value = Integer.parseInt(value);
    }

}
