import java.util.ArrayList;
import java.util.Scanner;

public class GroupNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        ArrayList<ArrayList<String>> results = new ArrayList<>();
        results.add(0, new ArrayList<String>());
        results.add(1, new ArrayList<String>());
        results.add(2, new ArrayList<String>());

        for (String rawNum : input) {
            int currentNumber = Integer.parseInt(rawNum);
            results.get(Math.abs(currentNumber % 3)).add(String.valueOf(currentNumber));
        }

        for (ArrayList<String> line : results) {
            System.out.println(String.join(" ", line));
        }
    }
}
