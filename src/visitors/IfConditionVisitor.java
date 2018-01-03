package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.IfCondition;

import static java.util.stream.Collectors.toList;

public class IfConditionVisitor extends ExpBaseVisitor<IfCondition> {

    @Override
    public IfCondition visitIfCondition(ExpParser.IfConditionContext ctx) {
        IfCondition ifCondition = new IfCondition();
        ConditionVisitor conditionVisitor = new ConditionVisitor();
        StatementVisitor statementVisitor = new StatementVisitor();

        ifCondition.condition = conditionVisitor.visitCondition(ctx.condition());


        ifCondition.statements = ctx.statement().stream().map(method->method.accept(statementVisitor)).collect(toList());

        if(ctx.elseStatement()!=null){
            ifCondition.elseStatements = ctx.elseStatement().statement().stream().map(method->method.accept(statementVisitor)).collect(toList());
        }

        //from there visit condition
      return ifCondition;
    }
}
