package simulator;

import java.io.File;

import simulator.Loader;

public class Simulator {


    public static void main(String[] args) {

        String line;

        Loader.openFile(args[0]);
        while ((line = Loader.readLine()) != null){
            System.out.print(line);
        }
    }


}
