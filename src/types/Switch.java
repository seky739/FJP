package types;

import types.enums.StatementType;

import java.util.List;

public class Switch extends Statement {
    public VariableDef variableDef; // switch (variableDef){...}  ---  switch(A){...}
    public List<Case> cases;
    public Case defaultCase;

    public Switch(){
        this.type = StatementType.SWITCH;
    }
}
