

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class UniqueUserNames {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));
    private static LinkedHashSet<String> USERNAMES = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        int usersCount = Integer.valueOf(CONSOLE.readLine());

        for (int i = 0; i < usersCount; i++)
            USERNAMES.add(CONSOLE.readLine());

        StringBuilder output = new StringBuilder("");
        for (String username : USERNAMES)
            output.append(username).append("\n");

        System.out.println(output);
    }
}
