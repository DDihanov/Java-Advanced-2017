import java.util.Arrays;
import java.util.Scanner;

public class P1Shockwave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        String input;

        while(!"Here We Go".equals(input = sc.nextLine())){
            int[] shockwave = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int beginRow = shockwave[0];
            int beginCol = shockwave[1];

            int endRow = shockwave[2];
            int endCol = shockwave[3];

            for (int i = beginRow; i <= endRow; i++) {
                for (int j = beginCol; j <= endCol; j++) {
                    matrix[i][j]++;
                }

            }
            
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
