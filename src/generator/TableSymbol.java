package generator;

import types.Identificator;
import types.Method;
import types.Variable;

import java.util.List;

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

    public static TableSymbol getSymbolFromTable(List<TableSymbol> tableOfSymbols, String identName, boolean isVariable){
        TableSymbol result = null;

        // there can be more var with same name
        for (int i = tableOfSymbols.size()-1; i >= 0; i--) {
            TableSymbol s = tableOfSymbols.get(i);
            if(isVariable){
                if(s.isVariable() && s.getIdentificator().name.equals(identName)){
                    result = s;
                    break;
                }
            }else {
                if(s.isMethod() && s.getIdentificator().name.equals(identName)){
                    result = s;
                    break;
                }
            }
        }

        //TODO symbol was not found
        if(result == null){
            System.err.println("Symbol "+identName+" was not found in table");
        }

        return result;
    }
}
