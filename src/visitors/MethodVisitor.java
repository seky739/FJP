package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.*;
import types.enums.VarType;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MethodVisitor extends ExpBaseVisitor<Method> {


    @Override
    public Method visitMethod(ExpParser.MethodContext ctx) {
        Method method = new Method(ctx.IDENT().getText()); // nazev metody je dulezity pro urceni main metody

        method.parameters = ctx.parameter().stream().map(param->getParameter(param)).collect(toList());

        method.returnType = VarType.getType(ctx.returnParam().getText());
        ReturnVisitor returnVisitor = new ReturnVisitor();
        ExpParser.RetrnContext ret = ctx.retrn();
        method.rturn = returnVisitor.visitRetrn(ctx.retrn());

        VariableVisitor variableVisitor = new VariableVisitor();
        method.localVars = ctx.variableDef().stream().map(variableContext->variableContext.accept(variableVisitor)).collect(toList());

        StatementVisitor statementVisitor = new StatementVisitor();
        method.statements = ctx.statement().stream().map(statementContext->statementContext.accept(statementVisitor)).collect(toList());

        return method;
    }


    private Parameter getParameter(ExpParser.ParameterContext ctx) {
        Parameter parameter = new Parameter();
        parameter.type = VarType.getType(ctx.TYPE().getText());
        parameter.name = ctx.IDENT().getText();
        return parameter;
    }


}
