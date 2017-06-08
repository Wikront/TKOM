package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class EveryStatement extends Node {
    private int time;

    public int getTime() {
        return time;
    }

    public Block getBlock() {
        return block;
    }

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
