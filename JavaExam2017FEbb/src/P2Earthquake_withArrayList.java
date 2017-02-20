import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class P2Earthquake_withArrayList {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int wavesCount = Integer.parseInt(sc.readLine());


        ArrayDeque<ArrayList<Integer>> waves = new ArrayDeque<>();

        LinkedList<Integer> activities = new LinkedList<>();


        for (int i = 0; i < wavesCount; i++) {
            ArrayList<Integer> wav = new ArrayList<>();
            String[] cmd = sc.readLine().split("\\s+");

            for (int j = 0; j < cmd.length; j++) {
                wav.add(Integer.parseInt(cmd[j]));
            }

            waves.add(wav);
        }

        while(!waves.isEmpty()){
            ArrayList<Integer> currentWave = waves.peek();

            if(currentWave.size() == 1){
                activities.add(currentWave.get(0));
                waves.pop();
            }

            for (int i = 0; i < currentWave.size()-1; i++) {
                int current = currentWave.get(i);
                int next = currentWave.get(i+1);
                if(current < next){
                    activities.add(current);
                    currentWave.remove(i);
                    waves.addLast(waves.pop());
                    break;
                }else{
                    currentWave.remove(i+1);
                    i--;
                }
            }
        }

        System.out.println(activities.size());
        for (int i :
                activities) {
            System.out.print(i + " ");
        }
    }
}