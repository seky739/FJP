package types;

import types.enums.VarType;

import java.util.List;

public class Method extends Identifier {

    public List<VariableDef> localVars;
    public List<Parameter> parameters;
    public List<Statement> statements;
    public VarType returnType;
    public Return rturn;

    public Method(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name+": ");
        for (Parameter p :
                parameters) {
            stringBuilder.append(p.name+", ");
        }
        return stringBuilder.toString();
    }
}
