package epamtc.tasks_03.task_1.exception;

public class ArrayNotSortedException extends Exception {
    public ArrayNotSortedException() {
    }

    public ArrayNotSortedException(String s) {
        super(s);
    }

    public ArrayNotSortedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayNotSortedException(Throwable cause) {
        super(cause);
    }
}
