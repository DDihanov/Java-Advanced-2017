package Inheritance.P05_OnlineRadio.models;

import Inheritance.P05_OnlineRadio.еxceptions.*;

public class Song {
    private String name;
    private String artistName;
    private int minuteLenght;
    private int secondLength;
    private int totalLength;

    public Song(String name, String artistName, int minuteLenght, int secondLength) {
        this.setName(name);
        this.setArtistName(artistName);
        this.setMinuteLenght(minuteLenght);
        this.setSecondLength(secondLength);
        this.setTotalLength();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new InvalidSongNameException();
        }
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException();
        }
            this.artistName = artistName;
    }

    public int getMinuteLenght() {
        return minuteLenght;
    }

    private void setMinuteLenght(int minuteLenght) {
        if(minuteLenght < 0 || minuteLenght > 14){
            throw new InvalidSongMinutesException();
        }
        this.minuteLenght = minuteLenght;
    }

    public int getSecondLength() {
        return secondLength;
    }

    private void setSecondLength(int secondLength) {
        if(secondLength < 0 || secondLength > 59){
            throw new InvalidSongSecondsException();
        }
        this.secondLength = secondLength;
    }

    private int getTotalLength() {
        return totalLength;
    }

    private void setTotalLength() {
        int secondsLength = this.getSecondLength();
        int minutesLength = this.getMinuteLenght() * 60;

        int total = secondsLength + minutesLength;

        if(total < 0 || total > 899){
            throw new InvalidSongLengthException();
        }
        this.totalLength = totalLength;
    }
}
