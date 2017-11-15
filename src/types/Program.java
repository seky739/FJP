package types;

import types.Identificator;
import types.Method;
import types.Variable;

import java.util.List;

public class Program extends Identificator {
    //public Block block;
    public List<Block> blocks;

    public Program(String name, Block block){
        this.name = name;
        //this.block = block;
    }
}
