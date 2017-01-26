package exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] commands = scanner.nextLine().split("\\s+");
        String[] input = scanner.nextLine().split("\\s+");

        for (int commandIndex = 0; commandIndex < commands.length; commandIndex++) {
            switch (commandIndex) {
                case 0:
                    for (int i = 0; i < Integer.valueOf(commands[0]); i++) {
                        stack.push(Integer.valueOf(input[i]));
                    }
                    break;
                case 1:
                    for (int i = 0; i < Integer.valueOf(commands[1]); i++) {
                        stack.pop();
                    }
                    break;
                case 2:
                    if (stack.contains(Integer.valueOf(commands[2]))) {
                        System.out.println("true");
                    } else {
                        if (stack.isEmpty()) {
                            System.out.println(0);
                            return;
                        }
                        System.out.println(Collections.min(stack));
                    }
            }
        }
    }
}
