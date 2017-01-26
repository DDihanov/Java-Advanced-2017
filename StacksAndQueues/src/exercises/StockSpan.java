package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.valueOf(reader.readLine());
        }

        calcSpan(prices, n);
    }

    private static void calcSpan(int[] prices, int n) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        StringBuilder builder = new StringBuilder();
        builder.append(1).append("\n");
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                builder.append(i - st.peek()).append("\n");
            } else {
                builder.append(i + 1).append("\n");
            }
            st.push(i);
        }

        System.out.println(builder.toString());
    }
}