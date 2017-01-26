
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UserLogs {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static TreeMap<String, LinkedHashMap<String, Integer>> USER_LOGS = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            input = CONSOLE.readLine();

            if (input.equals("end"))
                break;

            StringTokenizer messageData = new StringTokenizer(input);

            String[] readData = new String[3];
            for (int i = 0; i < readData.length; i++) {
                StringTokenizer dataTokens = new StringTokenizer(messageData.nextToken(), "=");
                dataTokens.nextToken();

                readData[i] = dataTokens.nextToken();
            }

            String ip = readData[0];
            String message = readData[1];
            String user = readData[2];

            if (!USER_LOGS.containsKey(user))
                USER_LOGS.put(user, new LinkedHashMap<>());

            if (!USER_LOGS.get(user).containsKey(ip))
                USER_LOGS.get(user).put(ip, 0);

            Integer count = USER_LOGS.get(user).get(ip) + 1;
            USER_LOGS.get(user).put(ip, count);
        }

        StringBuilder output = new StringBuilder("");
        for (String name : USER_LOGS.keySet()) {
            output.append(name).append(":").append("\n");
            for (String ip : USER_LOGS.get(name).keySet()) {
                String ipOutput = String.format("%s => %s,", ip, USER_LOGS.get(name).get(ip));
                output.append(ipOutput).append(" ");
            }
            output.deleteCharAt(output.length() - 1);
            output.deleteCharAt(output.length() - 1);
            output.append(".").append("\n");
        }

        System.out.println(output);
    }
}
