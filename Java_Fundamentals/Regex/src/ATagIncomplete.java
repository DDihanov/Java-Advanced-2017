import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATagIncomplete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        String line = "";
        while(!"END".equals(line = sc.nextLine())){
            sb.append(line);
        }

        Pattern pattern = Pattern.compile("(?:.)*(<a )href=[^>]+(>)[^<]+(<\\/a>)(?:.)+");

        Matcher matcher = pattern.matcher(sb.toString().trim());





        while(matcher.find()){
            sb.replace(matcher.start(1), matcher.end(1), "[URL ");
            matcher = pattern.matcher(sb.toString().trim());
            sb.replace(matcher.start(2), matcher.start(2), "]");
            matcher = pattern.matcher(sb.toString().trim());
            sb.replace(matcher.start(3), matcher.end(3), "[/URL]");
            matcher = pattern.matcher(sb.toString().trim());
        }

        System.out.println(sb.toString());
    }
}
