package simulator;

import java.io.File;

import simulator.Loader;

public class Simulator {

    public static           WeatherTower wt= new WeatherTower();
    public static int       iterations;

    public static void main(String[] args) {
        Loader.openFile(args[0]);
    }


}
