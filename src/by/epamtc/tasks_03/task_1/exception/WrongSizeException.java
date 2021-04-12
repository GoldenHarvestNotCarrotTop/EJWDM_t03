package epamtc.tasks_03.task_1.exception;

public class WrongSizeException extends Exception{
    public WrongSizeException() {
    }

    public WrongSizeException(String message) {
        super(message);
    }

    public WrongSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongSizeException(Throwable cause) {
        super(cause);
    }
}
