package exceptions;

public class KeyNotFoundException extends RuntimeException {

    public static final String KEY_NOT_FOUND =
            "Student must be enrolled in a course before you set his mark.";

    public KeyNotFoundException() {
        super(KEY_NOT_FOUND);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}
