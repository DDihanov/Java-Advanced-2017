import java.util.Scanner;

public class MaxSubmatrixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSizes = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSizes[0]);
        int cols = Integer.parseInt(matrixSizes[1]);

        int[][] numbers = new int[rows][cols];

        for (int row = 0; row < numbers.length; row++) {
            String[] tempRow = scanner.nextLine().split(", ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = Integer.parseInt(tempRow[col]);
            }
        }

        int sumMax = Integer.MIN_VALUE;

        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < numbers.length - 1; row++) {
            for (int col = 0; col < numbers[row].length - 1; col++) {
                int currentSum = numbers[row][col]
                                + numbers[row][col + 1]
                                + numbers[row + 1][col]
                                + numbers[row + 1][col + 1];

                if (currentSum > sumMax) {
                    sumMax = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.printf("%d %d%n%d %d%n%d",
                numbers[startRow][startCol],
                numbers[startRow][startCol + 1],
                numbers[startRow + 1][startCol],
                numbers[startRow + 1][startCol + 1],
                sumMax);
    }
}
