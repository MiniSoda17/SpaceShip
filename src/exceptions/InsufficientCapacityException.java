package exceptions;

public class InsufficientCapacityException extends Exception{
    public InsufficientCapacityException(){
        super();
    }

    public InsufficientCapacityException(String message){
        super(message);
    }
}
