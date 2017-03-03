import java.util.Scanner;

public class CollectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[4][];
        for (int row = 0; row < 4; row++) {
            matrix[row] = scanner.nextLine().split("");
        }

        String[] commands = scanner.nextLine().split("");

        int currentRow = 0;
        int currentCol = 0;

        int collectedCoins = 0;
        int wallsHit = 0;

        if (matrix[0][0].equals("$")) {
            collectedCoins++;
        }

        for (String command : commands) {
            String token = "";
            //System.out.println("Command is " + command);
            if (command.equals(">")) {
                try {
                    currentCol += 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    //System.out.println(e);

                    currentCol--;
                    wallsHit++;
                }
            } else if (command.equals("<")) {
                try {
                    currentCol -= 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    //System.out.println(e);

                    currentCol++;
                    wallsHit++;
                }
            } else if (command.equals("V")) {
                try {
                    currentRow += 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    //System.out.println(e);

                    currentRow--;
                    wallsHit++;
                }
            } else if (command.equals("^")) {
                try {
                    currentRow -= 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    //System.out.println(e);

                    currentRow++;
                    wallsHit++;
                }
            }
            //System.out.println("Token is " + token);
            if (token.equals("$")) {
                collectedCoins++;
                //System.out.println("Got coin");
            }
            token = "";
            //System.out.println("---------------");
        }

        System.out.println("Coins = " + collectedCoins);
        System.out.println("Walls = " + wallsHit);
    }
}

/*
Sj0u$hbc
$87yihc87
Ewg3444
$4$$
V>>^^>>>VVV<<
 */