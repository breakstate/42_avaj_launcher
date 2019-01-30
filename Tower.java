import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>(); // list or collection of indeterminant amount

    public void register(Flyable flyable){
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        this.observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i).getState() == false) {
                observers.get(i).updateConditions();
            }
        }
    }
}
