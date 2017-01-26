

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class SetsOfElements {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));
    private static LinkedHashSet<String> FIRST_SET = new LinkedHashSet<>();
    private static LinkedHashSet<String> SECOND_SET = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        String input = CONSOLE.readLine();

        StringTokenizer setSizes = new StringTokenizer(input);
        int firstSetSize = Integer.valueOf(setSizes.nextToken());
        int secondSetSize = Integer.valueOf(setSizes.nextToken());

        for (int i = 0; i < firstSetSize; i++) {
            input = CONSOLE.readLine();
            FIRST_SET.add(input);
        }

        for (int i = 0; i < secondSetSize; i++) {
            input = CONSOLE.readLine();
            SECOND_SET.add(input);
        }

        StringBuilder output = new StringBuilder("");
        for (String num : FIRST_SET)
            if (SECOND_SET.contains(num))
                output.append(num).append(" ");

        System.out.println(output);
    }
}
