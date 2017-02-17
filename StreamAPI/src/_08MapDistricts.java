import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Dihanov on 2/11/2017.
 */
public class _08MapDistricts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, List<Integer>> cities = new HashMap<>();

        Stream.of(sc.nextLine().split("\\s+"))
                .forEach(s -> {
                    String[] info = s.split(":");

                    String city = info[0];
                    Integer distPop = Integer.parseInt(info[1]);

                    if (!cities.containsKey(city)) {
                        cities.put(city, new ArrayList<>());
                        cities.get(city).add(distPop);
                    } else {
                        cities.get(city).add(distPop);
                    }
                });

        int minPop = Integer.parseInt(sc.nextLine());

        cities.entrySet().stream()
                .filter(c1 -> c1.getValue().stream().collect(Collectors.summingInt(Integer::valueOf)) > minPop)
                .sorted((c1,c2)->
                        Integer.compare(c2.getValue().stream().mapToInt(x->Integer.valueOf(x)).sum(),
                                c1.getValue().stream().mapToInt(z->Integer.valueOf(z)).sum()))
                .forEach(kvp -> {
                    System.out.print(kvp.getKey() + ": ");
                    kvp.getValue()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(c -> System.out.printf("%d ", c));

                    System.out.print("\n");

                });

    }
}
