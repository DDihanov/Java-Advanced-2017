
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Phonebook {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static HashMap<String, String> PHONE_BOOK = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input = CONSOLE.readLine();

        while (!input.equals("search")) {
            StringTokenizer entryData = new StringTokenizer(input, "-");

            String name = entryData.nextToken();
            String number = entryData.nextToken();

            PHONE_BOOK.put(name, number);

            input = CONSOLE.readLine();
        }

        StringBuilder output = new StringBuilder("");
        while (true) {
            input = CONSOLE.readLine();

            if (input.equals("stop"))
                break;

            String outputLine = String.format("Contact %s does not exist.", input);

            if (PHONE_BOOK.containsKey(input))
                outputLine = String.format("%s -> %s", input, PHONE_BOOK.get(input));

            output.append(outputLine).append("\n");
        }

        System.out.println(output);
    }
}
