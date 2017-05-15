package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class IfStatement extends Node {
    Block block;
    IfCondition ifCondition;

    public IfStatement() {
        super(AST.NODE_TYPE.IF_STATEMENT);
    }
    public void setBlock(Block block){
        this.block = block;
    }
    public void setIfCondition(IfCondition ifCondition){
        this.ifCondition = ifCondition;
    }
    public IfCondition getIfCondition(){
        return ifCondition;
    }
}
