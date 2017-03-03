import java.util.Scanner;

public class DiagonalDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            String[] numsRaw = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(numsRaw[col]);
            }
        }

        int primarySum = 0;
        int secondarySum = 0;

        for (int ind = 0; ind < size; ind++) {
            primarySum += matrix[ind][ind];
        }

        for (int ind = 0; ind < size; ind++) {
            secondarySum += matrix[ind][size - 1 - ind];
        }

//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
