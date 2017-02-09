import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([^?=&]+)=([^?=&]+)");

        String input = sc.nextLine();
        while (!"END".equals(input)) {
            input = input.replaceAll("\\+", " ");
            input = input.replaceAll("%20", " ");
            input = input.replaceAll("\\s+", " ");


            Matcher matcher = pattern.matcher(input);
            LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap();

            while (matcher.find()) {
                String field = matcher.group(1).trim();
                String value = matcher.group(2).trim();

                if (!linkedHashMap.containsKey(field)) {
                    linkedHashMap.put(field, new ArrayList<>());
                }
                linkedHashMap.get(field).add(value);
            }

            input = sc.nextLine();
            linkedHashMap.entrySet().stream().forEach(a -> {
                System.out.print(a.getKey() + "=" + a.getValue());
            });
            System.out.println();
        }
    }
}