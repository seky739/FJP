package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Statement;

public class StatementVisitor extends ExpBaseVisitor<Statement> {

    @Override
    public Statement visitStatement(ExpParser.StatementContext ctx) {
        System.out.println("Visit statement");

        //System.out.println(ctx.getText());
        Statement statement=new Statement();

        // very long IFs
        if(ctx.assignment()!=null){
            AssignmentVisitor assignmentVisitor=new AssignmentVisitor();
            assignmentVisitor.visitAssignment(ctx.assignment());
        //}else if (ctx.statement() != null){
          //  StatementVisitor statementVisitor=new StatementVisitor();
           // statementVisitor.visitStatement(ctx.statement());
        }else if(ctx.ifCondition() != null){
            IfConditionVisitor conditionVisitor=new IfConditionVisitor();
            conditionVisitor.visitIfCondition(ctx.ifCondition());
        }
        else if(ctx.callStatement()!=null){
            CallVisitor callVisitor=new CallVisitor();
            callVisitor.visitCallStatement(ctx.callStatement());
        }
        else if(ctx.whileStatement()!=null){
            WhileVisitor whileVisitor=new WhileVisitor();
            whileVisitor.visitWhileStatement(ctx.whileStatement());
        }
        else if(ctx.repeatStatement()!=null){
            RepeatVisitor repeatVisitor=new RepeatVisitor();
            repeatVisitor.visitRepeatStatement(ctx.repeatStatement());
        }
        else if(ctx.doWhileStatement()!=null){
            DoWhileVisitor doWhileVisitor=new DoWhileVisitor();
            doWhileVisitor.visitDoWhileStatement(ctx.doWhileStatement());
        }
        else if(ctx.forStatement()!=null){
            ForVisitor forVisitor=new ForVisitor();
            forVisitor.visitForStatement(ctx.forStatement());
        }
        else if(ctx.switchStatement()!=null){
            SwitchVisitor switchVisitor=new SwitchVisitor();
            switchVisitor.visitSwitchStatement(ctx.switchStatement());
        }
        else if(ctx.ternaryOperation()!=null){

        }
        else if(ctx.paralelAssignment()!=null){

        }
        else if(ctx.retrn()!=null){
            ReturnVisitor returnVisitor=new ReturnVisitor();
            returnVisitor.visitRetrn(ctx.retrn());
        }
        else if(ctx.unaryOperation()!=null){

        }

        return statement;
    }
}
