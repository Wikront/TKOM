package utils;

import java.util.LinkedList;

/**
 * Created by Wiktor on 15.05.2017.
 */
public class Program extends Node {
    private LinkedList<Condition> conditions;
    private LinkedList<IfStatement> ifStatements;
    private LinkedList<ForeachStatement> foreachStatements;
    private LinkedList<EveryStatement> everyStatements;
    private LinkedList<Contact> contacts;

    public Program() {
        super(AST.NODE_TYPE.PROGRAM);
        conditions = new LinkedList<>();
        ifStatements = new LinkedList<>();
        everyStatements = new LinkedList<>();
        foreachStatements = new LinkedList<>();
        contacts = new LinkedList<>();
    }
    public LinkedList<Condition> getConditions(){
        return conditions;
    }
    public LinkedList<IfStatement> getIfStatements(){
        return ifStatements;
    }
    public LinkedList<ForeachStatement> getForeachStatements(){
        return foreachStatements;
    }
    public LinkedList<Contact> getContacts(){
        return contacts;
    }
    public void addCondition(Condition condition){
        conditions.add(condition);
    }
    public void addIfStatement(IfStatement ifStatement){
        ifStatements.add(ifStatement);
    }
    public void addForeachStatement(ForeachStatement foreachStatement){
        foreachStatements.add(foreachStatement);
    }
    public void addEveryStatement(EveryStatement everyStatement){
        everyStatements.add(everyStatement);
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
}
