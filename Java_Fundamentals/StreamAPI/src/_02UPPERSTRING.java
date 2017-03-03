import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dihanov on 2/11/2017.
 */
public class _02UPPERSTRING {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("\\s+");
        
        Arrays.stream(arr)
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));
    }
}
