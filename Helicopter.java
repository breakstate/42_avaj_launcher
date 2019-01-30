public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public boolean landed = false;
    private String msg;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String newCondition = this.weatherTower.getWeather(this.coordinates);
        String message = "Didn't copy that, say again, over";
        if (this.coordinates.getHeight() == 0){
            message = "landing! " + "lat: " + this.coordinates.getLatitude() + " lon: " + this.coordinates.getLongitude() + "\n| Tower: Helicopter #" + this.name + " (" + this.id + ") unregistered from tower, over and out.";
            //this.weatherTower.unregister(this);
            landed = true;
        } else {
            //System.out.println("Helicopter#" + this.name + " BEFORE: lat = " + coordinates.getLatitude() + " lon = " + coordinates.getLongitude() + " h = " + coordinates.getHeight()); // debug
            switch (newCondition) {
                case "SUN":
                    coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                    message = "Clear skies! Increasing engine RPM";
                    break;
                case "RAIN":
                    coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                    message = "This stuff is going to rust my swash plate";
                    break;
                case "FOG":
                    coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                    message = "Not even my rotor can cut through this fog";
                    break;
                case "SNOW":
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                    message = "Emergency descent! Before the lines freeze and we can't autorotate!";
                    break;
            }
        }
        //System.out.println("Helicopter#" + this.name + " AFTER: lat = " + coordinates.getLatitude() + " lon = " + coordinates.getLongitude() + " h = " + coordinates.getHeight()); // debug


        System.out.println("Helicopter#" +this.name + "(" + this.id + "): " + message); // debug
        Loader.writeToFile("Helicopter#" +this.name + "(" + this.id + "): " + message);
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("| Tower: Helicopter #" + this.name + " (" + this.id + ") registered to weather tower, over.");
        Loader.writeToFile("| Tower: Helicopter #" + this.name + " (" + this.id + ") registered to weather tower, over.");
    }

    public boolean getState(){
        return landed;
    }
}
