package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] brackets = reader.readLine().toCharArray();

        if (brackets.length % 2 != 0) {
            System.out.println("NO");
            return;
        }

        Deque<Character> openBrackets = new ArrayDeque<>();
        boolean isBalanced = true;
        for (char bracket : brackets) {
            openBrackets.offer(bracket);
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                openBrackets.push(bracket);
            } else {
                char currentBracket = openBrackets.pop();
                if (bracket == '}') {
                    bracket = '{';
                }
                if (bracket == ']') {
                    bracket = '[';
                }
                if (bracket == ')') {
                    bracket = '(';
                }
                if (bracket != currentBracket) {
                    System.out.println("NO");
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        }
    }
}
