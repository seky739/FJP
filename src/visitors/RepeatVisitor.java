package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;

import static java.util.stream.Collectors.toList;

public class RepeatVisitor extends ExpBaseVisitor <Cycle> {

    @Override
    public Cycle visitRepeatStatement(ExpParser.RepeatStatementContext ctx) {
        System.out.println("Visit Repeat until");
        StatementVisitor statementVisitor=new StatementVisitor();
        ConditionVisitor conditionVisitor=new ConditionVisitor();
        Cycle repeat=new Cycle();

        repeat.statements.addAll(ctx.statement().stream().map(statementContext -> statementContext.accept(statementVisitor)).collect(toList()));
        repeat.condition=conditionVisitor.visitCondition(ctx.condition());

        return repeat;
    }
}
