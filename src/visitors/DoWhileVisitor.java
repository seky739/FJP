package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;
import types.enums.StatementType;

import static java.util.stream.Collectors.toList;

public class DoWhileVisitor extends ExpBaseVisitor<Cycle> {
    @Override
    public Cycle visitDoWhileStatement(ExpParser.DoWhileStatementContext ctx) {
        System.out.println("Visit Do While");

        Cycle doWhile =new Cycle();
        StatementVisitor statementVisitor=new StatementVisitor();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        doWhile.statements = ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList());
        doWhile.condition = conditionVisitor.visitCondition(ctx.condition());
        doWhile.type = StatementType.DO_WHILE;

        return doWhile;
    }
}
