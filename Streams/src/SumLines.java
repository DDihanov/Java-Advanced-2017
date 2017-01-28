import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Austin on 28/01/2017.
 */
public class SumLines {
    private final static String path = "/src/resources/input.txt";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;

        File someFile = new File(filePath);

        try (FileReader fileReader = new FileReader(someFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while(line != null){
                long sum = 0;

                for (char ch :
                        line.toCharArray()) {
                    sum+=ch;
                }

                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
