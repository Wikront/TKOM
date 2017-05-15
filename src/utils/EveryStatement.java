package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class EveryStatement extends Node {
    private int time;
    private Block block;

    public EveryStatement() {
        super(AST.NODE_TYPE.EVERY_STATEMENT);
    }
    public void setTime(int time){
        this.time = time;
    }
    public void setBlock(Block block){
        this.block = block;
    }
}
