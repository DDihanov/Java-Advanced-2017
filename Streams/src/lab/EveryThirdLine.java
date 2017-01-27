package lab;

import java.io.*;

/**
 * Created by Austin on 27/01/2017.
 */
public class EveryThirdLine {
    public static void main(String[] args) {

        String inputPath = "D:\\streams\\input.txt";
        String outputPath = "D:\\streams\\output.txt";

        int counter = 1;

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {

            String line = in.readLine();

            while(line != null){
                if(counter % 3 == 0){
                    pw.write(line);
                    System.out.println(line);
                }
                line = in.readLine();
                counter++;
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
