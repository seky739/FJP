package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Cycle;
import types.enums.StatementType;

import java.util.stream.Collectors;

public class WhileVisitor extends ExpBaseVisitor<Cycle> {
    @Override
    public Cycle visitWhileStatement(ExpParser.WhileStatementContext ctx) {
        Cycle cycle = new Cycle();
        cycle.type = StatementType.WHILE_DO;

        cycle.condition = new ConditionVisitor().visitCondition(ctx.condition());
        cycle.statements = ctx.statement().stream().map(method->method.accept(new StatementVisitor())).collect(Collectors.toList());

        return cycle;
    }
}
