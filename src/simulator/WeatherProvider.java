package simulator;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
        Integer x = coordinates.getLatitude();
        Integer y = coordinates.getLongitude();
        Integer z = coordinates.getHeight();
        Integer result = ((x * y) + z) % 4;

        return (weather[result]);
    }
}
