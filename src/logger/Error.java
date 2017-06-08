package logger;

import lexer.Token;
import source.TextPosition;

/**
 * Created by Wiktor on 14.05.2017.
 */
public class Error {
    public Error (){}
    public void expexted(Token.TYPE expectedType, Token token){
        System.out.println("Expected token: <" + expectedType + "> but have <"
                + token.getType() + "> value: \"" + token.getValue() + "\" at Line: " +
                    token.getPosition().getLineNumber() + " at Column: " + token.getPosition().getColumnNumber());
    }
    public void unexpected(Token token, Token.TYPE types[]){
        String allowed = "";
        for( int i = 0; i < types.length; i++){
            allowed = allowed + " " + types[i];
        }
        System.out.println("Unexpected token: <" + token.getType() + "> value: \"" + token.getValue() + "\" at Line: "+
                + token.getPosition().getLineNumber() + " at Column: " + token.getPosition().getColumnNumber() +
                    " Allowed tokens: " + allowed);
    }
    public void undeclared(String name){
        System.out.println("Condition <" + name + "> used but undeclared");
    }
    public void redefined(String name){
        System.out.println("Condition <" + name + "> definition duplicated");
    }
    public void redefinedContact(String name){
        System.out.println("Contact <" + name + "> definition duplicated");
    }
}
