package task_1.exception;

public class WrongFileFormatException extends Exception{
    public WrongFileFormatException(String message) {
        super(message);
    }
}