import java.io.*;

/**
 * Created by Austin on 28/01/2017.
 */
public class All_Capitals {
    private final static String path = "/src/resources/input.txt";
    private final static String outputPath = "/src/resources/output.txt";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String output = projectPath + outputPath;

        File someFile = new File(filePath);

        try (FileReader fileReader = new FileReader(someFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             PrintWriter printWriter = new PrintWriter(output)) {

            String line = bufferedReader.readLine();

            while(line != null){
                for (char ch :
                        line.toCharArray()) {
                    printWriter.write(Character.toUpperCase(ch));
                }

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
