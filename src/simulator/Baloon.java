package simulator;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String newCondition = this.weatherTower.getWeather(this.coordinates);
        String message = "Didn't copy that, say again, over";
        switch (newCondition) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                message = "Burn that propane!";
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                message = "The baloon is soaking up water and getting heavy!";
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                message = "Better pick a spot and put 'er down";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                message = "Emergency descent! Vent the envelope!";
                break;
        }
        if (this.coordinates.getHeight() == 0){
            message = "landing!";
            this.weatherTower.unregister(this);
            System.out.println("Tower: Helicopter #" + this.name + " (" + this.id + ") unregistered from tower, over and out."); // debug
        }

        System.out.println("Baloon#" +this.name + "(" + this.id + "): " + message); // debug
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower: Baloon #" + this.name + " (" + this.id + ") registered to weather tower, over.");
    }
}
