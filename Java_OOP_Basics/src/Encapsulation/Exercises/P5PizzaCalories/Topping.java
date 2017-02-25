package Encapsulation.Exercises.P5PizzaCalories;

import java.util.HashMap;

public class Topping {
    private final double BASE_CALORIES = 2;

    private HashMap<String, Double> toppingMap = new HashMap<>();
    private String toppingType;
    private double toppingWeight;

    public Topping(String toppingType, double toppingWeight) {
        constructMap();
        setToppingType(toppingType);
        setToppingWeight(toppingWeight);
    }

    private String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if(!this.toppingMap.containsKey(toppingType.toLowerCase())){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private double getToppingWeight() {
        return toppingWeight;
    }

    private void setToppingWeight(double toppingWeight) {
        if(toppingWeight < 1 || toppingWeight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.toppingWeight = toppingWeight;
    }

    public double getToppingCalories(){
        double toppingWeight = this.getToppingWeight();
        double toppingTypeModifier = this.toppingMap.get(this.toppingType.toLowerCase());

        return BASE_CALORIES * toppingTypeModifier * toppingWeight;
    }

    private void constructMap() {
        this.toppingMap = new HashMap<String, Double>() {{
            put("meat", 1.2);
            put("veggies", 0.8);
            put("cheese", 1.1);
            put("sauce", 0.9);
        }};
    }
}
