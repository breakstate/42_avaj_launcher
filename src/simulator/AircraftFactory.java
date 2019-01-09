package simulator;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        if (longitude < 0 || latitude < 0)
            throw new RuntimeException("Inalid coordinates.");
        if (height < 0) {
            height = 0;
        } else if (height > 100) {
            height = 100;
        }
        if (type.equals("Baloon"))
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        if (type.equals("Helicopter"))
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        if (type.equals("JetPlane"))
            return new JetPlane(name, new Coordinates(longitude, latitude, height));
        throw new RuntimeException("Factory malfunction. This wasn't your fault. You shouldn't feel bad.");
    }
}
