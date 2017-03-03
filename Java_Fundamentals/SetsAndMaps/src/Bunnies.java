import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Austin on 26/01/2017.
 */
public class Bunnies {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        boolean isWinner = false;
        boolean isDead = false;

        int rowOfPlayer = 0;
        int colOfPlayer = 0;

        char[][] lair = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            String elements = sc.nextLine();

            if (elements.contains("P")) {
                colOfPlayer = elements.indexOf('P');
                rowOfPlayer = i;
            }

            lair[i] = elements.toCharArray();
        }


        char[] commands = sc.nextLine().toCharArray();

        for (int i = 0; i < commands.length; i++) {
            char command = commands[i];
            switch (command) {
                case 'U':
                    if(rowOfPlayer - 1 < 0){
                        isWinner = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        break;
                    } else if(lair[rowOfPlayer-1][colOfPlayer] == 'B'){
                        isDead = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        rowOfPlayer--;
                        break;
                    }else{
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        lair[rowOfPlayer-1][colOfPlayer] = 'P';

                        rowOfPlayer--;
                        break;
                    }
                case 'D':
                    if(rowOfPlayer + 1 > rows-1){
                        isWinner = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        break;
                    } else if(lair[rowOfPlayer+1][colOfPlayer] == 'B'){
                        isDead = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        rowOfPlayer++;
                        break;
                    }else{
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        lair[rowOfPlayer+1][colOfPlayer] = 'P';

                        rowOfPlayer++;
                        break;
                    }
                case 'L':
                    if(colOfPlayer - 1 < 0){
                        isWinner = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        break;
                    } else if(lair[rowOfPlayer][colOfPlayer-1] == 'B'){
                        isDead = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        colOfPlayer--;
                        break;
                    }else{
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        lair[rowOfPlayer][colOfPlayer-1] = 'P';

                        colOfPlayer--;
                        break;
                    }
                case 'R':
                    if(colOfPlayer + 1 > cols-1){
                        isWinner = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        break;
                    } else if(lair[rowOfPlayer][colOfPlayer+1] == 'B'){
                        isDead = true;
                        lair[rowOfPlayer][colOfPlayer] = '.';

                        colOfPlayer++;
                        break;
                    }else{
                        lair[rowOfPlayer][colOfPlayer] = '.';
                        lair[rowOfPlayer][colOfPlayer+1] = 'P';

                        colOfPlayer++;
                        break;
                    }
                default:
                    break;
            }

            lair = bunnyfyFirst(rows, cols, lair);
            if(lair[rowOfPlayer][colOfPlayer] != 'P'){
                isDead = true;
            }

            }




        if(isWinner){
            PrintMatrix(lair);
            System.out.println(String.format("won: %d %d", rowOfPlayer, colOfPlayer));
        }else if(isDead){
            PrintMatrix(lair);
            System.out.println(String.format("dead: %d %d", rowOfPlayer, colOfPlayer));
        }
    }

    private static char[][] bunnyfyFirst(int rows, int cols, char[][] lair) {

        char[][] temp = new char[lair.length][lair[0].length];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(lair[row][col] == 'B') {
                    int leftSpread = Math.max(0, col - 1);
                    int rightSpread = Math.min(col + 1, cols - 1);
                    int upSpread = Math.max(0, row - 1);
                    int downSpread = Math.min(row + 1, rows - 1);

                    temp[row][col] = 'B';
                    temp[upSpread][col] = 'B';
                    temp[downSpread][col] = 'B';
                    temp[row][leftSpread] = 'B';
                    temp[row][rightSpread] = 'B';

                } else if(lair[row][col] == 'P'){
                    temp[row][col] = 'P';
                }else if(temp[row][col] == 0){
                    temp[row][col] = '.';
                }
            }
        }

        return temp;
    }

//    private static void bunnyfy(int y, int x, char[][] matrix) {
//        for (int mRow = 0; mRow < matrix.length; mRow++) {
//            for (int mCol = 0; mCol < matrix[0].length; mCol++) {
//                //(x-center_x)^2 + (y - center_y)^2 < radius^2
//                if (Math.pow((mCol- x), 2) + Math.pow(mRow- y,2) <= 1){
//                    matrix[mRow][mCol] = 'B';
//                }
//            }
//        }
//    }

    private static void PrintMatrix(char[][] matrix) {
        for (char[] ch : matrix) {
            for (int aCh : ch) {
                System.out.print((char)aCh + "");
            }
            System.out.println();
        }
    }
}
