import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSizes = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSizes[0]);
        int cols = Integer.parseInt(matrixSizes[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] tempRow = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(tempRow[col]);
            }
        }

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.printf("%d%n%d%n%d", rows, cols, sum);
    }
}
