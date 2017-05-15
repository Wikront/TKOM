package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class ForeachStatement extends Node {
    Block block;

    public ForeachStatement() {
        super(AST.NODE_TYPE.FOREACH_STATEMENT);
    }
    public void setBlock(Block block){
        this.block = block;
    }
}
