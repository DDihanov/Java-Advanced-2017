package Polymorphism.P03_WildFarm.models.animals;

import Polymorphism.P03_WildFarm.models.exceptions.NotEatingFoodException;
import Polymorphism.P03_WildFarm.models.food.Food;

public class Mouse extends Mammal {
    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(!food.getType().equals("Vegetable")){
            throw new NotEatingFoodException("Mouses are not eating that type of food!");
        }
        System.out.println("A cheese was just eaten!");
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
