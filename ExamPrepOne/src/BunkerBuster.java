import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BunkerBuster {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(sc.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int destroyedCells = 0;

        int[][] matrix = new int[rows][cols];

        fillMatrix(sc, rows, cols, matrix);

        String input = "";

        while (!"cease fire!".equals(input = sc.readLine())) {
            String[] bombInfo = input.split("\\s+");

            int row = Integer.parseInt(bombInfo[0]);
            int col = Integer.parseInt(bombInfo[1]);
            int damage = (int) bombInfo[2].charAt(0);

            if (damage % 2 != 0) {
                damage = damage / 2 + 1;
            } else {
                damage /= 2;
            }

            matrix[row][col]-=damage;

            int tempCol = col - 1;
            int tempRow = row - 1;

            bombMatrix(matrix, col, damage, tempCol, tempRow);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]<=0){
                    destroyedCells++;
                }
            }
        }



        System.out.printf("Destroyed bunkers: %d\n", destroyedCells);
        System.out.printf("Damage done: %.1f %%", 100.0 * destroyedCells / (rows * cols));
    }

    private static void bombMatrix(int[][] matrix, int col, int damage, int tempCol, int tempRow) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try{
                    matrix[tempRow][tempCol] -= damage;
                }catch(IndexOutOfBoundsException ex){}
                tempCol++;
            }
            tempCol = col - 1;
            tempRow++;
        }
    }

    private static void fillMatrix(BufferedReader sc, int rows, int cols, int[][] matrix) throws IOException {
        for (int i = 0; i < rows; i++) {
            int[] values = Arrays.stream(sc.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = values[j];
            }
        }
    }

}
