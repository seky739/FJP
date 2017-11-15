package types;

import types.Identificator;
import types.Method;
import types.Variable;

import java.util.List;

public class Program extends Identificator {
    public Block block;

    public Program(Block block){
        this.block = block;
    }
}
