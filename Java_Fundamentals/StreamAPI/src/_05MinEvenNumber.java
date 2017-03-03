import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

/**
 * Created by Dihanov on 2/11/2017.
 */
public class _05MinEvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OptionalDouble min = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(x -> x%2==0)
                .min();
        
        
        if(min.isPresent()){
            System.out.printf("%.2f", min.getAsDouble());
        }else{
            System.out.println("No match");
        }


    }
}
