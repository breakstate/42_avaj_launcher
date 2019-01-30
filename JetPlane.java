public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String newCondition = this.weatherTower.getWeather(this.coordinates);
        String message = "Didn't copy that, say again, over";
        if (this.coordinates.getHeight() == 0){
            message = "landing! "  + "lat: " + this.coordinates.getLatitude() + " lon: " + this.coordinates.getLongitude() + "\n| Tower: JetPlane #" + this.name + " (" + this.id + ") unregistered from tower, over and out.";
            this.weatherTower.unregister(this);
        } else {
            //System.out.println("JetPlane#" + this.name + " BEFORE: lat = " + coordinates.getLatitude() + " lon = " + coordinates.getLongitude() + " h = " + coordinates.getHeight()); // debug
            switch (newCondition) {
                case "SUN":
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                    message = "Smooth sailing! Props to coarse!";
                    break;
                case "RAIN":
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                    message = "Turn the wipers on, will ya? At least we won't have any bird strikes";
                    break;
                case "FOG":
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                    message = "I sure hope this clears up before we go wheels down";
                    break;
                case "SNOW":
                    coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                    message = "Initiate dive before the hydraulic lines freeze";
                    break;
            }
        }
        //System.out.println("JetPlane#" + this.name + " AFTER: lat = " + coordinates.getLatitude() + " lon = " + coordinates.getLongitude() + " h = " + coordinates.getHeight()); // debug


        System.out.println("JetPlane#" +this.name + "(" + this.id + "): " + message); // debug
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("| Tower: JetPlane #" + this.name + " (" + this.id + ") registered to weather tower, over.");
    }
}
