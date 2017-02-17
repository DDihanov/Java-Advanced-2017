import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dihanov on 2/17/2017.
 */
public class P03_TextTransformer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pattern p = Pattern.compile("([$%&'])([^$%&']+)\\1");

        StringBuilder sb = new StringBuilder();

        String input;

        while (!"burp".equals(input = sc.nextLine())) {
            sb.append(input);
        }

        String text = sb.toString().replaceAll("\\s+", " ");
        Matcher m = p.matcher(text);

        StringBuilder result = new StringBuilder();

        while (m.find()) {
            int weight;
            char c = m.group(0).charAt(0);
            String match = m.group(2);

            switch (c) {
                case '$':
                    result.append(decipher(match, 1));
                    break;
                case '%':
                    result.append(decipher(match, 2));
                    break;
                case '&':
                    result.append(decipher(match, 3));
                    break;
                case '\'':
                    result.append(decipher(match, 4));
                    break;
                default:
                    break;

            }
        }

        System.out.println(result.toString().trim());
    }

    public static StringBuilder decipher(String str, int weight) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (char ch :
                str.toCharArray()) {
            if (counter % 2 == 0) {
                sb.append((char) (ch + weight));
            } else {
                sb.append((char) (ch - weight));
            }

            counter++;
        }

        sb.append(" ");

        return sb;
    }
}
