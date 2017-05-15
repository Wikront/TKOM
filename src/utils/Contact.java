package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Contact extends Node {
    private String name;

    public Contact() {
        super(AST.NODE_TYPE.CONTACT);
    }
    public String getName(){
        return name;
    }
}
