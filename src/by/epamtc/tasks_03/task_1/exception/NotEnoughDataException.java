package epamtc.tasks_03.task_1.exception;

public class NotEnoughDataException extends Exception {
    public NotEnoughDataException() {
    }

    public NotEnoughDataException(String s) {
        super(s);
    }

    public NotEnoughDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughDataException(Throwable cause) {
        super(cause);
    }
}
