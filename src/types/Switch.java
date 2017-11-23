package types;

import java.util.List;

public class Switch extends Statement {
    public Variable variable; // switch (variable){...}  ---  switch(A){...}
    public List<Case> cases;
    public Case defaultCase;
}
