package pl.akademia.exceptions;

public class ClassNotFoundException  extends RuntimeException{
    public ClassNotFoundException(String message) {
        super(message);
    }
}
