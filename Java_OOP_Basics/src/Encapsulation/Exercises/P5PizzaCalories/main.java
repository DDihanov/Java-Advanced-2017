package Encapsulation.Exercises.P5PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input = sc.readLine();
        try {
            String[] info = input.split("\\s+");

            if (info[0].equals("Dough")) {
                Dough dough = null;
                dough = new Dough(info[1].toLowerCase(), info[2].toLowerCase(), Double.parseDouble(info[3]));
                System.out.printf("%.2f\n", dough.getTotalCalories());

                info = sc.readLine().split("\\s+");
            }
            if (info[0].equals("END")) {
                return;
            }else if(info[0].equals("Topping")){
                String toppingType = info[1];
                double toppingWeight = Double.parseDouble(info[2]);

                Topping topping = null;
                topping = new Topping(toppingType, toppingWeight);
                System.out.printf("%.2f\n", topping.getToppingCalories());
                return;
            }

            Pizza pizza = null;
            String[] pizzaInfo = info;
            pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));

            Dough dough = null;
            info = sc.readLine().split("\\s+");
            dough = new Dough(info[1].toLowerCase(), info[2].toLowerCase(), Double.parseDouble(info[3]));
            pizza.setDough(dough);

            while(true) {
                String[] toppingInfo = sc.readLine().split("\\s+");
                if(toppingInfo[0].equals("END")){
                    break;
                }
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = null;
                topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getTotalCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
