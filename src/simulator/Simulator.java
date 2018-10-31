package simulator;

import java.io.File;

import simulator.FileHandler;

public class Simulator {


    public static void main(String[] args) {

        File file;
        FileHandler fileHandler = new FileHandler();

        if (args.length == 0){
            //throw exception
            file = new File("");
        } else {
            file = new File(args[0]);
        }

        if (file.isFile()){
            System.out.println("valid file");
        } //else throw exception

        fileHandler.lexer(args[0]);

        // open file and check for exceptions
        // create list of aircraft
        // run simulation
    }


}
