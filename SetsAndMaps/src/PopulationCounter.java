import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static Map<String, Map<String, Integer>> COUNTRIES_CITIES = new HashMap<>();

    private static Map<String, Long> COUNTRIES = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            input = CONSOLE.readLine();

            if (input.equals("report"))
                break;

            StringTokenizer cityData = new StringTokenizer(input, "|");

            String city = cityData.nextToken();
            String country = cityData.nextToken();
            Integer population = Integer.valueOf(cityData.nextToken());

            if (!COUNTRIES_CITIES.containsKey(country))
                COUNTRIES_CITIES.put(country, new LinkedHashMap<>());

            if (!COUNTRIES.containsKey(country))
                COUNTRIES.put(country, 0L);

            Long countryPopulation = COUNTRIES.get(country) + population;
            COUNTRIES.put(country, countryPopulation);

            COUNTRIES_CITIES.get(country).put(city, population);
        }

        COUNTRIES = sortByValue(COUNTRIES);

        for (String country : COUNTRIES_CITIES.keySet()) {
            Map<String, Integer> sortedCities = sortByValue(COUNTRIES_CITIES.get(country));
            COUNTRIES_CITIES.put(country, sortedCities);
        }

        StringBuilder output = new StringBuilder("");
        for (String country : COUNTRIES.keySet()) {
            output.append(
                    String.format("%s (total population: %s)", country, COUNTRIES.get(country)));
            output.append("\n");

            for (String city : COUNTRIES_CITIES.get(country).keySet()) {
                output.append(String.format("=>%s: %s", city, COUNTRIES_CITIES.get(country).get(city)));
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    // I did NOT write this method myself, so don't ask me how it works
    // *sigh* #wtfjava
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
