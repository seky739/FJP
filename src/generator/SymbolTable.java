package generator;

import types.Parameter;
import types.VariableDef;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {

    private static SymbolTable instance;
    private List<TableSymbol> tableOfSymbols;


    private SymbolTable(){
        this.tableOfSymbols = new ArrayList<>();
    }

    public static SymbolTable getInstance() {
        if(instance == null){
            instance = new SymbolTable();
        }
        return instance;
    }

    public int getSize(){
        return this.tableOfSymbols.size();
    }

    public boolean addSymbol(TableSymbol symbol){
        boolean result = true;
        for (TableSymbol s :
                tableOfSymbols) {
            if (s.equals(symbol)){
                result = false;
                break;
            }
        }
        if(result){
            this.tableOfSymbols.add(symbol);
        }
        return result;
    }

    public boolean removeSymbol(TableSymbol symbol){
        return symbol.isVariable() && removeSymbol(symbol.getIdentifier().name, symbol.getLevel());
    }

    public boolean removeSymbol(String name, int level){
        boolean removed = false;
        int it = 0;
        while(it < tableOfSymbols.size()){
        TableSymbol symbol = tableOfSymbols.get(it);
            if(level == symbol.getLevel() && symbol.getIdentifier().name.equals(name)){
                tableOfSymbols.remove(it);
                removed = true;
                break;
            }
            it++;
        }
        return removed;
    }

    public List<TableSymbol> getTableOfSymbols() {
        return tableOfSymbols;
    }

    public boolean removeMultipleParameters(List<Parameter> params, int level){
        boolean removed = true;
        for (Parameter parameter :
                params) {
            if (!removeSymbol(parameter.name, level)) {
                removed = false;
            }
        }
        return removed;
    }

    public boolean removeMultipleSymbols(List<VariableDef> vars, int level){
        boolean removed = true;
        for (VariableDef var :
                vars) {
            if (!removeSymbol(var.name, level)) {
                removed = false;
            }
        }
        return removed;
    }

    public TableSymbol getSymbolFromTable(String identName, boolean isVariable){
        TableSymbol result = null;

        // there can be more var with same name
        for (int i = tableOfSymbols.size()-1; i >= 0; i--) {
            TableSymbol s = tableOfSymbols.get(i);
            if(isVariable){
                if(s.isVariable() && s.getIdentifier().name.equals(identName)){
                    result = s;
                    break;
                }
            }else {
                if(s.isMethod() && s.getIdentifier().name.equals(identName)){
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


    public boolean isEmpty(){
        return tableOfSymbols.isEmpty();
    }
}
