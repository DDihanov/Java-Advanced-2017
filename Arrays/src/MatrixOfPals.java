import java.util.Scanner;

public class MatrixOfPals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String[] input = scanner.nextLine().split("[, ]");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.format("%s%s%s", alphabet[row], alphabet[col + row], alphabet[row]);
            }
        }

        for (String[] strings : matrix) {
            System.out.println(String.join(" ", strings));
        }
    }
}
