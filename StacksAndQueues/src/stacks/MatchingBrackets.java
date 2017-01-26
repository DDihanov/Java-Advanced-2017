package stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            char symbol = expression.charAt(index);
            if (symbol == '(') {
                stack.push(index);
            } else if (symbol == ')') {
                int startIndex = stack.pop();
                System.out.println(expression.substring(startIndex, index + 1));
            }
        }
    }
}
