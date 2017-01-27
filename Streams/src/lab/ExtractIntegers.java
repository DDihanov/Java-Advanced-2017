package lab;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Austin on 27/01/2017.
 */
public class ExtractIntegers {
    public static void main(String[] args) {

        String inputPath = "D:\\streams\\input.txt";
        String outputPath = "D:\\streams\\output.txt";

        try (Scanner sc = new Scanner(new FileInputStream(inputPath));
             PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    pw.write(sc.nextInt());
                    System.out.println(sc.nextInt());
                }

                sc.next();
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
