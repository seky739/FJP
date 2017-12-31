package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.UnaryOperation;
import types.VariableDef;

public class UnaryVisitor extends ExpBaseVisitor<UnaryOperation> {

    @Override
    public UnaryOperation visitUnaryOperation(ExpParser.UnaryOperationContext ctx) {

        String unaryChars = ctx.unaryOperator().getText();
        VariableDef variableDef = new VariableDef();
        variableDef.name = ctx.IDENT().getText();
        variableDef.isConstant = false;
        UnaryOperation operation = new UnaryOperation();
        operation.increment = unaryChars.equalsIgnoreCase("++") ? true: false;
        operation.variable = variableDef;

        return operation;
    }
}
