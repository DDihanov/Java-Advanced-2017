package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> textContainer = new ArrayDeque<>();
        textContainer.push("");

        int operations = Integer.valueOf(reader.readLine());
        for (int i = 0; i < operations; i++) {
            String cmdLine = reader.readLine();

            StringTokenizer commandTokens = new StringTokenizer(cmdLine);
            int cmd = Integer.valueOf(commandTokens.nextToken());
            String value = "";

            if (commandTokens.hasMoreTokens()) {
                value = commandTokens.nextToken();
            }

            StringBuilder text;
            int targetInd;
            switch (cmd) {
                case 1:
                    text = new StringBuilder(textContainer.peek());
                    text.append(value);
                    textContainer.push(text.toString());
                    break;
                case 2:
                    text = new StringBuilder(textContainer.peek());
                    targetInd = Integer.valueOf(value);
                    text.delete(text.length() - targetInd, text.length());
                    textContainer.push(text.toString());
                    break;
                case 3:
                    targetInd = Integer.valueOf(value) - 1;
                    System.out.println(textContainer.peek().charAt(targetInd));
                    break;
                case 4:
                    textContainer.pop();
            }
        }
    }
}
