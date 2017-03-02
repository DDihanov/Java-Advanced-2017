package Inheritance.P05_OnlineRadio;

import Inheritance.P05_OnlineRadio.models.Playlist;
import Inheritance.P05_OnlineRadio.models.Song;
import Inheritance.P05_OnlineRadio.еxceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(sc.readLine());

        Playlist playlist = new Playlist();

        for (int i = 0; i < count; i++) {
            String[] songInfo = sc.readLine().split(";");

            String artistName = songInfo[0];
            String songName = songInfo[1];


            try{
                int minuteLength = Integer.parseInt(songInfo[2].split(":")[0]);
                int secondLength = Integer.parseInt(songInfo[2].split(":")[1]);

                Song song = new Song(songName, artistName, minuteLength, secondLength);

                playlist.addSong(song);

            }catch (InvalidSongException e){
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid song length.");
            }
        }

        playlist.getTotalLength();
        System.out.println(playlist.toString());
    }
}
