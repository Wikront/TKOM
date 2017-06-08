package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Contact extends Node {
    private String name;
    private int number;

    public Contact() {
        super(AST.NODE_TYPE.CONTACT);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }
}
