package task_1.exception;

public class ArrayIndexOutOfBoundsException extends Exception{
    public ArrayIndexOutOfBoundsException() {
    }

    public ArrayIndexOutOfBoundsException(String message) {
        super(message);
    }

    public ArrayIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}
