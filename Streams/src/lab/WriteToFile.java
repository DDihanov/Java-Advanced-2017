package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Austin on 27/01/2017.
 */
public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\streams\\input.txt";
        String outputPath = "C:\\streams\\Files-and-Streams\\output.txt";

        ArrayList<Character> punctuation = new ArrayList<>(Arrays.asList(',', '.', '!', '?'));

        try(FileInputStream fis = new FileInputStream(inputPath);
            FileOutputStream fos = new FileOutputStream(outputPath)){

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if(!punctuation.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

