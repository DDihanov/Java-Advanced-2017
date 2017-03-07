package Polymorphism.P03_WildFarm.models.animals;

import Polymorphism.P03_WildFarm.models.food.Food;

public abstract class Animal {
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten = 0;

    public Animal(String animalName, Double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalWeight(animalWeight);
        this.setFoodEaten(0);
    }

    public String getAnimalName() {
        return animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected String getAnimalType() {
        return this.getClass().getSimpleName();
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    private void setFoodEaten(Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    public void eat(Food food){
        int quantity = food.getQuantity();
        this.setFoodEaten(quantity);
    }

    public void makeSound(){
    }
}
