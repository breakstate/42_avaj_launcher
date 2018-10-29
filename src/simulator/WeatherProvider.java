package simulator;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private String weather[];

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){

    }

    public String getCurrentWeather(Coordinates coordinates){

    }

    private static WeatherProvider ourInstance = new WeatherProvider();

    public static WeatherProvider getInstance() {
        return ourInstance;
    }
}
