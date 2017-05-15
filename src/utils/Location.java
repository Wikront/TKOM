package utils;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Location extends Node {
    int around;
    float x;
    float y;

    public Location() {
        super(AST.NODE_TYPE.LOCATION);
    }
    public void setAround(int around){
        this.around = around;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
}
