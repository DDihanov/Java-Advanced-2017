package exercises;

import java.util.*;

public class CalcPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String postfix = InfixToPostfix.infixToPostfix(input);
        double result = evaluate(postfix);

        System.out.printf("%.2f%n", result);
    }

    private static double evaluate(String str)
    {
        Scanner sc = new Scanner(str);
        Deque<Double> stack = new ArrayDeque<>();

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                stack.push(sc.nextDouble());
                continue;
            }
            double b = stack.pop();
            double a = stack.pop();
            char op = sc.next().charAt(0);
            if      (op == '+') stack.push(a + b);
            else if (op == '-') stack.push(a - b);
            else if (op == '*') stack.push(a * b);
            else if (op == '/') stack.push(a / b);
            else if (op == '%') stack.push(a % b);
        }

        sc.close();
        return stack.pop();
    }
}
