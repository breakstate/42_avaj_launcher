package simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    private String file;
    static int lines = 0;
    int run = 0;
    String tokens[];
    private String line;
    String deliminator = " ";

    FileHandler(){
    }


    // lexer
    public void lexer(String fileArg){
        file = fileArg;

        try(BufferedReader br = new BufferedReader((new FileReader(file)))){
            while ((line = br.readLine()) != null){
                System.out.println(line);
                tokens = line.split(deliminator);
                for (String token: tokens){
                    System.out.println(token);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e){
            System.out.println("IOException");
        }

    }

    // parser
    public void parser(String line[]){

    }

    // exceptions
}
