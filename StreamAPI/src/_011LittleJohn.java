import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dihanov on 2/12/2017.
 */
public class _011LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        int largeArrows = 0;
        int mediumArrows = 0;
        int smallArrows = 0;
        Pattern pattern = Pattern.compile("(>-{5}>)|(>>-{5}>)|(>>>-{5}>>)");

        for (int i = 0; i < 4; i++) {
            line = bf.readLine();
            Matcher m = pattern.matcher(line);

            while(m.find()){
                if(m.group(3)!=null){
                    largeArrows++;
                }else if(m.group(2)!=null){
                    mediumArrows++;
                }else if(m.group(1)!=null){
                    smallArrows++;
                }
            }
        }

        String concat = String.valueOf(smallArrows) + String.valueOf(mediumArrows) + String.valueOf(largeArrows);

        String initial = Integer.toBinaryString(Integer.parseInt(concat));

        String reversed = new StringBuilder(initial).reverse().toString();

        System.out.println(Integer.parseInt(initial+reversed, 2));


    }
}
