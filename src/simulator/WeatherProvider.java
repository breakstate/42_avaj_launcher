package simulator;

public class WeatherProvider {
    private static WeatherProvider ourInstance = new WeatherProvider();

    public static WeatherProvider getInstance() {
        return ourInstance;
    }

    private WeatherProvider() {
    }
}
