package generator;

import lexer.Token;
import utils.*;
import utils.Contact;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Wiktor on 08.06.2017.
 */
public class Generator {
    LinkedList<Condition> conditions;
    Program program;
    HashMap<String, Integer> variablesNames;
    LinkedList<generator.Contact> contacts;
    LinkedList<Notification> notifications;

    public Generator(Program program){
        conditions = new LinkedList<>();
        variablesNames = new HashMap<>();
        this.program = program;
        generateVariables();
        generateContacts();
        System.out.println(conditions);
        System.out.println(variablesNames);
    }

    private void generateVariables(){
        LinkedList<utils.Condition> conditions = program.getConditions();
        for(int i = 0; i < conditions.size(); i++){
            utils.Condition condition = conditions.get(i);
                Token.TYPE type = conditions.get(i).getType();
                switch (type) {
                    case DAY:
                        processDay(condition.getDay());
                        break;
                    case LOCATION:
                        processLocation(condition.getLocation());
                        break;
                    case MONTH:
                        processMonth(condition.getMonth());
                        break;
                    case TIME:
                        processTime(condition.getTime());
                        break;
                    case WEEKDAY:
                        processWeekday(condition.getWeekday());
                        break;
                    case COND:
                        processCond(condition);
                        break;
                }
                variablesNames.put(condition.getName(), this.conditions.size() - 1);
        }
    }

    private void generateContacts(){
        LinkedList<utils.Contact> contacts = program.getContacts();
        for(int i = 0; i < contacts.size(); i++){
            processContacts(contacts.get(i));
        }
    }

    private void processDay(utils.Day day){
        if(day.getFrom() == day.getTo()){
            conditions.add(new Day(day.getFrom()));
        } else {
            conditions.add(new Day(day.getFrom(), day.getTo()));
        }

    }

    private void processLocation(utils.Location location){
        conditions.add(new Location(location.getX(), location.getY(), location.getAround()));
    }

    private void processMonth(utils.Month month){
        if(month.getTo() == month.getFrom()){
            conditions.add(new generator.Month(month.getFrom()));
        } else {
            conditions.add(new generator.Month(month.getFrom(), month.getTo()));
        }
    }

    private void processTime(utils.Time time){
        if(time.getHoursFrom() == time.getHoursTo() && time.getMinutesFrom() == time.getMinutesTo()){
            conditions.add(new Time(time.getHoursFrom(), time.getMinutesFrom()));
        } else {
            conditions.add(new Time(time.getHoursFrom(), time.getMinutesFrom(), time.getHoursTo(), time.getMinutesTo()));
        }
    }

    private void processWeekday(utils.Weekday weekday){
        if(weekday.getTo() == weekday.getFrom()){
            conditions.add(new generator.Weekday(weekday.getFrom()));
        } else {
            conditions.add(new generator.Weekday(weekday.getFrom(), weekday.getTo()));
        }

    }

    private void processCond(utils.Condition condition){
        Condition condition1 = conditions.get(variablesNames.get(condition.getFirstConditionName()));
        Condition condition2 = conditions.get(variablesNames.get(condition.getSecondConditionName()));
        int oprator = 0;
        if(condition.getOperator() == "and"){
            oprator = 0;
        } else if (condition.getOperator() == "else"){
            oprator = 1;
        }

        conditions.add(new Cond(condition1, condition2, oprator, condition.isFirstNot(), condition.isSecondNot()));
    }

    private void processContacts(utils.Contact contact){
        contacts.add(new generator.Contact(contact.getNumber(), contact.getName()));
    }

    private void processIfStatement(IfStatement ifStatement){
        Block block = ifStatement.getBlock();
        String condition = ifStatement.getCondition();
        if(block.getType() == 0){
            ForeachStatement foreachStatement = block.getForeachStatement();
            String message = foreachStatement.getBlock().getMessage();
            notifications.add(new Notification(message, contacts, conditions.get(variablesNames.get(condition))));
        }
        if(block.getType() == 1){
            notifications.add(new Notification(block.getMessage(), conditions.get(variablesNames.get(condition))));
        }
        if(block.getType() == 2){
            EveryStatement everyStatement =block.getEveryStatement();
            int time = everyStatement.getTime();
            String message = everyStatement.getBlock().getMessage();
            notifications.add(new Notification(message, time, 10, conditions.get(variablesNames.get(condition))));
        }
    }
}
