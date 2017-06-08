package utils;

import java.util.LinkedList;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class IfCondition extends Node {
    private LinkedList<String> singleConditions;
    private LinkedList<String> not;
    private LinkedList<String> operators;

    public IfCondition() {
        super(AST.NODE_TYPE.IF_CONDITION);
        singleConditions = new LinkedList<>();
        not = new LinkedList<>();
        operators = new LinkedList<>();
    }

    public String getCondition(){
        return singleConditions.get(0);
    }

    public void addSingleCondition(String condition){
        singleConditions.add(condition);
    }

    public void addNot(String string){
        not.add(string);
    }

    public void addOperator(String operator){
        operators.add(operator);
    }
    public LinkedList<String> getSingleConditions(){
        return singleConditions;
    }
}
