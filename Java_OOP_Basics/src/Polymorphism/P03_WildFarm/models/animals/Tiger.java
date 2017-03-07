package Polymorphism.P03_WildFarm.models.animals;

import Polymorphism.P03_WildFarm.models.exceptions.NotEatingFoodException;
import Polymorphism.P03_WildFarm.models.food.Food;

public class Tiger extends Felime {
    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(!food.getType().equals("Meat")){
            throw new NotEatingFoodException("Tigers are not eating that type of food!");
        }

        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
