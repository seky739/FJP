package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Statement;

public class StatementVisitor extends ExpBaseVisitor<Statement>{

    @Override
    public Statement visitStatement(ExpParser.StatementContext ctx) {
        System.out.println("Visit statement");

        // very long IFs
        if(ctx.assignment() != null){

        }else if (ctx.statement() != null){

        }else if(ctx.ifCondition() != null){

        }//TODO show Michal



        return super.visitStatement(ctx);
    }
}
