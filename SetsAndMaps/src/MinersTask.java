

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class MinersTask {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static LinkedHashMap<String, Integer> RESOURCES_AMOUNTS = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            input = CONSOLE.readLine();

            if (input.equals("stop"))
                break;

            String name = input;
            Integer amount = Integer.valueOf(CONSOLE.readLine());

            if (!RESOURCES_AMOUNTS.containsKey(name)) {
                RESOURCES_AMOUNTS.put(name, amount);
                continue;
            }

            Integer newAmount = RESOURCES_AMOUNTS.get(name) + amount;

            RESOURCES_AMOUNTS.put(name, newAmount);
        }

        StringBuilder output = new StringBuilder("");
        for (String name : RESOURCES_AMOUNTS.keySet()) {
            String outputLine = String.format("%s -> %s", name, RESOURCES_AMOUNTS.get(name));
            output.append(outputLine).append("\n");
        }

        System.out.println(output);
    }
}
