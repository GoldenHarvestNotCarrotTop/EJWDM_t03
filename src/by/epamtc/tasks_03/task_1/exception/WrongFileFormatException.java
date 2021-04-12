package epamtc.tasks_03.task_1.exception;

public class WrongFileFormatException extends Exception{
    public WrongFileFormatException() {
    }

    public WrongFileFormatException(String message) {
        super(message);
    }

    public WrongFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFileFormatException(Throwable cause) {
        super(cause);
    }
}
