package source;

import lexer.Token;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Wiktor on 13.05.2017.
 */
public class Source {
    private String filename;
    private BufferedReader reader;
    private int line;
    private int column;

    public Source(String filename){
        this.filename = filename;
        openFile();
        line = 1;
        column = 1;
    }

    private void openFile(){
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("FATAL ERROR >Could not open the file<");
        }
    }

    public int nextChar(){
        int character = 0;
        try {
            reader.mark(0);
            character = reader.read();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(character == '\n'){
            line++;
            column = 1;
        }
        column++;
        return character;
    }

    public void reset(){
        try {
            reader.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TextPosition getPosition(){
        return new TextPosition(line, column);
    }
}
