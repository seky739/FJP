package generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    private static final String PREFIX = "output_";

    private static FileGenerator instance;

    private FileGenerator(){}

    public static FileGenerator getInstance() {
        if(instance == null){
            instance = new FileGenerator();
        }
        return instance;
    }

    public void write(String name, PL0InstructionList instructionList, SymbolTable table){
        try {
            FileWriter fw = new FileWriter(PREFIX + name);
            BufferedWriter bw = new BufferedWriter(fw);

            for (PL0Instruction in :
                    instructionList.getInstructionList()) {
                bw.write(in.toString());
                bw.newLine();
            }

            /*for (TableSymbol symbol :
                    table.getTableOfSymbols()) {
                bw.write(symbol.toString());
                bw.newLine();
            }*/

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
