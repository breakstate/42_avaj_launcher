package simulator;
import java.util.Random;

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
        int randomInt = new Random().nextInt(2);
        System.out.println("Random int = " + randomInt);
        Integer result = (((x * y) + z) + randomInt) % 4;

        //System.out.println("Weather provider returns: " + weather[result]);// debug
        return (weather[result]);
    }
}
