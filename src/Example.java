import expSources.ExpLexer;
import expSources.ExpParser;
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
        //TODO remove this
        args = new String[]{"test2.txt"};


        if(args.length == 1){
            final String fileName = args[0];

            String content = FileLoader.getInstance().readFile(fileName);

            InputStream stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            ExpLexer lexer = new ExpLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
            ExpParser parser = new ExpParser(new CommonTokenStream(lexer));

            ProgramVisitor programVisitor = new ProgramVisitor();
            Program program = programVisitor.visit(parser.program());

            //TODO check errors

        }else {
            //TODO print help
            print("Chybny pocet parametru");
        }
    }

    public static void print(String message){
        System.out.println(message);
    }
}