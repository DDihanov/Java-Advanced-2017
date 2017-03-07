package Polymorphism.P03_WildFarm;

import Polymorphism.P03_WildFarm.models.animals.*;
import Polymorphism.P03_WildFarm.models.exceptions.NotEatingFoodException;
import Polymorphism.P03_WildFarm.models.food.Food;
import Polymorphism.P03_WildFarm.models.food.Meat;
import Polymorphism.P03_WildFarm.models.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        while (!"End".equals(input = sc.readLine())) {

            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = sc.readLine().split("\\s+");

            Animal animal = null;
            Food food = null;

            animal = makeAnimal(animalInfo);
            food = makeFood(foodInfo);

            try {
                animal.makeSound();
                animal.eat(food);
            } catch (NotEatingFoodException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(animal.toString());
        }
    }

    private static Food makeFood(String[] foodInfo) {
        String type = foodInfo[0];
        int quantity = Integer.parseInt(foodInfo[1]);

        switch (type) {
            case "Vegetable":
                Food vegetable = new Vegetable(quantity);
                return vegetable;
            case "Meat":
                Food meat = new Meat(quantity);
                return meat;
        }

        return null;
    }

    private static Animal makeAnimal(String[] info) {
        String type = info[0];
        String name = info[1];
        double weight = Double.valueOf(info[2]);
        String livingRegion = info[3];

        if (type.equals("Cat")) {
            String breed = info[4];
            Animal cat = new Cat(name, weight, livingRegion, breed);

            return cat;
        } else {
            switch (info[0]) {
                case "Mouse":
                    Animal mouse = new Mouse(name, weight, livingRegion);
                    return mouse;
                case "Zebra":
                    Animal zebra = new Zebra(name, weight, livingRegion);
                    return zebra;
                case "Tiger":
                    Animal tiger = new Tiger(name, weight, livingRegion);
                    return tiger;
                default:
                    return null;
            }
        }
    }
}
