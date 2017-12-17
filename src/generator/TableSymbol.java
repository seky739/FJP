package generator;

import types.Identificator;
import types.Method;
import types.Variable;

public class TableSymbol {
    private Identificator identificator;
    private int addr;
    private int level;

    public TableSymbol(Identificator identificator, int addr, int level){
        this.identificator = identificator;
        this.addr = addr;
        this.level = level;
    }

    public boolean isVariable(){
        return identificator instanceof Variable;
    }

    public boolean isMethod(){
        return identificator instanceof Method;
    }

    public boolean isGlobalVar(){
        return isVariable() && this.level == 0;
    }

    public boolean isLocalVar(){
        return isVariable() && this.level > 1;
    }

    public Identificator getIdentificator() {
        return identificator;
    }

    public void setIdentificator(Identificator identificator) {
        this.identificator = identificator;
    }

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
