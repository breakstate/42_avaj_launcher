package simulator;

public abstract class Aircraft {

    protected   long            id;
    protected   String          name;
    protected   Coordinates     coordinates;
    private     static long     idCounter;

    Aircraft(){

    }


    protected Aircraft(String name, Coordinates coordinates){

    }

    private long nextId(){
        return(3);
    }
}
