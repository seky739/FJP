package types;

import generator.IGenerable;

import java.util.List;

public class Assignment extends Statement implements IGenerable{
    // multiple
    public List<String> varNames;
    public List<Expression> expressions;

    @Override
    public void generateCode() {

    }
}
