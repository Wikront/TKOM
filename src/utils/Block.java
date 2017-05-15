package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Block extends Node {
    private String message;

    public Block() {
        super(AST.NODE_TYPE.BLOCK);
        message = "";
    }

    public void addWord(String word){
        message += " ";
        message += word;
    }
}
