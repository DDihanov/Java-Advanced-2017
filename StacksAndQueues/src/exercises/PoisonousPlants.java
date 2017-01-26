package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> previousPlantData = new ArrayDeque<>();

        int count = Integer.valueOf(reader.readLine());

        int[] plants = new int[count];
        StringTokenizer plantsInput = new StringTokenizer(reader.readLine());

        for (int i = 0; i < count; i++) {
            plants[i] = Integer.valueOf(plantsInput.nextToken());
        }

        int[] days = new int[plants.length];
        previousPlantData.push(0);
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (previousPlantData.size() > 0 && plants[previousPlantData.peek()] >= plants[x]) {
                maxDays = Integer.max(days[previousPlantData.pop()], maxDays);
            }
            if (previousPlantData.size() > 0) {
                days[x] = maxDays + 1;
            }
            previousPlantData.push(x);
        }

        Arrays.sort(days);
        int max = days[days.length-1];
        System.out.println(max);
    }
}
