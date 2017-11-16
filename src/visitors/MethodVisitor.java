package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Method;
import types.Parameter;
import types.Statement;
import types.Variable;
import types.enums.VarType;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MethodVisitor extends ExpBaseVisitor<Method> {


    @Override
    public Method visitMethod(ExpParser.MethodContext ctx) {
        Method method = new Method(ctx.IDENT().getText()); // nazev metody je dulezity pro urceni main metody
        System.out.println("Visit method: "+method.name);

        List<Parameter> parameters = ctx.parameter().stream().map(param->getParameter(param)).collect(toList());
        method.parameters = parameters;

        method.returnType = VarType.getType(ctx.returnParam().getText());

        VariableVisitor variableVisitor = new VariableVisitor();
        List<Variable> variables = ctx.parameter().stream().map(variable->variable.accept(variableVisitor)).collect(toList());
        method.localVars = variables;

        StatementVisitor statementVisitor = new StatementVisitor();
        List<Statement> statements = ctx.statement().stream().map(statement->statement.accept(statementVisitor)).collect(toList());
        method.statements = statements;

        return method;
    }


    private Parameter getParameter(ExpParser.ParameterContext ctx) {
        System.out.println("Getting parameter: "+ ctx.IDENT().getText());
        Parameter parameter = new Parameter();
        parameter.type = VarType.getType(ctx.TYPE().getText());
        parameter.name = ctx.IDENT().getText();
        return parameter;
    }


}