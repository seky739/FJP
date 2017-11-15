package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Block;
import types.Variable;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BlockVisitor extends ExpBaseVisitor<Block> {

    @Override
    public Block visitBlock(ExpParser.BlockContext ctx) {
        System.out.println("Visit block");
        Block block = new Block();
        VariableVisitor variableVisitor = new VariableVisitor();
        List<Variable> variables = ctx.variable().
                                    stream().
                                    map(method->method.accept(variableVisitor)).collect(toList());


        return block;
    }
}
