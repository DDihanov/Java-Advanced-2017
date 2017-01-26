package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class StackFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        int limit = Integer.valueOf(reader.readLine());

        while (stack.size() <= limit + 1) {
            long current = stack.pop();
            long previous = stack.pop();

            long next = current + previous;

            stack.push(previous);
            stack.push(current);
            stack.push(next);
        }

        System.out.println(stack.pop());
    }
}
