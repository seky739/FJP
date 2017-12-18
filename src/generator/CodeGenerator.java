package generator;

import types.*;

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
        Method mainMethod = methods.get(methods.size()-1);

        PL0Instruction mainMethodInstr = generateInstruction(PL0InstructionType.JMP, 0, 1);

        int tmpStackTop = this.stackTop;


        for (Method m :
                methods) {
            TableSymbol tmpSymbol = generateMethod(m, STACK_OFFSET);
        }




        return result;
    }

    public PL0Instruction generateInstruction(PL0InstructionType instruction, int parameter1, int parameter2){
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

        // adding to table of symbols and increasing address
        for (Variable var : variables) {
            tableOfSymbols.add(new TableSymbol(var, actualAddr++, level));
        }
        // skip increased addresses
        generateInstruction(PL0InstructionType.INT, 0, actualAddr - startAddress);

        for (Variable var : variables) {
            generateInstruction(PL0InstructionType.LIT, 0, var.value);
            TableSymbol s = TableSymbol.getSymbolFromTable(tableOfSymbols, var.name, true);
            generateInstruction(PL0InstructionType.STO, 0, s.getAddr());
        }
    }

    private TableSymbol generateMethod(Method method, int addr){
        final int level = 1;
        TableSymbol result = new TableSymbol(method, this.instructionCounter, level);
        int lastTableSize = tableOfSymbols.size();
        generateParameters(method);
        this.stackTop += tableOfSymbols.size() - lastTableSize;

        // local variables
        generateVariables(method.localVars, this.stackTop, level);

        // statements
        for (Statement s :
                method.statements) {
            generateStatement(s);
        }

        // remove them from table
        deleteLocalVariables(method.localVars, level);

        // return if missing
        if (!method.statements.isEmpty()) {
            Statement statement = method.statements.get(method.statements.size() - 1);
            if (!(statement instanceof Return)) {
                generateInstruction(PL0InstructionType.RET, 0, 0);
            }
        }

        return result;
    }

    private void generateStatement(Statement statement){

    }

    private void generateParameters(Method method)  {
        List<Parameter> params = method.parameters;

        if (params.isEmpty()) {
            return;
        }

        //TODO check this... maybe better returning error when this happen
        for (int i = 0; i < params.size(); i++) {
            for (int j = 0; j < method.localVars.size(); j++) {
                if (params.get(i).name.equals(method.localVars.get(j).name)) {
                    method.localVars.remove(j);
                }
            }
        }

        int actualAddr = this.stackTop + 1;
        generateInstruction(PL0InstructionType.INT, 0, STACK_OFFSET);

        // add params to table
        for (Parameter p : params) {
            TableSymbol newSymbol = new TableSymbol(p, actualAddr, 1);
            tableOfSymbols.add(newSymbol);
            generateInstruction(PL0InstructionType.LOD, 1, actualAddr);
            actualAddr++;
        }
    }

    private void deleteLocalVariables(List<Variable> variables, int level){
        int it = 0;
        while(it < tableOfSymbols.size()){
            TableSymbol s = tableOfSymbols.get(it++);
            if (s.isVariable() && s.getLevel() == level) {
                for (Variable v : variables) {
                    if (s.getIdentificator().name.equals(v.name)) {
                        tableOfSymbols.remove(s);
                    }
                }
            }
        }
    }
}

