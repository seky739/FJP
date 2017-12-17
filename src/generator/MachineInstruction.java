package generator;

public class MachineInstruction {
    private int number;
    private PL0Instruction instruction;
    private int parameter1, parameter2;

    public MachineInstruction(int number, PL0Instruction instruction, int parameter1, int parameter2){
        this.number = number;
        this.instruction = instruction;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PL0Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(PL0Instruction instruction) {
        this.instruction = instruction;
    }

    public int getParameter1() {
        return parameter1;
    }

    public void setParameter1(int parameter1) {
        this.parameter1 = parameter1;
    }

    public int getParameter2() {
        return parameter2;
    }

    public void setParameter2(int parameter2) {
        this.parameter2 = parameter2;
    }
}
