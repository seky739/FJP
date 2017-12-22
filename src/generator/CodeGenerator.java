package generator;

import types.*;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static final int STACK_OFFSET = 3;
    private static final int STACK_BASE = 1;
    private Program root;
    private int instructionCounter;
    private int stackTop;

    private List<PL0Instruction> instructions;


    public CodeGenerator(Program root){
        this.root = root;
        this.instructionCounter = 0;

        this.instructions = new ArrayList<>();

        this.stackTop = 0;
    }


    public List<String> generateAllInstructions(){
        List<String> result = new ArrayList<>();
        int actualLevel = 0;

        Block block = root.block;

        List<VariableDef> variableDefs = block.variableDefs;
        List<Method> methods = block.methods;

        // register for base, ...
        generateInstruction(PL0InstructionType.INT, 0, STACK_OFFSET);

        // 1) variableDefs
        generateVariableDefs(variableDefs, this.stackTop, actualLevel);


        //2) finding Main function in the last (always last)
        Method mainMethod = methods.get(methods.size()-1);
        methods.remove(methods.size()-1); // remove it as it is not a usual method

        // need to change later
        PL0Instruction mainMethodInstr = generateInstruction(PL0InstructionType.JMP, 0, 0);

        int tmpStackTop = this.stackTop;

        // 3) other methods
        for (Method m :
                methods) {
            TableSymbol tmpSymbol = generateMethod(m, STACK_OFFSET);
            SymbolTable.getInstance().addSymbol(tmpSymbol);
        }

        // change main jump value and process main method
        mainMethodInstr.setParameter2(instructionCounter);
        TableSymbol mainMethodSymbol = generateMethod(mainMethod, tmpStackTop);
        SymbolTable.getInstance().addSymbol(mainMethodSymbol);


        //TODO output
        write();


        return result;
    }

    private void write(){
        for (PL0Instruction instruction :
                instructions) {
            System.out.println(instruction);
        }
    }

    private PL0Instruction generateInstruction(PL0InstructionType instruction, int parameter1, int parameter2){
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


    private void generateVariableDefs(List<VariableDef> variableDefs, int startAddress, int level) {
        generateInstruction(PL0InstructionType.INT, 0, variableDefs.size());
        for (VariableDef var :
                variableDefs) {
            TableSymbol symbol = new TableSymbol(var, startAddress, level);
            if(!SymbolTable.getInstance().addSymbol(symbol)){
                //TODO symbol name already existed
                break;
            }
            generateInstruction(PL0InstructionType.LIT, 0, var.value);
            generateInstruction(PL0InstructionType.STO, 0, symbol.getAddr());
            startAddress++;
        }
    }

    private void generateVariableDef(VariableDef variableDef, int startAddress, int level){
        TableSymbol newSymbol = new TableSymbol(variableDef, startAddress, level);
        if(SymbolTable.getInstance().addSymbol(newSymbol)){
            generateInstruction(PL0InstructionType.INT, 0, 1); // increase stack
            generateInstruction(PL0InstructionType.LIT, 0, variableDef.value); // add value to stack top
            generateInstruction(PL0InstructionType.STO, 0, newSymbol.getAddr()); // now add value from stack to address
        }
    }

    private TableSymbol generateMethod(Method method, int addr){
        final int level = 1;
        TableSymbol result = new TableSymbol(method, this.instructionCounter, level);
        int lastTableSize = SymbolTable.getInstance().getSize();
        generateParameters(method);
        this.stackTop += addr + (SymbolTable.getInstance().getSize() - lastTableSize);

        // local variableDefs
        generateVariableDefs(method.localVars, this.stackTop, level);

        // statements
        for (Statement s :
                method.statements) {
            generateStatement(s);
        }

        // remove them from table
        SymbolTable.getInstance().removeMultipleSymbols(method.localVars, level);

        // 'return' if missing
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
            SymbolTable.getInstance().addSymbol(newSymbol);
            generateInstruction(PL0InstructionType.LOD, 1, actualAddr);
            actualAddr++;
        }
    }

    private void generateAssignment(Assignment assignment){
        Statement statement = assignment.expression;


        if(statement instanceof Expression){
            generateExpression((Expression) statement);
        }else if(statement instanceof Call){
            generateCall((Call) statement);
        }else {
            //TODO error
        }
        // now the value is in the top of stack -> store it

        for (String var :
                assignment.varNames) {
            TableSymbol varSymbol = SymbolTable.getInstance().getSymbolFromTable(var, true);
            if(varSymbol!=null){

            }
        }







    }

    private void generateCall(Call call){}
    private void generateParalelAssignment(ParalelAssignment assignment){}
    private void generateCondition(Condition condition){}
    private void generateIf(IfCondition condition){}
    private void generateWhile(Cycle cycle){}
    private void generateDoWhile(Cycle cycle){}
    private void generateReturn(Return ret){}
    private void generateSwitch(Switch sw){}
    private void generateExpression(Expression expression){}


    private void deleteLocalVariable(){

    }


}

