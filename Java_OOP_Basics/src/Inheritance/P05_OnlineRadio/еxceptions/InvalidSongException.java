package Inheritance.P05_OnlineRadio.еxceptions;

public class InvalidSongException extends IllegalArgumentException {

    public InvalidSongException(){
        super("Invalid song.");
    }
    public InvalidSongException(String message) {
        super(message);
    }
}
