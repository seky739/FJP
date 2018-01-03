package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Statement;
import types.TernaryAssignment;

public class StatementVisitor extends ExpBaseVisitor<Statement> {

    @Override
    public Statement visitStatement(ExpParser.StatementContext ctx) {
        //System.out.println(ctx.getText());
        Statement statement = null;

        // very long IFs
        if(ctx.assignment()!=null){
            AssignmentVisitor assignmentVisitor=new AssignmentVisitor();
            statement = assignmentVisitor.visitAssignment(ctx.assignment());
        }else if(ctx.ifCondition() != null){
            IfConditionVisitor conditionVisitor=new IfConditionVisitor();
            statement = conditionVisitor.visitIfCondition(ctx.ifCondition());
        }
        else if(ctx.callStatement()!=null){
            CallVisitor callVisitor=new CallVisitor();
            statement = callVisitor.visitCallStatement(ctx.callStatement());
        }
        else if(ctx.whileStatement()!=null){
            WhileVisitor whileVisitor=new WhileVisitor();
            statement = whileVisitor.visitWhileStatement(ctx.whileStatement());
        }
        else if(ctx.repeatStatement()!=null){
            RepeatVisitor repeatVisitor=new RepeatVisitor();
            statement = repeatVisitor.visitRepeatStatement(ctx.repeatStatement());
        }
        else if(ctx.doWhileStatement()!=null){
            DoWhileVisitor doWhileVisitor=new DoWhileVisitor();
            statement = doWhileVisitor.visitDoWhileStatement(ctx.doWhileStatement());
        }
        else if(ctx.forStatement()!=null){
            ForVisitor forVisitor=new ForVisitor();
            statement = forVisitor.visitForStatement(ctx.forStatement());
        }
        else if(ctx.switchStatement()!=null){
            SwitchVisitor switchVisitor=new SwitchVisitor();
            statement = switchVisitor.visitSwitchStatement(ctx.switchStatement());
        }else if (ctx.unaryOperation() != null){
            UnaryVisitor unaryVisitor = new UnaryVisitor();
            statement = unaryVisitor.visitUnaryOperation(ctx.unaryOperation());
        }
        else if(ctx.ternaryAssignment() !=null){
            TernaryVisitor visitor = new TernaryVisitor();
            statement = visitor.visitTernaryAssignment(ctx.ternaryAssignment());
        }
        else if(ctx.parallelAssignment()!=null){
            ParallelAssignmentVisitor visitor = new ParallelAssignmentVisitor();
            statement = visitor.visitParallelAssignment(ctx.parallelAssignment());
        }
        else if(ctx.retrn()!=null){
            ReturnVisitor returnVisitor=new ReturnVisitor();
            returnVisitor.visitRetrn(ctx.retrn());
        }

        return statement;
    }
}
