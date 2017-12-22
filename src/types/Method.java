package types;

import types.enums.VarType;

import java.util.List;

public class Method extends Identifier {

    public List<VariableDef> localVars;
    public List<Parameter> parameters;
    public List<Statement> statements;
    public VarType returnType;

    public Method(String name){
        this.name = name;
    }
}
