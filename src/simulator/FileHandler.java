package simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    private String file;
    int lines = 0;
    int run = 0;
    ArrayList<String[]> craft = new ArrayList();
    String tokens[];
    private String line;
    String deliminator = " ";

    FileHandler(){
    }


    // lexer
    public void lexer(String fileArg){
        file = fileArg;

        try(BufferedReader br = new BufferedReader((new FileReader(file)))) {
            while ((this.line = br.readLine()) != null){
                this.lines++;
                System.out.println("reading line: " + line); // debug
                this.tokens = this.line.split(deliminator);
                if (this.lines == 1 && this.tokens.length == 1) {
                    this.run = Integer.parseInt(this.tokens[0]);
                    System.out.println("run = " + this.run); // debug
                    System.out.println("tokens length = " + this.tokens.length); // debug
                } else {
                    String news[] = new String[0];
                    news = tokens;

                    craft.add(new String[0]);
                    for (String s: tokens) {
                        for (int i = 0 ; i < token)
                        craft.get(0)[0] = s;
                    }

                }
                for (String token: this.tokens){
                    System.out.println(token); // debug (prints tokens)
                }
            }
            System.out.println("craft contents = " + this.craft); // debug (prints tokens)

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
