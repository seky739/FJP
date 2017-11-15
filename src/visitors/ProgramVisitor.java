package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Program;

public class ProgramVisitor extends ExpBaseVisitor<Program> {

    // pokazde si nechame vegenerovat 1 metodu pro prochazeni stromu
    // tedy visitNAZEV_BLOKU
    // generovani = bud to opisovat z ExpVisitor, nebo v IntelliJ: CTRL+O a pak si vybereme prislusnou metodu


    @Override
    public Program visitProgram(ExpParser.ProgramContext ctx) {


        System.out.println("Visit program");
        BlockVisitor blockVisitor = new BlockVisitor();
        //ctx.block()
        //Block block = ctx.block().stre

        return super.visitProgram(ctx);
    }
}
