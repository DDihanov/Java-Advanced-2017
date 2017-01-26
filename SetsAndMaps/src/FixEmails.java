

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FixEmails {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static LinkedHashMap<String, String> USERS_EMAILS = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            input = CONSOLE.readLine();

            if (input.equals("stop"))
                break;

            String email = CONSOLE.readLine();

            String checkMail = email.toLowerCase();

            if (checkMail.endsWith(".us") || checkMail.endsWith(".uk") || checkMail.endsWith(".com"))
                continue;

            USERS_EMAILS.put(input, email);
        }

        StringBuilder output = new StringBuilder("");
        for (String name : USERS_EMAILS.keySet()) {
            String outputLine = String.format("%s -> %s", name, USERS_EMAILS.get(name));
            output.append(outputLine).append("\n");
        }

        System.out.println(output);
    }
}
