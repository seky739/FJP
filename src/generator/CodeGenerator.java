package generator;

import types.*;
import types.enums.ValueOperations;
import types.enums.VarType;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static final int STACK_OFFSET = 3;
    private static final int STACK_BASE = 1;
    private static final int MAX_PARAM_COUNT = 3;
    private Program root;
    private int instructionCounter;
    private int stackTop;
    private int returnAddress;
    private int paramAddress;


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

        // 0) temp register for method returned value + starting address for parameters
        returnAddress = stackTop;
        generateInstruction(PL0InstructionType.LIT, 0, 0);
        paramAddress = stackTop;
        for (int i = 0; i < MAX_PARAM_COUNT; i++) {
            generateInstruction(PL0InstructionType.LIT, 0, 0);
        }


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
            TableSymbol tmpSymbol = generateMethod(m, STACK_OFFSET, false);
            SymbolTable.getInstance().addSymbol(tmpSymbol);
        }

        // change main jump value and process main method
        mainMethodInstr.setParameter2(instructionCounter);
        TableSymbol mainMethodSymbol = generateMethod(mainMethod, tmpStackTop, true);
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


    private void generateVariableDefs(List<VariableDef> variableDefs, int startAddress, int level) throws CompilerException{
        if(variableDefs.size() > 0){
            generateInstruction(PL0InstructionType.INT, 0, variableDefs.size());
            for (VariableDef var :
                    variableDefs) {
                TableSymbol symbol = new TableSymbol(var, startAddress, level);
                if(!SymbolTable.getInstance().addSymbol(symbol)){
                    throw new CompilerException(CompilerException.ERR_DUPLICATED_VARIABLE);
                }
                int value = var.value;
                // if typ is boolean then non binary values will have to change to 0 or 1
                if(var.type == VarType.BOOL){
                    value = value == 0 ? 0 : 1;
                }
                generateInstruction(PL0InstructionType.LIT, 0, value);
                generateInstruction(PL0InstructionType.STO, level, symbol.getAddr());
                startAddress++;
            }
        }
    }

    private TableSymbol generateMethod(Method method, int addr, boolean isMainMethod) throws CompilerException{
        int level = isMainMethod ? 0 : 1;
        TableSymbol result = new TableSymbol(method, this.instructionCounter, level);

        if(result != null){
            if(!isMainMethod){
                List<Parameter> params = method.parameters;
                // add params to table
                generateInstruction(PL0InstructionType.INT, 0, STACK_OFFSET);
                int tempAddress = paramAddress;

                for (Parameter p : params) {
                    TableSymbol newSymbol = new TableSymbol(p, tempAddress++, 1); //TODO check
                    SymbolTable.getInstance().addSymbol(newSymbol);
                    generateInstruction(PL0InstructionType.LOD, 1, newSymbol.getAddr());
                }
            }
            stackTop = addr + result.getParamCount();


            // local variableDefs
            generateVariableDefs(method.localVars, this.stackTop, level);

            // statements
            for (Statement s :
                    method.statements) {
                generateStatement(s, level);
            }

            generateReturn(method.rturn, method.returnType);
            // remove them from table
            SymbolTable.getInstance().removeMultipleSymbols(method.localVars, level);
            SymbolTable.getInstance().removeMultipleParameters(method.parameters, level);
            generateInstruction(PL0InstructionType.RET, 0, 0);


        }
        return result;
    }

    private void generateStatement(Statement statement, int level) throws CompilerException{
        switch (statement.type){
            case ASSIGNMENT:
                generateAssignment((Assignment) statement, level);
                break;
            case PARALEL_ASSIGNMENT:
                generateParallelAssignment((ParallelAssignment)statement, level);
                break;
            case UNARY:
                generateUnaryOperator((UnaryOperation) statement, level);
                break;
            case IF:
                generateIf((IfCondition)statement, level);
                break;
            case FOR:
                generateFor((Cycle) statement, level);
                break;
            case CALL:
                generateCall((Call) statement, false, level);
                break;
            case SWITCH:
                generateSwitch((Switch)statement, level);
                break;
            case REPEAT_UNTIL:
                generateRepeatUntil((Cycle) statement, level);
                break;
            case DO_WHILE:
                generateDoWhile((Cycle) statement, level);
                break;
            case WHILE_DO:
                generateWhile((Cycle) statement, level);
                break;
            case TERNARY:
                generateTernaryAssignment((TernaryAssignment) statement, level);
                break;
            case OTHER:
            default:
                //TODO
                System.out.println("something different");
        }
    }

    private void generateTernaryAssignment(TernaryAssignment assignment, int level) throws CompilerException{
        TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(assignment.variableDef.name, true);
        if(symbol != null || symbol.isConstant()){

            generateExpression(assignment.condition.leftPart, level);
            generateExpression(assignment.condition.rightPart, level);
            generateInstruction(PL0InstructionType.OPR, 0, assignment.condition.operation.getValue());

            PL0Instruction elseJump = generateInstruction(PL0InstructionType.JMC, 0, 0);
            generateExpression(assignment.trueExpression, level);
            PL0Instruction jumpOut = generateInstruction(PL0InstructionType.JMP, 0, 0);
            elseJump.setParameter2(instructionCounter);
            generateExpression(assignment.falseExpression, level);
            jumpOut.setParameter2(instructionCounter);
            generateInstruction(PL0InstructionType.STO, level, symbol.getAddr());
        }else {
            if(symbol == null){
                throw new CompilerException("Variable "+assignment.variableDef.name+" undefined");
            }else {
                throw new CompilerException("Constants are immutable");
            }
        }
    }

    private void generateCall(Call call, boolean withReturn, int level) throws CompilerException {
        TableSymbol methodSymbol = SymbolTable.getInstance().getSymbolFromTable(call.functionName, false);

        if(methodSymbol != null && call.parameters.size() == methodSymbol.getParamCount()){
            List<String> parameters = call.parameters;
            int tmpAddress = paramAddress;
            for (String parameter : parameters) {
                TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(parameter, true);
                generateInstruction(PL0InstructionType.LOD, level, symbol.getAddr());
                generateInstruction(PL0InstructionType.STO, level, tmpAddress++);
            }

            generateInstruction(PL0InstructionType.CAL, 0, methodSymbol.getAddr());
            if(withReturn){
                generateInstruction(PL0InstructionType.LOD, level, returnAddress);
            }

        }else{
            if(methodSymbol == null){
                throw new CompilerException(CompilerException.ERR_UNDEFINED_METHOD);
            }else {
                throw new CompilerException(CompilerException.ERR_WRONG_PARAMETER_NUMBER);
            }
        }
    }

    // DONE
    private void generateAssignment(Assignment assignment, int level) throws CompilerException {

        List<TableSymbol> symbolList = new ArrayList<>();
        for (String var :
                assignment.varNames) {
            TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(var, true);
            if(symbol == null || symbol.isConstant()){
                if(symbol == null){
                    throw new CompilerException(CompilerException.ERR_UNDEFINED_VARIABLE);
                }else {
                    throw new CompilerException(CompilerException.ERR_IMMUTABLE_CONSTANTS);
                }
            }
            symbolList.add(symbol);
        }

        Statement statement = assignment.expression;
        int value = 0;
        if(statement instanceof Expression){
            generateExpression((Expression) statement, level);
        }else if(statement instanceof Call){
            generateCall((Call) statement, true, level);
        }else {
            throw new CompilerException(CompilerException.ERR_UNKNOWN);
        }
        // now the value is in the top of stack -> store it
        // first var
        TableSymbol firstSymbol = SymbolTable.getInstance().getSymbolFromTable(assignment.varNames.get(0), true);
        generateInstruction(PL0InstructionType.STO, level, firstSymbol.getAddr());

        // other vars
        for (int i = 1; i < symbolList.size(); i++) {
            generateInstruction(PL0InstructionType.LIT, 0, value);
            generateInstruction(PL0InstructionType.STO, level, symbolList.get(i).getAddr());
        }
    }

    private void generateParallelAssignment(ParallelAssignment assignment, int level) throws CompilerException{
        // only constants
        if(assignment != null){
            for (int i=0; i< assignment.variables.size(); i++) {
                String var = assignment.variables.get(i);
                TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(var, true);
                if(symbol != null){
                    //TODO check type (boolean/number)
                    if(!symbol.isConstant()){
                        int value = assignment.values.get(i);
                        if(symbol.getType() == VarType.BOOL){
                            value = assignment.values.get(i) == 0 ? 0 : 1;
                        }
                        generateInstruction(PL0InstructionType.LIT, 0, value);
                        generateInstruction(PL0InstructionType.STO, level, symbol.getAddr());
                    }else {
                        throw new CompilerException("Constants are immutable");
                    }
                }else {
                    throw new CompilerException("Undefined variable: "+ var);
                }
            }
        }else {
            throw new CompilerException("Number of assignment variables and values do not match");
        }
    }
    private void generateIf(IfCondition ifCondition, int level) throws CompilerException {
        Expression leftExp = ifCondition.condition.leftPart;
        Expression rightExp = ifCondition.condition.rightPart;

        generateExpression(leftExp, level);
        generateExpression(rightExp, level);

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
            generateStatement(statement, level);
        }
        // now jump over else if exist
        if(ifCondition.elseStatements.size()>0){
            jumpOverElse = generateInstruction(PL0InstructionType.JMP, 0, 0);
        }
        jumpToElse.setParameter2(instructionCounter);
        // generate statement inside else block
        for (Statement statement :
                ifCondition.elseStatements) {
            generateStatement(statement, level);
        }
        jumpOverElse.setParameter2(instructionCounter);

    }
    private void generateFor(Cycle cycle, int level) throws CompilerException{
        int startingIndex = instructionCounter;
        // test condition
        generateExpression(cycle.condition.leftPart, level);
        generateExpression(cycle.condition.rightPart, level);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        PL0Instruction jumpOut = generateInstruction(PL0InstructionType.JMC, 0, 0);

        // run statements
        for (Statement statement :
                cycle.statements) {
            generateStatement(statement, level);
        }

        // increment
        generateUnaryOperator(cycle.increment, level);

        // jump back
        generateInstruction(PL0InstructionType.JMP, 0, startingIndex);
        jumpOut.setParameter2(instructionCounter);
        
    }
    private void generateUnaryOperator(UnaryOperation operation, int level){
        TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(operation.variable.name, true);
        generateInstruction(PL0InstructionType.LOD, level, symbol.getAddr());
        generateInstruction(PL0InstructionType.LIT, 0, 1);
        int operator = operation.increment ? ValueOperations.ADDITION.getValue() : ValueOperations.SUBSTRACTION.getValue();
        generateInstruction(PL0InstructionType.OPR, 0, operator);
        generateInstruction(PL0InstructionType.STO, level, symbol.getAddr());
    }

    private void generateWhile(Cycle cycle, int level) throws CompilerException {
        int startingIndex = instructionCounter;
        generateExpression(cycle.condition.leftPart, level);
        generateExpression(cycle.condition.rightPart, level);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        PL0Instruction jumpInstruction = generateInstruction(PL0InstructionType.JMC, 0, 0);
        for (Statement statement:
             cycle.statements) {
            generateStatement(statement, level);
        }
        generateInstruction(PL0InstructionType.JMP, 0, startingIndex);
        jumpInstruction.setParameter2(instructionCounter);
    }
    private void generateDoWhile(Cycle cycle, int level) throws CompilerException{
        int startingIndex = instructionCounter;
        for (Statement statement:
                cycle.statements) {
            generateStatement(statement, level);
        }
        generateExpression(cycle.condition.leftPart, level);
        generateExpression(cycle.condition.rightPart, level);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        PL0Instruction jumpInstruction = generateInstruction(PL0InstructionType.JMC, 0, 0);
        generateInstruction(PL0InstructionType.JMP, 0, startingIndex);
        jumpInstruction.setParameter2(instructionCounter);
    }
    private void generateRepeatUntil(Cycle cycle, int level) throws CompilerException{
        int startingIndex = instructionCounter;
        for (Statement statement:
                cycle.statements) {
            generateStatement(statement, level);
        }
        generateExpression(cycle.condition.leftPart, level);
        generateExpression(cycle.condition.rightPart, level);
        generateInstruction(PL0InstructionType.OPR, 0, cycle.condition.operation.getValue());
        generateInstruction(PL0InstructionType.JMC, 0, startingIndex);
    }
    private void generateReturn(Return ret, VarType returnType) throws CompilerException{
        if(ret.value != null){
            // return value
            TableSymbol retSymbol = SymbolTable.getInstance().getSymbolFromTable(ret.value.name, true);
            if(retSymbol != null && retSymbol.getType() == returnType){
                generateInstruction(PL0InstructionType.LOD, retSymbol.getLevel(), retSymbol.getAddr());
                generateInstruction(PL0InstructionType.STO, 1, returnAddress);
            }else {
                if(retSymbol == null){
                    throw new CompilerException(CompilerException.ERR_UNDEFINED_VARIABLE);
                }else {
                    throw new CompilerException(CompilerException.ERR_WRONG_RETURN_TYPE);
                }
            }
        }
    }
    private void generateSwitch(Switch sw, int level) throws CompilerException{
        TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(sw.variableDef.name, true);
        if(symbol != null && symbol.getType() == VarType.NUMBER){
            // check if all cases are different
            for (int i = 0; i < sw.cases.size(); i++) {
                for (int j = i+1; j < sw.cases.size(); j++) {
                    if(sw.cases.get(i).value == sw.cases.get(j).value){
                        throw new CompilerException(CompilerException.ERR_DUPLICATED_CASES);
                    }
                }
            }

            List<PL0Instruction> jumpNextInstructions = new ArrayList<>();
            List<PL0Instruction> jumpOutInstructions = new ArrayList<>();

            generateInstruction(PL0InstructionType.LOD, level, symbol.getAddr());
            for (Case cs :
                    sw.cases) {
                if(jumpNextInstructions.size()>0){
                    jumpNextInstructions.get(jumpNextInstructions.size()-1).setParameter2(instructionCounter);
                }
                generateInstruction(PL0InstructionType.LIT, 0, cs.value);
                PL0Instruction jump = generateInstruction(PL0InstructionType.JMC, 0, 0);
                jumpNextInstructions.add(jump);
                for (Statement statement:
                     cs.statements) {
                    generateStatement(statement, level);
                }
                jumpOutInstructions.add(generateInstruction(PL0InstructionType.JMP, 0, 0));

            }
            if(jumpNextInstructions.size()>0){
                jumpNextInstructions.get(jumpNextInstructions.size()-1).setParameter2(instructionCounter);
            }
            for (Statement statement :
                    sw.defaultCase.statements) {
                generateStatement(statement, level);
            }

            for (PL0Instruction instruction: jumpOutInstructions) {
                instruction.setParameter2(instructionCounter);
            }

        }else {
            if(symbol == null){
                throw new CompilerException(CompilerException.ERR_UNDEFINED_VARIABLE);
            }else {
                throw new CompilerException(CompilerException.ERR_WRONG_TYPE);
            }
        }
    }

    private void generateExpression(Expression expression, int level) throws CompilerException{
        List<Term> terms = expression.terms;
        if(terms.size() > 0){
            Term firstTerm = terms.get(0);
            // push 1 term to stack
            generateTerm(firstTerm, level);

            for (int i = 0; i < expression.operations.size(); i++) {
                Term term = terms.get(i+1);
                ValueOperations oper = expression.operations.get(i);

                generateTerm(term, level);
                if(oper != ValueOperations.UNKNOWN){
                    generateInstruction(PL0InstructionType.OPR, 0, oper.getValue());
                }else {
                    throw new CompilerException("Unknown operator");
                }
            }
        }
    }


    private void generateTerm(Term term, int level) throws CompilerException{
        List<Factor> factors = term.factors;
        if(factors.size()>0){
            Factor firstFactor = factors.get(0);
            generateFactor(firstFactor, level);
            for (int i = 0; i < term.operations.size(); i++) {
                Factor factor = factors.get(i+1);
                generateFactor(factor, level);
                ValueOperations oper = term.operations.get(i);
                generateInstruction(PL0InstructionType.OPR, 0, oper.getValue()); //TODO bool operations
            }
        }
    }

    private void generateFactor(Factor factor, int level) throws CompilerException{

        switch (factor.factorType){
            case CALL:
                generateCall(factor.call, true, level);
                break;
            case EXPRESSION:
                generateExpression(factor.expression, level);
                break;
            case VARIABLE:
                TableSymbol symbol = SymbolTable.getInstance().getSymbolFromTable(factor.vardef.name, true);
                generateInstruction(PL0InstructionType.LOD, level, symbol.getAddr());
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

