package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Austin on 27/01/2017.
 */
public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\streams\\Files-and-Streams\\Streams-and-Files\\input.txt";
        String outputPath = "C:\\streams\\Files-and-Streams\\Streams-and-Files\\output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if(oneByte == ' ' || oneByte == '\n'){
                    fos.write(oneByte);
                } else{
                    String toNumber = String.valueOf(oneByte);
                    for (char c :
                            toNumber.toCharArray()) {
                        fos.write(c);
                    }
                }

                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
