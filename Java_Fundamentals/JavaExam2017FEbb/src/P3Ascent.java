import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P3Ascent {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("([_|,]{1})([a-zA-Z]{1,})([0123456789]){1}");

        LinkedHashMap<String, String> matches = new LinkedHashMap<>();

        String input;

        while (!"Ascend".equals(input = reader.readLine())) {

            for (Map.Entry<String, String> match :
                    matches.entrySet()) {
                input = input.replaceAll(match.getKey(), match.getValue());
            }

            Matcher m = p.matcher(input);
            while (m.find()) {
                String match = m.group(0);
                String type = m.group(1);
                String text = m.group(2);
                int value = Integer.parseInt(m.group(3));

                String decoded = decode(text, type, value);

                matches.put(match, decoded);


                input = input.replace(match, decoded);
                m = p.matcher(input);
            }

            System.out.println(input);
        }

    }

    public static String decode(String text, String type, int value) {
        StringBuilder sb = new StringBuilder();

        switch (type) {
            case "_":
                for (char c :
                        text.toCharArray()) {
                    sb.append((char) (c - value));
                }
                break;
            case ",":
                for (char c :
                        text.toCharArray()) {
                    sb.append((char) (c + value));
                }
                break;
            default:
                break;

        }

        return sb.toString();
    }
}