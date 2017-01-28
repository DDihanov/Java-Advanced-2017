import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Austin on 28/01/2017.
 */
public class CountCharTypes {
    private final static String path = "/src/resources/input.txt";
    private final static String outputPath = "/src/resources/output.txt";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String output = projectPath + outputPath;

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashSet<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

        int vowelsCount = 0;
        int consonants = 0;
        int punctuationCount = 0;

        File someFile = new File(filePath);

        try (FileReader fileReader = new FileReader(someFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             PrintWriter printWriter = new PrintWriter(output)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                for (char ch :
                        line.toCharArray()) {
                    if (vowels.contains(ch)) {
                        vowelsCount++;
                    } else if (punctuation.contains(ch)) {
                        punctuationCount++;
                    } else if(ch != ' '){
                        consonants++;
                    }
                }

                line = bufferedReader.readLine();
            }


            String format = String.format("Vowels: %d\r\n" +
                    "Consonants: %d\r\n" +
                    "Punctuation: %d", vowelsCount, consonants, punctuationCount);


            printWriter.println(format);
            System.out.println(format);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
