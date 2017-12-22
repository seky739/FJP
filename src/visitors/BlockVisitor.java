package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Block;
import types.Method;
import types.VariableDef;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BlockVisitor extends ExpBaseVisitor<Block> {

    @Override
    public Block visitBlock(ExpParser.BlockContext ctx) {
        System.out.println("Visit block");
        Block block = new Block();
        VariableVisitor variableVisitor = new VariableVisitor();
        List<VariableDef> variableDefs = ctx.variableDef().
                                    stream().
                                    map(method->method.accept(variableVisitor)).collect(toList());
        MethodVisitor methodVisitor = new MethodVisitor();
        List<Method> methods = ctx.method().stream().map(methodContext -> methodContext.accept(methodVisitor)).collect(toList());
        block.variableDefs = variableDefs;
        block.methods = methods;


        return block;
    }
}
