import java.util.Scanner;

public class TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] result = input.toCharArray();

        for (int i = 0; i < result.length; i++) {
            if (result[i] == '|') {
                int bombStart = i;
                int bombEnd = findBombEnd(result, bombStart + 1);

                String bombStr = extractBombStr(result, bombStart + 1);
                int bombRadius = calcBombRadius(bombStr);

                bombStart -= bombRadius;
                bombEnd += bombRadius;

                if (bombStart < 0) bombStart = 0;
                if (bombEnd >= result.length) bombEnd = result.length - 1;

                result = bombResult(result, bombStart, bombEnd);
            }
        }

        System.out.println(result);
    }

    static int calcBombRadius(String bomb) {
        char[] chars = bomb.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c;
        }
        return sum % 10;
    }

    static String extractBombStr(char[] target, int start) {
        StringBuilder bombStr = new StringBuilder("");
        for (int subInd = start; subInd < target.length; subInd++) {
            if (target[subInd] == '|') break;
            bombStr.append(target[subInd]);
        }
        return bombStr.toString();
    }

    static int findBombEnd(char[] target, int start) {
        int end = target.length - 1;
        for (int i = start; i < target.length; i++) {
            if (target[i] == '|') {
                end = i;
                break;
            }
        }
        return end;
    }

    static char[] bombResult(char[] target, int start, int end) {
        for (int i = start; i < target.length && i <= end; i++) {
            target[i] = '.';
        }
        return target;
    }
}

// de_dust2 |A| the best |BB|map!