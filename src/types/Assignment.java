package types;

import generator.IGenerable;

import java.util.List;

public class Assignment extends Statement implements IGenerable{
    // multiple
    public List<String> varNames;
    public Expression expression;

    @Override
    public void generateCode() {

    }

}
