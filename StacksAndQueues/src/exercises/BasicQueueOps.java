package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BasicQueueOps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        TreeSet<Integer> container = new TreeSet<>();

        StringTokenizer commandTokenizer = new StringTokenizer(reader.readLine());
        StringTokenizer inputTokenizer = new StringTokenizer(reader.readLine());

        int offerLimit = Integer.valueOf(commandTokenizer.nextToken());
        for (int ind = 0; ind < offerLimit; ind++) {
            int val = Integer.valueOf(inputTokenizer.nextToken());
            queue.offer(val);
            container.add(val);
        }

        int pollLimit = Integer.valueOf(commandTokenizer.nextToken());
        for (int ind = 0; ind < pollLimit; ind++) {
            container.remove(queue.poll());
        }

        int queryNum = Integer.valueOf(commandTokenizer.nextToken());
        if (queue.contains(queryNum)) {
            System.out.println("true");
        } else {
            if (container.isEmpty()) {
                System.out.println(0);
                return;
            }
            System.out.println(container.first());
        }
    }
}
