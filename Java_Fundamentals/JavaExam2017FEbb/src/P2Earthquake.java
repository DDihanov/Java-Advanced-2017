import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class P2Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int wavesCount = Integer.parseInt(sc.readLine());


        ArrayDeque<ArrayDeque<Integer>> waves = new ArrayDeque<>();

        ArrayList<Integer> activities = new ArrayList<>();


        for (int i = 0; i < wavesCount; i++) {
            ArrayDeque<Integer> wav = new ArrayDeque<>();
            String[] cmd = sc.readLine().split("\\s+");

            for (int j = 0; j < cmd.length; j++) {
                wav.add(Integer.parseInt(cmd[j]));
            }

            waves.add(wav);
        }

        while (!waves.isEmpty()) {
            ArrayDeque<Integer> currentWave = waves.peek();

            while (currentWave.size() > 1) {
                int currentEl = currentWave.pop();
                int nextEl = currentWave.peek();

                if (currentEl < nextEl) {
                    activities.add(currentEl);
                    waves.addLast(waves.pop());
                    currentWave = waves.peek();
                }else{
                    currentWave.pop();
                    currentWave.addFirst(currentEl);
                }
            }

            activities.add(currentWave.pop());
            waves.removeFirst();
        }


        System.out.println(activities.size());
        for (int i :
                activities) {
            System.out.print(i + " ");
        }
    }
}