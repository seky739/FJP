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
        final int LEVEL = 1;
        TableSymbol result = new TableSymbol(method, this.instructionCounter, LEVEL);
        int lastTableSize = SymbolTable.getInstance().getSize();
        generateParameters(method);
        this.stackTop += addr + (SymbolTable.getInstance().getSize() - lastTableSize);

        // local variableDefs
        generateVariableDefs(method.localVars, this.stackTop, LEVEL);

        // statements
        for (Statement s :
                method.statements) {
            generateStatement(s);
        }

        // remove them from table
        SymbolTable.getInstance().removeMultipleSymbols(method.localVars, LEVEL);
        SymbolTable.getInstance().removeMultipleParameters(method.parameters, LEVEL);

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
                    //TODO error - same indentifier for vars and parameters
                    return;
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
        int value = 0;
        if(statement instanceof Expression){
            value = generateExpression((Expression) statement);
        }else if(statement instanceof Call){
            generateCall((Call) statement);
        }else {
            //TODO error
        }
        // now the value is in the top of stack -> store it
        // first var
        TableSymbol firstSymbol = SymbolTable.getInstance().getSymbolFromTable(assignment.varNames.get(0), true);
        generateInstruction(PL0InstructionType.STO, 0, firstSymbol.getAddr());

        // other vars
        for (int i = 1; i < assignment.varNames.size(); i++) {
            // add value to top
            generateInstruction(PL0InstructionType.LIT, 0, value);
            TableSymbol varSymbol = SymbolTable.getInstance().getSymbolFromTable(assignment.varNames.get(i), true);
            if(varSymbol==null){
                //TODO error - undefined variable
            }
            generateInstruction(PL0InstructionType.STO, 0, varSymbol.getAddr());
        }
    }

    private void generateParalelAssignment(ParalelAssignment assignment){
        // only constants
        //if(assignment.varNames.size() == assignment.)
    }
    private void generateCondition(Condition condition){}
    private void generateIf(IfCondition condition){}
    private void generateWhile(Cycle cycle){}
    private void generateDoWhile(Cycle cycle){}
    private void generateReturn(Return ret){}
    private void generateSwitch(Switch sw){}
    private void generateCall(Call call){

        TableSymbol methodSymbol = SymbolTable.getInstance().getSymbolFromTable(call.name, false);
        List<String> parameters = call.parameters;

        for (String parameter : parameters) {
            if(isValue(parameter)){
                int value = 0;
                if(parameter.chars().allMatch( Character::isDigit)){
                    value = Integer.parseInt(parameter);
                }else if(parameter.equals("true")){
                    value = 1;
                }
                generateInstruction(PL0InstructionType.LIT, 0, value);
            }else{
                TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(parameter, true);
                generateInstruction(PL0InstructionType.LOD, 0, symbol.getAddr());
            }
        }

        generateInstruction(PL0InstructionType.CAL, 0, methodSymbol.getAddr());
    }
    private int generateExpression(Expression expression){
        int value = 0;
        //TODO
        generateInstruction(PL0InstructionType.LIT, 0, value);
        return value;
    }


    private void deleteLocalVariable(){

    }


    public static boolean isValue(String value){
        boolean result = false;
        if(value.chars().allMatch( Character::isDigit ) ||
                value.equals("true") || value.equals("false")){
            result = true;
        }
        return result;
    }

}

