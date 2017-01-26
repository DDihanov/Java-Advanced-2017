package stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> reversed = new ArrayDeque<>();
        for (Character c : input.toCharArray()) {
            reversed.push(c);
        }

        while (!reversed.isEmpty()) {
            System.out.print(reversed.pop());
        }
    }
}
