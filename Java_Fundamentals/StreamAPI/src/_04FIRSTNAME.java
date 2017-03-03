import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Dihanov on 2/11/2017.
 */
public class _04FIRSTNAME {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("\\s+");

        HashSet<Character> letters = new HashSet<>();

        Stream.of(sc.nextLine().split("\\s+"))
                .map(c -> c.toLowerCase().charAt(0))
                .forEach(c -> letters.add(c));

        Optional<String> st;

        st = Arrays.stream(arr)
                .sorted()
                .filter(c -> letters.contains(c.toLowerCase().charAt(0)))
                .findFirst();
        
        if(st.isPresent()){
            System.out.println(st.get());
        }else{
            System.out.println("No match");
        }
    }
}
