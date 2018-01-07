package generator;

import java.util.ArrayList;
import java.util.List;

public class PL0InstructionList {

    private static PL0InstructionList instance;

    private List<PL0Instruction> instructionList;


    private PL0InstructionList(){
        this.instructionList = new ArrayList<>();
    }
    public static PL0InstructionList getInstance(){
        if(instance == null){
            instance = new PL0InstructionList();
        }
        return instance;
    }

    public void addInstruction(PL0Instruction instruction){
        this.instructionList.add(instruction);
    }


    public List<PL0Instruction> getInstructionList() {
        return instructionList;
    }
}
