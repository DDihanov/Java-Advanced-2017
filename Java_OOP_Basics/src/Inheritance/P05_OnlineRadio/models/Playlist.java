package Inheritance.P05_OnlineRadio.models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;
    private int hourLength;
    private int minuteLength;
    private int secondLength;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    private List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.getSongs().add(song);
        System.out.println("Song added.");
    }

    public void getTotalLength() {
        int totalSeconds = 0;
        for (Song s :
                this.getSongs()) {
            totalSeconds += s.getSecondLength();
            totalSeconds += s.getMinuteLenght() * 60;
        }

        this.hourLength = totalSeconds / 3600;
        this.minuteLength = (totalSeconds % 3600) / 60;
        this.secondLength = totalSeconds % 60;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Songs added: %d", this.getSongs().size()))
                .append(System.lineSeparator())
                .append(String.format("Playlist length: %dh %dm %ds", this.hourLength, this.minuteLength, this.secondLength));

        return sb.toString();
    }
}
