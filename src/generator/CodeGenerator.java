package generator;

import types.*;
import types.enums.ValueOperations;
import types.enums.VarType;

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


    private void generateVariableDefs(List<VariableDef> variableDefs, int startAddress, int level) throws CompilerException{
        if(variableDefs.size() > 0){
            generateInstruction(PL0InstructionType.INT, 0, variableDefs.size());
            for (VariableDef var :
                    variableDefs) {
                TableSymbol symbol = new TableSymbol(var, startAddress, level, var.isVarConstant, var.type);
                if(!SymbolTable.getInstance().addSymbol(symbol)){
                    throw new CompilerException(CompilerException.ERR_DUPLICATED_VARIABLE);
                }
                int value = var.value;
                // if typ is boolean then non binary values will have to change to 0 or 1
                if(var.type == VarType.BOOL){
                    value = value == 0 ? 0 : 1;
                }
                generateInstruction(PL0InstructionType.LIT, 0, value);
                generateInstruction(PL0InstructionType.STO, 0, symbol.getAddr());
                startAddress++;
            }
        }
    }

    private TableSymbol generateMethod(Method method, int addr) throws CompilerException{
        final int LEVEL = 1;
        TableSymbol result = new TableSymbol(method, this.instructionCounter, LEVEL, false, null);
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
                generateParallelAssignment((ParallelAssignment)statement);
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
        if(symbol != null || symbol.isConstant()){

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
            if(symbol == null){
                throw new CompilerException("Variable "+assignment.variableDef.name+" undefined");
            }else {
                throw new CompilerException("Constants are immutable");
            }
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
            TableSymbol newSymbol = new TableSymbol(p, actualAddr, 1, false, null); //TODO check
            SymbolTable.getInstance().addSymbol(newSymbol);
            generateInstruction(PL0InstructionType.LOD, 1, actualAddr);
            actualAddr++;
        }
    }

    // DONE
    private void generateAssignment(Assignment assignment) throws CompilerException {

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
            generateExpression((Expression) statement);
        }else if(statement instanceof Call){
            generateCall((Call) statement);
        }else {
            throw new CompilerException(CompilerException.ERR_UNKNOWN);
        }
        // now the value is in the top of stack -> store it
        // first var
        TableSymbol firstSymbol = SymbolTable.getInstance().getSymbolFromTable(assignment.varNames.get(0), true);
        generateInstruction(PL0InstructionType.STO, 0, firstSymbol.getAddr());

        // other vars
        for (int i = 1; i < symbolList.size(); i++) {
            generateInstruction(PL0InstructionType.LIT, 0, value);
            generateInstruction(PL0InstructionType.STO, 0, symbolList.get(i).getAddr());
        }
    }

    private void generateParallelAssignment(ParallelAssignment assignment) throws CompilerException{
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
                        generateInstruction(PL0InstructionType.STO, 0, symbol.getAddr());
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
    private void generateSwitch(Switch sw) throws CompilerException{
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

            generateInstruction(PL0InstructionType.LOD, 0, symbol.getAddr());
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
                    generateStatement(statement);
                }
                jumpOutInstructions.add(generateInstruction(PL0InstructionType.JMP, 0, 0));

            }
            if(jumpNextInstructions.size()>0){
                jumpNextInstructions.get(jumpNextInstructions.size()-1).setParameter2(instructionCounter);
            }
            for (Statement statement :
                    sw.defaultCase.statements) {
                generateStatement(statement);
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

