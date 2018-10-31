package simulator;

import java.io.File;

import simulator.FileHandler;

public class Simulator {


    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        File file = new File(args[0]);

        System.out.println(args[0]);
        //System.out.println(args[1]);


        if (file.isFile()){
            System.out.println("valid file");
        } else {
            System.out.println("file invalid");
        }

        // open file and check for exceptions
        // create list of aircraft
        // run simulation
    }


}
