

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static TreeMap<String, TreeSet<String>> USERS_IPS = new TreeMap<>();

    private static HashMap<String, Integer> USERS_DURATIONS = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input = CONSOLE.readLine();

        int logsCount = Integer.valueOf(input);
        for (int i = 0; i < logsCount; i++) {
            input = CONSOLE.readLine();

            StringTokenizer logData = new StringTokenizer(input);
            String ip = logData.nextToken();
            String user = logData.nextToken();
            Integer duration = Integer.valueOf(logData.nextToken());

            if (!USERS_IPS.containsKey(user))
                USERS_IPS.put(user, new TreeSet<>());

            if (!USERS_DURATIONS.containsKey(user))
                USERS_DURATIONS.put(user, 0);

            USERS_IPS.get(user).add(ip);

            Integer totalDuration = USERS_DURATIONS.get(user) + duration;
            USERS_DURATIONS.put(user, totalDuration);
        }

        StringBuilder output = new StringBuilder("");
        for (String user : USERS_IPS.keySet()) {
            output.append(String.format("%s: %s [", user, USERS_DURATIONS.get(user)));

            for (String ip : USERS_IPS.get(user))
                output.append(ip).append(", ");

            output.deleteCharAt(output.length() - 1);
            output.deleteCharAt(output.length() - 1);
            output.append("]").append("\n");
        }

        System.out.println(output);
    }
}