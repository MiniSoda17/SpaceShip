package exceptions;

public class NoPathException extends Exception{
    public NoPathException(){
        super();
    }

    public NoPathException(String message){
        super(message);
    }
}