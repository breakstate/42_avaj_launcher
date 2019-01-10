package simulator;

import java.io.File;

import simulator.Loader;

public class Simulator {

    public static           WeatherTower wt= new WeatherTower();
    public static int       cycles;

    public static void main(String[] args) {
        cycles = Loader.openFile(args[0]);
        for (int i = 0; i < cycles; i++) {
            System.out.println("\nSimulation cycle: " + (i + 1));// debug
            wt.changeWeather();
        }
    }


}
