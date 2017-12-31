package generator;

import types.*;
import types.enums.ValueOperations;

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


    public List<String> generateAllInstructions() throws CompilerException{
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
        System.out.println("----------");
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
        if(variableDefs.size() > 0){
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
    }

    private void generateVariableDef(VariableDef variableDef, int startAddress, int level){
        TableSymbol newSymbol = new TableSymbol(variableDef, startAddress, level);
        if(SymbolTable.getInstance().addSymbol(newSymbol)){
            generateInstruction(PL0InstructionType.INT, 0, 1); // increase stack
            generateInstruction(PL0InstructionType.LIT, 0, variableDef.value); // add value to stack top
            generateInstruction(PL0InstructionType.STO, 0, newSymbol.getAddr()); // now add value from stack to address
        }
    }

    private TableSymbol generateMethod(Method method, int addr) throws CompilerException{
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

    private void generateStatement(Statement statement) throws CompilerException{
        switch (statement.type){
            case ASSIGNMENT:
                generateAssignment((Assignment) statement);
                break;
            case PARALEL_ASSIGNMENT:
                generateParalelAssignment((ParalelAssignment)statement);
                break;
            case UNARY:
                generateUnaryOperator((UnaryOperation) statement);
                break;
            case IF:
                generateIf((IfCondition)statement);
                break;
            case FOR:
                generateFor((Cycle) statement);
                break;
            case CALL:
                generateCall((Call) statement);
                break;
            case SWITCH:
                generateSwitch((Switch)statement);
                break;
            case REPEAT_UNTIL:
                generateRepeatUntil((Cycle) statement);
                break;
            case DO_WHILE:
                generateDoWhile((Cycle) statement);
                break;
            case WHILE_DO:
                generateWhile((Cycle) statement);
                break;
            case RETURN:
                generateReturn((Return) statement);
                break;
            case TERNARY:
                generateTernaryAssignment((TernaryAssignment) statement);
                break;
            case OTHER:
            default:
                //TODO
                System.out.println("something different");
        }
    }

    private void generateTernaryAssignment(TernaryAssignment assignment) throws CompilerException{
        TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(assignment.variableDef.name, true);
        if(symbol != null){
            generateExpression(assignment.condition.leftPart);
            generateExpression(assignment.condition.rightPart);
            generateInstruction(PL0InstructionType.OPR, 0, assignment.condition.operation.getValue());

            PL0Instruction elseJump = generateInstruction(PL0InstructionType.JMC, 0, 0);
            generateExpression(assignment.trueExpression);
            PL0Instruction jumpOut = generateInstruction(PL0InstructionType.JMP, 0, 0);
            elseJump.setParameter2(instructionCounter);
            generateExpression(assignment.falseExpression);
            jumpOut.setParameter2(instructionCounter);
            generateInstruction(PL0InstructionType.STO, 0, symbol.getAddr());
        }else {
            throw new CompilerException("Variable "+assignment.variableDef.name+" undefined");
        }
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

    // DONE
    private void generateAssignment(Assignment assignment) throws CompilerException {
        Statement statement = assignment.expression;
        int value = 0;
        if(statement instanceof Expression){
            generateExpression((Expression) statement);
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
    private void generateIf(IfCondition ifCondition) throws CompilerException {
        Expression leftExp = ifCondition.condition.leftPart;
        Expression rightExp = ifCondition.condition.rightPart;

        generateExpression(leftExp);
        generateExpression(rightExp);

        int operator = ifCondition.condition.operation.getValue();
        if(operator != 0){
            generateInstruction(PL0InstructionType.OPR, 0, operator);
        }else {
            throw new CompilerException("Unknown condition operator");
        }

        PL0Instruction jumpOverElse = null;
        PL0Instruction jumpToElse = generateInstruction(PL0InstructionType.JMC, 0, 0);

        // generate statement inside if block
        for (Statement statement :
                ifCondition.statements) {
            generateStatement(statement);
        }
        // now jump over else if exist
        if(ifCondition.elseStatements.size()>0){
            jumpOverElse = generateInstruction(PL0InstructionType.JMP, 0, 0);
        }
        jumpToElse.setParameter2(instructionCounter);
        // generate statement inside else block
        for (Statement statement :
                ifCondition.elseStatements) {
            generateStatement(statement);
        }
        jumpOverElse.setParameter2(instructionCounter);

    }
    private void generateFor(Cycle cycle) throws CompilerException{
        int startingIndex = instructionCounter;
        // test condition
        generateExpression(cycle.condition.leftPart);
        generateExpression(cycle.condition.rightPart);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        PL0Instruction jumpOut = generateInstruction(PL0InstructionType.JMC, 0, 0);

        // run statements
        for (Statement statement :
                cycle.statements) {
            generateStatement(statement);
        }

        // increment
        generateUnaryOperator(cycle.increment);

        // jump back
        generateInstruction(PL0InstructionType.JMP, 0, startingIndex);
        jumpOut.setParameter2(instructionCounter);
        
    }
    private void generateUnaryOperator(UnaryOperation operation){
        TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(operation.variable.name, true);
        generateInstruction(PL0InstructionType.LOD, 0, symbol.getAddr());
        generateInstruction(PL0InstructionType.LIT, 0, 1);
        int operator = operation.increment ? ValueOperations.ADDITION.getValue() : ValueOperations.SUBSTRACTION.getValue();
        generateInstruction(PL0InstructionType.OPR, 0, operator);
        generateInstruction(PL0InstructionType.STO, 0, symbol.getAddr());
    }

    private void generateWhile(Cycle cycle) throws CompilerException {
        int startingIndex = instructionCounter;
        generateExpression(cycle.condition.leftPart);
        generateExpression(cycle.condition.rightPart);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        PL0Instruction jumpInstruction = generateInstruction(PL0InstructionType.JMC, 0, 0);
        for (Statement statement:
             cycle.statements) {
            generateStatement(statement);
        }
        generateInstruction(PL0InstructionType.JMP, 0, startingIndex);
        jumpInstruction.setParameter2(instructionCounter);
    }
    private void generateDoWhile(Cycle cycle) throws CompilerException{
        int startingIndex = instructionCounter;
        for (Statement statement:
                cycle.statements) {
            generateStatement(statement);
        }
        generateExpression(cycle.condition.leftPart);
        generateExpression(cycle.condition.rightPart);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        PL0Instruction jumpInstruction = generateInstruction(PL0InstructionType.JMC, 0, 0);
        generateInstruction(PL0InstructionType.JMP, 0, startingIndex);
        jumpInstruction.setParameter2(instructionCounter);
    }
    private void generateRepeatUntil(Cycle cycle) throws CompilerException{
        int startingIndex = instructionCounter;
        for (Statement statement:
                cycle.statements) {
            generateStatement(statement);
        }
        generateExpression(cycle.condition.leftPart);
        generateExpression(cycle.condition.rightPart);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        generateInstruction(PL0InstructionType.JMC, 0, startingIndex);
    }
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
    private void generateExpression(Expression expression) throws CompilerException{
        List<Term> terms = expression.terms;
        if(terms.size() > 0){
            Term firstTerm = terms.get(0);
            // push 1 term to stack
            generateTerm(firstTerm);

            for (int i = 0; i < expression.operations.size(); i++) {
                Term term = terms.get(i+1);
                ValueOperations oper = expression.operations.get(i);

                generateTerm(term);
                if(oper != ValueOperations.UNKNOWN){
                    generateInstruction(PL0InstructionType.OPR, 0, oper.getValue());
                }else {
                    throw new CompilerException("Unknown operator");
                }
            }
        }
    }

    private void generateTerm(Term term) throws CompilerException{
        List<Factor> factors = term.factors;
        if(factors.size()>0){
            Factor firstFactor = factors.get(0);
            generateFactor(firstFactor);
            for (int i = 0; i < term.operations.size(); i++) {
                Factor factor = factors.get(i+1);
                generateFactor(factor);
                ValueOperations oper = term.operations.get(i);
                generateInstruction(PL0InstructionType.OPR, 0, oper.getValue()); //TODO bool operations
            }
        }
    }

    private void generateFactor(Factor factor) throws CompilerException{

        switch (factor.factorType){
            case CALL:
                generateCall(factor.call);
                break;
            case EXPRESSION:
                generateExpression(factor.expression);
                break;
            case VARIABLE:
                TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(factor.vardef.name, true);
                generateInstruction(PL0InstructionType.LOD, 0, symbol.getAddr());
                break;
            case NUMBER:
            case BOOLEAN:
                generateInstruction(PL0InstructionType.LIT, 0, factor.vardef.value);
                break;
        }
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

