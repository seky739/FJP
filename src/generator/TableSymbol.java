package generator;

import types.Identifier;
import types.Method;
import types.Parameter;
import types.VariableDef;
import types.enums.VarType;

public class TableSymbol {
    private Identifier identifier;
    private int addr;
    private int level;
    private boolean isConstant;
    private VarType type;
    private int paramCount;

    public TableSymbol(Identifier identifier, int addr, int level){
        this.identifier = identifier;
        this.addr = addr;
        this.level = level;

        if(identifier instanceof VariableDef || identifier instanceof Parameter){
            VariableDef variableDef = (VariableDef) identifier;
            this.isConstant = variableDef.isVarConstant;
            this.type = variableDef.type;
        }else {
            Method method = (Method) identifier;
            this.paramCount = method.parameters.size();
        }
    }

    public int getParamCount(){return paramCount;}

    public boolean isVariable(){
        return identifier instanceof VariableDef;
    }

    public boolean isMethod(){
        return identifier instanceof Method;
    }

    public boolean isGlobalVar(){
        return isVariable() && this.level == 0;
    }

    public boolean isLocalVar(){
        return isVariable() && this.level > 1;
    }

    public boolean isConstant(){return isVariable() && isConstant; }

    public VarType getType(){return type;}




    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof TableSymbol){
            TableSymbol symbol = (TableSymbol) obj;
            result = symbol.isVariable() && symbol.getLevel() == level && symbol.getIdentifier().name.equals(identifier.name);
        }
        return result;
    }
}
