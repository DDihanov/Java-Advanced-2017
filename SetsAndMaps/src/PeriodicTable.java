

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class PeriodicTable {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static TreeSet<String> ELEMENTS = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        String input = CONSOLE.readLine();

        int compoundsCount = Integer.valueOf(input);

        for (int i = 0; i < compoundsCount; i++) {
            input = CONSOLE.readLine();

            StringTokenizer compound = new StringTokenizer(input);
            while (compound.hasMoreTokens())
                ELEMENTS.add(compound.nextToken());
        }

        StringBuilder output = new StringBuilder("");
        for (String element : ELEMENTS)
            output.append(element).append(" ");

        System.out.println(output);
    }
}
