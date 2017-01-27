package lab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Austin on 27/01/2017.
 */
public class Listing {
    public static void main(String[] args) {

        Path inPath = Paths.get("D:\\streams\\input.txt");
        Path outPath = Paths.get("D:\\streams\\output.txt");

        List<String> lines = null;
        try {
            lines = java.nio.file.Files.readAllLines(inPath);
            java.nio.file.Files.write(outPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
