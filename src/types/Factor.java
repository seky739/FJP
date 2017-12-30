package types;

import types.enums.FactorType;

public class Factor extends Identifier{

    public FactorType factorType;//type of factor 0 - boolean, 1- int, 2-identificator

    public Expression expression;
    public VariableDef vardef;

    public Factor(Expression expression){
        this.factorType = FactorType.EXPRESSION;
        this.expression = expression;
    }

    public Factor(VariableDef variableDef){
        this.factorType = variableDef.getFactorType();
        this.vardef = variableDef;
    }

    public Factor(Call call){
        this.factorType = FactorType.CALL;
    }

    public Factor(){}
}
