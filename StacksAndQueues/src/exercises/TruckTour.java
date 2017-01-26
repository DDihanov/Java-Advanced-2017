package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Pump> pumps = new ArrayDeque<>();

        int pumpsCount = Integer.valueOf(reader.readLine());
        for (int i = 0; i < pumpsCount; i++) {
            StringTokenizer pumpData = new StringTokenizer(reader.readLine());
            long capacity = Long.valueOf(pumpData.nextToken());
            long distance = Long.valueOf(pumpData.nextToken());

            Pump newPump = new Pump(capacity, distance, i);
            pumps.offer(newPump);
        }

        int startInd = 0;

        boolean success = false;
        while (!success) {
            Pump currentPump;
            Truck truck = new Truck();

            while (!pumps.isEmpty()) {
                currentPump = pumps.poll();

                if (!truck.travelling) {
                    startInd = currentPump.index;
                }

                if (truck.travelling && currentPump.index == startInd) {
                    success = true;
                    break;
                }

                // Truck fuels up and preps for travel
                truck.fuel += currentPump.capacity;
                truck.travelling = true;

                // Reset if out of gas before goal
                if (truck.fuel < currentPump.distToNext) {
                    break;
                }

                // Truck travels
                truck.fuel -= currentPump.distToNext;

                pumps.offer(currentPump);
            }
        }

        System.out.println(startInd);
    }
}

class Truck {
    long fuel;
    boolean travelling;

    Truck() {
        this.fuel = 0;
        this.travelling = false;
    }
}

class Pump {
    long capacity;
    long distToNext;
    int index;

    Pump(long capacity, long distToNext, int index) {
        this.capacity = capacity;
        this.distToNext = distToNext;
        this.index = index;
    }
}