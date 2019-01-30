

public class Simulator {

    public static           WeatherTower wt= new WeatherTower();
    public static int       cycles;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("scenario.txt")) {
            cycles = Loader.openFile(args[0]);
        } else {
            System.out.println("Sorry! Wrong input file.");
            return;
        }
        for (int i = 0; i < cycles; i++) {
            System.out.println("\nSimulation cycle: " + (i + 1));// debug
            wt.changeWeather();
        }
    }


}
