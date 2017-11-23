package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.IfCondition;

public class IfConditionVisitor extends ExpBaseVisitor<IfCondition> {

    @Override
    public IfCondition visitIfCondition(ExpParser.IfConditionContext ctx) {
        System.out.println("Visit If Conditon");

            IfCondition ifCondition=new IfCondition();
            ConditionVisitor conditionVisitor=new ConditionVisitor();
            StatementVisitor statementVisitor=new StatementVisitor();

            ifCondition.condition=conditionVisitor.visitCondition(ctx.condition());
            if(ctx.statement(0)!=null) {
                System.out.println("Visit Then - if  "+ctx.statement(0).getText());

                ifCondition.thenStatement = statementVisitor.visitStatement(ctx.statement(0));
            }
            if(ctx.statement(1)!=null){
                System.out.println("Visit Else - if  "+ctx.statement(1).getText());

                ifCondition.elseStatement=statementVisitor.visitStatement(ctx.statement(1));
            }

        //from there visit condition
      return ifCondition;
    }
}
