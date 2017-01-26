package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SeqWithQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Long> queue = new ArrayDeque<>();

        Long n = Long.valueOf(reader.readLine());
        queue.offer(n);

        System.out.print(n + " ");

        int cycle = 1;
        int member = 2;

        while (member <= 50) {
            Long result;
            switch (cycle) {
                case 1:
                    result = queue.peekFirst() + 1;
                    System.out.print(result + " ");
                    queue.offer(result);
                    break;
                case 2:
                    result = (2 * queue.peekFirst()) + 1;
                    System.out.print(result + " ");
                    queue.offer(result);
                    break;
                case 3:
                    result = queue.peekFirst() + 2;
                    System.out.print(result + " ");
                    queue.offer(result);
                    queue.pollFirst();
                    break;
            }
            member++;
            cycle += 1;
            if (cycle > 3) cycle = 1;
        }
    }
}
