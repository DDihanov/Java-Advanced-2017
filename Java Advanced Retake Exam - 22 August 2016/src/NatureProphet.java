import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NatureProphet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] garden = new int[dimensions[0]][dimensions[1]];

        ArrayList<int[]> indexes = new ArrayList<>();

        String input = "";

        while (!("Bloom Bloom Plow").equals(input = sc.nextLine())) {
            int[] coordinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            indexes.add(coordinates);
        }

        for (int[] index :
                indexes) {
            int x = index[0];
            int y = index[1];

            garden[x][y]--;

            for (int i = 0; i < garden[0].length; i++) {
                garden[x][i]++;
            }
            for (int i = 0; i < garden.length; i++) {
                garden[i][y]++;
            }
        }

        PrintMatrix(garden);
    }

    private static void PrintMatrix(int[][] matrix) {
        for (int[] ch : matrix) {
            for (int aCh : ch) {
                System.out.print(aCh + " ");
            }
            System.out.println();
        }
    }
}
