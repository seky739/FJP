import expSources.ExpLexer;
import expSources.ExpParser;
import generator.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import types.Program;
import visitors.ProgramVisitor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Example {

    public static void main(String[] args) throws IOException {

        if(args.length == 1){
            final String fileName = args[0];

            String content = FileLoader.getInstance().readFile(fileName);

            InputStream stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            ExpLexer lexer = new ExpLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
            ExpParser parser = new ExpParser(new CommonTokenStream(lexer));

            ProgramVisitor programVisitor = new ProgramVisitor();
            Program program = programVisitor.visitProgram(parser.program());


            // generate code

            CodeGenerator generator = new CodeGenerator(program);
            try {
                generator.generate();
            } catch (CompilerException e) {
                e.printStackTrace();
            }


            FileGenerator.getInstance().write(fileName, PL0InstructionList.getInstance(), SymbolTable.getInstance());

        }else {
            //TODO print help
            print("Chybny pocet parametru");
            print("Spustit pomoci prikaz: java -jar aplikace.jar vstup.txt");
        }
    }

    public static void print(String message){
        System.out.println(message);
    }
}
