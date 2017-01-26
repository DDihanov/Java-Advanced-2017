import java.util.Scanner;

public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");
            matrix[row] = line;
        }

        int squares = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                String target = matrix[row][col];
                if (target.equals(matrix[row][col + 1])
                        && target.equals(matrix[row + 1][col])
                        && target.equals(matrix[row + 1][col + 1])) {
                    squares++;
                }
            }
        }

        System.out.println(squares);
    }
}
