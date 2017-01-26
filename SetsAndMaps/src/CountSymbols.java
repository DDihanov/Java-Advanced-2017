
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CountSymbols {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static TreeMap<Character, Integer> SYMBOLS_COUNTS = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        char[] symbols = CONSOLE.readLine().toCharArray();

        for (char symbol : symbols) {
            if (!SYMBOLS_COUNTS.containsKey(symbol)) {
                SYMBOLS_COUNTS.put(symbol, 1);
                continue;
            }

            Integer currentSymbolCount = SYMBOLS_COUNTS.get(symbol) + 1;
            SYMBOLS_COUNTS.put(symbol, currentSymbolCount);
        }

        StringBuilder output = new StringBuilder("");
        for (Character symbol : SYMBOLS_COUNTS.keySet()) {
            String outputLine = String.format("%s: %s time/s", symbol, SYMBOLS_COUNTS.get(symbol));
            output.append(outputLine).append("\n");
        }

        System.out.println(output);
    }
}
