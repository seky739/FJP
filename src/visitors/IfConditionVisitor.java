package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.IfCondition;

import static java.util.stream.Collectors.toList;

public class IfConditionVisitor extends ExpBaseVisitor<IfCondition> {

    @Override
    public IfCondition visitIfCondition(ExpParser.IfConditionContext ctx) {
        System.out.println("Visit If Conditon");

        IfCondition ifCondition=new IfCondition();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        StatementVisitor statementVisitor=new StatementVisitor();

        ifCondition.condition = conditionVisitor.visitCondition(ctx.condition());


        ifCondition.statements = ctx.statement().stream().map(method->method.accept(statementVisitor)).collect(toList());

        if(ctx.elseStatement()!=null){
            System.out.println("Visit Else");
            ifCondition.elseStatements = ctx.statement().stream().map(method->method.accept(statementVisitor)).collect(toList());
        }

        //from there visit condition
      return ifCondition;
    }
}
