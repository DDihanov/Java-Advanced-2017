import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Austin on 28/01/2017.
 */
public class WordCount {
    private final static String inputPath = "/src/resources/input.txt";
    private final static String outputPath = "/src/resources/output.txt";
    private final static String wordsPath = "/src/resources/words.txt";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath + inputPath;
        String output = projectPath + outputPath;
        String words = projectPath + wordsPath;


        Map<String, Integer> resultsMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
             BufferedReader bufferedReader1 = new BufferedReader(new FileReader(words));
             PrintWriter printWriter = new PrintWriter(output)) {

            List<String> wordsList = Arrays.stream(bufferedReader1.readLine().split("\\s+"))
                                .collect(Collectors.toList());

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] wordsOnLine = line.split("\\s+");
                for (String word :
                        wordsOnLine) {
                    if(containsCaseInsensitive(wordsList, word)){
                        if (!resultsMap.containsKey(word)){
                            resultsMap.put(word, 1);
                        } else{
                            resultsMap.put(word, resultsMap.get(word)+1);
                        }
                    }
                }

                line = bufferedReader.readLine();
            }


            resultsMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                    .forEach(kvp -> printWriter.println(String.format("%s - %d\n", kvp.getKey(), kvp.getValue())));

//            for (Map.Entry<String, Integer> kvp:
//                    resultsMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
//                    .collect(Collectors.toList())) {
//                printWriter.println(String.format("%s - %d\n", kvp.getKey(), kvp.getValue()));
//            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean containsCaseInsensitive(List<String> searchList, String searchTerm)
    {
        for (String item : searchList)
        {
            if (item.equalsIgnoreCase(searchTerm))
                return true;
        }
        return false;
    }
}
