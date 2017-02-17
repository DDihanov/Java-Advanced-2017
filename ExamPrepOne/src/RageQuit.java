import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dihanov on 2/17/2017.
 */
public class RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim();

        Pattern p = Pattern.compile("(\\D+)(\\d+)");

        Matcher m = p.matcher(input);

        HashSet<Character> unique = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        while(m.find()){
            int count = Integer.parseInt(m.group(2));
            String msg = m.group(1).toUpperCase();

            if(count != 0){
                for (int i = 0; i < count; i++) {
                    sb.append(msg);
                }

                for (char c :
                        msg.toCharArray()) {
                    unique.add(Character.toUpperCase(c));
                }
            }


        }

        System.out.printf("Unique symbols used: %d\n", unique.size());
        System.out.println(sb.toString());
    }
}
