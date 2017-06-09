package utils;

import generator.*;
import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;

/**
 * Created by Wiktor on 09.06.2017.
 */
public class Response {
    int type;
    String message;
    LinkedList<generator.Contact> contacts;
    int interval;
    int count;

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public LinkedList<generator.Contact> getContacts() {
        return contacts;
    }

    public int getInterval() {
        return interval;
    }

    public int getCount() {
        return count;
    }

    public Response (String message){
        this.message = message;
        this.type = 0;
    }

    public Response (String message, LinkedList<generator.Contact> contact){
        this.message = message;
        this.contacts = contact;
        this.type = 2;
    }

    public Response (String message, int interval, int count){
        this.message = message;
        this.interval = interval;
        this.count = count;
        this.type = 1;
    }
}
