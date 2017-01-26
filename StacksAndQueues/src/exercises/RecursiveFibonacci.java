package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        long result = 0;

        result = recurseCalc(0, 1, 0, n);

        System.out.println(result);
    }

    private static long recurseCalc(long nPrev, long nCurrent, int count, int limit) {
        if (count == limit) {
            return nCurrent;
        }
        long next = nPrev + nCurrent;
        count++;
        return recurseCalc(nCurrent, next, count, limit);
    }
}
