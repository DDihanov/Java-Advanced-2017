import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Austin on 25/01/2017.
 */
public class TargetPratcice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String text = sc.nextLine();
        
        int[] coordinates = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        
        int Y = coordinates[0];
        int X = coordinates[1];
        int rad = coordinates[2];

        int row = input[0];
        int col = input[1];

        char[][] matrix = new char[row][col];

        FillMatrix(text, row, col, matrix);

        Bomb(Y, X, rad, matrix);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Gravity(matrix, j);
            }
        }

        PrintMatrix(matrix);

    }

    private static void PrintMatrix(char[][] matrix) {
        for (char[] ch : matrix) {
            for (int aCh : ch) {
                System.out.print((char)aCh + "");
            }
            System.out.println();
        }
    }

    private static void Gravity(char[][] matrix, int col){

        while (true){

            boolean hasFallen = false;

            for (int row = 1; row < matrix.length; row++) {
                char topChar = matrix[row-1][col];
                char curChar = matrix[row][col];

                if(curChar == ' ' && topChar != ' '){
                    matrix[row][col] = topChar;
                    matrix[row-1][col] = ' ';
                    hasFallen = true;
                }
            }

            if(!hasFallen){
                break;
            }
        }


    }

//    private static void Gravity(char[][] matrix) {
//        for (int i = 1; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[1].length; j++) {
//                char topChar = matrix[i - 1][j];
//                char curChar = matrix[i][j];
//                if (curChar == ' ' && topChar != ' ') {
//                    matrix[i][j] = topChar;
//                    matrix[i - 1][j] = ' ';
//                }
//            }
//        }
//    }
//
    private static void Bomb(int y, int x, int rad, char[][] matrix) {
        for (int mRow = 0; mRow < matrix.length; mRow++) {
            for (int mCol = 0; mCol < matrix[0].length; mCol++) {
                //(x-center_x)^2 + (y - center_y)^2 < radius^2
                if (Math.pow((mCol- x), 2) + Math.pow(mRow- y,2) <= Math.pow(rad,2)){
                    matrix[mRow][mCol] = ' ';
                }
            }
        }
    }

    private static void FillMatrix(String text, int row, int col, char[][] matrix) {
        int curPos = 0;

        for (int i = row - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = col-1; j >= 0; j--) {
                    if (curPos >= text.length()) {
                        curPos = 0;
                    }
                    matrix[i][j] = text.charAt(curPos);
                    curPos++;
                }
            } else {
                for (int j = 0; j < col; j++) {
                    if (curPos >= text.length()) {
                        curPos = 0;
                    }
                    matrix[i][j] = text.charAt(curPos);
                    curPos++;
                }
            }
        }
    }
}
