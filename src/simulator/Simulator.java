package simulator;

import java.io.File;

import simulator.Loader;

public class Simulator {


    public static void main(String[] args) {

        String line;

        Loader.openFile(args[0]);
        System.out.println("args[0] = " + args[0]);
        //while ((line = Loader.readLn()) != null){
         //   System.out.println(line);
        //}
    }


}
