package Inheritance.P05_OnlineRadio.еxceptions;

public class InvalidSongLengthException extends InvalidSongException {
    public InvalidSongLengthException() {
        super("Invalid song length.");
    }

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
