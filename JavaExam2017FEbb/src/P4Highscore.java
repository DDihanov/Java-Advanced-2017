import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Austin on 19/02/2017.
 */
public class P4Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedList<String>> duels = new LinkedHashMap<>();
        HashMap<String, Long> hp = new HashMap<>();

        String input;

        while (!"osu!".equals(input = reader.readLine())) {
            String[] info = input.split("(<->|\\s)");

            String firstPlayer = info[1];
            String secondPlayer = info[2];

            long firstScore = Long.parseLong(info[0]);
            long secondScore = Long.parseLong(info[3]);

            long diff = firstScore - secondScore;

            if (!duels.containsKey(firstPlayer)) {
                duels.put(firstPlayer, new LinkedList<>());

                hp.put(firstPlayer, 0L);

            }
            if (!duels.containsKey(secondPlayer)) {
                duels.put(secondPlayer, new LinkedList<>());

                hp.put(secondPlayer, 0L);
            }
            
            System.out.println();

            if(diff>0){
                duels.get(firstPlayer).add(new String(String.format("*   %s <-> %d", secondPlayer, diff)));
                duels.get(secondPlayer).add(String.format("*   %s <-> %d", firstPlayer, 0 - diff));

                hp.put(firstPlayer, hp.get(firstPlayer) + Math.abs(diff));
                hp.put(secondPlayer, hp.get(secondPlayer) - Math.abs(diff));
            }else if(diff<0){
                duels.get(firstPlayer).add(new String(String.format("*   %s <-> %d", secondPlayer, diff)));
                duels.get(secondPlayer).add(String.format("*   %s <-> %d", firstPlayer, 0 - diff));

                hp.put(firstPlayer, hp.get(firstPlayer) - Math.abs(diff));
                hp.put(secondPlayer, hp.get(secondPlayer) + Math.abs(diff));
            }


        }

        System.out.println();

        duels.entrySet()
                .stream()
                .sorted((x,y) -> hp.get(y.getKey()).compareTo(hp.get(x.getKey())))
                .forEach(pair->{
                    System.out.printf("%s - (%d)\n", pair.getKey(), hp.get(pair.getKey()));
                    pair.getValue().forEach(d -> {
                        System.out.println(d);
                    });
                });
    }

    //pair.getValue().values().stream().reduce((v,z)->v.longValue()+z.longValue()).get()
}
