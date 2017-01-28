import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Austin on 28/01/2017.
 */
public class MergeTwoFiles {
    private final static String path1 = "/src/resources/input1.txt";
    private final static String path2 = "/src/resources/input2.txt";
    private final static String outputPath = "/src/resources/output.txt";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String filePath1 = projectPath + path1;
        String filePath2 = projectPath + path2;
        String output = projectPath + outputPath;

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(filePath2));
             PrintWriter printWriter = new PrintWriter(output)) {

            ArrayList<String> outputList = new ArrayList<>();
            String line = bufferedReader1.readLine();

            while (line != null) {
                outputList.add(line);
                line = bufferedReader1.readLine();
            }

            line = bufferedReader2.readLine();
            while (line != null) {
                outputList.add(line);
                line = bufferedReader2.readLine();
            }

            for (String st :
                    outputList) {
                printWriter.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
