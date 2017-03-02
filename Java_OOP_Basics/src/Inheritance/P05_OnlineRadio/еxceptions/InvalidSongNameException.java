package Inheritance.P05_OnlineRadio.еxceptions;

public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException() {
        super("Song name should be between 3 and 30 symbols.");
    }
}
