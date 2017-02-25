package Encapsulation.Exercises.P5PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private List<Topping> toppings;
    private Dough dough;
    private int toppingSize;

    public Pizza(){

    }

    public Pizza(String name, int toppingSize) {
        setName(name);
        setToppings(new ArrayList<>());
        setToppingSize(toppingSize);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.trim().length() == 0 || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    private List<Topping> getToppings() {
        return toppings;
    }

    private void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public int getToppingSize() {
        return toppingSize;
    }

    private void setToppingSize(int toppingSize) {
        if(toppingSize <= 0 || toppingSize > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingSize = toppingSize;
    }

    public double getTotalCalories(){
        double toppingCalories = this.getToppings().stream().mapToDouble(Topping::getToppingCalories).sum();
        double doughCalories = this.getDough().getTotalCalories();

        return toppingCalories + doughCalories;
    }
}
