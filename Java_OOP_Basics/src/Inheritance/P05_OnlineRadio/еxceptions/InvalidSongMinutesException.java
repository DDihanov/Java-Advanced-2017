package Inheritance.P05_OnlineRadio.еxceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException() {
        super("Song minutes should be between 0 and 14.");
    }
}
