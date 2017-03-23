package exceptions;

public class InvalidStringException extends RuntimeException {

    private static final String NULL_OR_EMPTY_VALUE = "Value cannot be null or empty.";

    public InvalidStringException() {
        super(NULL_OR_EMPTY_VALUE);
    }

    public InvalidStringException(String message) {
        super(message);
    }
}
