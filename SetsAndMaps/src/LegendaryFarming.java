import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static HashSet<String> USABLE = new HashSet<>();

    private static Map<String, Integer> MATERIALS = new LinkedHashMap<>();

    private static TreeMap<String, Integer> JUNK = new TreeMap<>();

    static {
        USABLE.add("shards");
        USABLE.add("fragments");
        USABLE.add("motes");

        MATERIALS.put("shards", 0);
        MATERIALS.put("fragments", 0);
        MATERIALS.put("motes", 0);
    }

    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder output = new StringBuilder("");
        boolean gotLegendary = false;

        while (!gotLegendary) {
            input = CONSOLE.readLine();

            if (input == null)
                break;

            StringTokenizer materials = new StringTokenizer(input);

            while (materials.hasMoreTokens()) {
                Integer amount = Integer.valueOf(materials.nextToken());
                String material = materials.nextToken().toLowerCase();

                if (USABLE.contains(material)) {
                    if (!MATERIALS.containsKey(material))
                        MATERIALS.put(material, 0);

                    Integer currentAmount = MATERIALS.get(material) + amount;

                    if (!gotLegendary) {
                        if (material.equals("shards")) {
                            if (currentAmount >= 250) {
                                output.append("Shadowmourne obtained!").append("\n");
                                gotLegendary = true;
                            }
                        } else if (material.equals("fragments")) {
                            if (currentAmount >= 250) {
                                output.append("Valanyr obtained!").append("\n");
                                gotLegendary = true;
                            }
                        } else if (material.equals("motes")) {
                            if (currentAmount >= 250) {
                                output.append("Dragonwrath obtained!").append("\n");
                                gotLegendary = true;
                            }
                        }
                        if (gotLegendary)
                            currentAmount -= 250;
                    }

                    MATERIALS.put(material, currentAmount);

                } else {
                    if (!JUNK.containsKey(material))
                        JUNK.put(material, 0);

                    Integer newJunkAmount = JUNK.get(material) + amount;
                    JUNK.put(material, newJunkAmount);
                }

                if (gotLegendary)
                    break;
            }
        }

        MATERIALS = sortByKeyAndVal(MATERIALS);
        for (String material : MATERIALS.keySet()) {
            String outputLine = String.format("%s: %s", material, MATERIALS.get(material));
            output.append(outputLine).append("\n");
        }

        for (String junk : JUNK.keySet()) {
            String outputLine = String.format("%s: %s", junk, JUNK.get(junk));
            output.append(outputLine).append("\n");
        }

        System.out.println(output);
    }

    private static LinkedHashMap<String, Integer> sortByKeyAndVal(Map<String, Integer> map) {
        Comparator<Map.Entry<String, Integer>> valueComparator = (e1, e2) -> {
            String name1 = e1.getKey();
            String name2 = e2.getKey();

            Integer val1 = e1.getValue();
            Integer val2 = e2.getValue();

            if (!val1.equals(val2)) {
                return val2 - val1;
            }

            return name1.compareTo(name2);
        };


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<>(entries);

        listOfEntries.sort(valueComparator);

        LinkedHashMap<String, Integer> sortedByKeyAndValue = new LinkedHashMap<>(listOfEntries.size());

        for(Map.Entry<String, Integer> entry : listOfEntries){
            sortedByKeyAndValue.put(entry.getKey(), entry.getValue());
        }

        return sortedByKeyAndValue;
    }
}
