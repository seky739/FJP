package visitors;

import expSources.ExpBaseVisitor;
import expSources.ExpParser;
import types.Method;

public class MethodVisitor extends ExpBaseVisitor<Method> {


    @Override
    public Method visitMethod(ExpParser.MethodContext ctx) {
        System.out.println("Visit method");


        return super.visitMethod(ctx);
    }
}
