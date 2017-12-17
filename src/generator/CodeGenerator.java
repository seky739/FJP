package generator;

import types.Block;
import types.Method;
import types.Program;
import types.Variable;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static final int STACK_OFFSET = 3;
    private Program root;
    private int instructionCounter;
    private int stackBase, stackTop;

    private List<PL0Instruction> instructions;
    private List<TableSymbol> tableOfSymbols;


    public CodeGenerator(Program root){
        this.root = root;
        this.instructionCounter = 0;

        this.instructions = new ArrayList<>();
        this.tableOfSymbols = new ArrayList<>();

        this.stackBase = 1;
        this.stackTop = 0;
    }


    public List<String> generateInstructions(){
        List<String> result = new ArrayList<>();
        int actualLevel = 0;

        Block block = root.block;

        List<Variable> variables = block.variables;
        List<Method> methods = block.methods;

        // variables
        generateVariables(variables, this.stackTop, actualLevel);

        // finding Main function in the last




        return result;
    }

    public PL0Instruction generateMachineInstruction(PL0InstructionType instruction, int parameter1, int parameter2){
        switch (instruction){
            case INT:
                this.stackTop += parameter2;
                break;
            case LIT: case LOD:
                this.stackTop++;
                break;
            case STO: case OPR: case JMC:
                this.stackTop--;
                break;
        }
        PL0Instruction newInstruction = new PL0Instruction(instructionCounter, instruction, parameter1, parameter2);
        instructions.add(newInstruction);
        instructionCounter++;

        return newInstruction;
    }


    private void generateVariables(List<Variable> variables, int startAddress, int level) {
        int actualAddr = startAddress;
        // Global variables
        if (this.stackTop == 0) {
            actualAddr += STACK_OFFSET;
        }

        // adding to table of symbols
        for (Variable var : variables) {
            tableOfSymbols.add(new TableSymbol(var, actualAddr++, level));
        }

        generateMachineInstruction(PL0InstructionType.INT, 0, actualAddr - startAddress);

        for (Variable var : variables) {
            generateMachineInstruction(PL0InstructionType.LIT, 0, var.value);
            TableSymbol s = TableSymbol.getSymbolFromTable(tableOfSymbols, var.name, true);
            generateMachineInstruction(PL0InstructionType.STO, 0, s.getAddr());
        }
    }
}
