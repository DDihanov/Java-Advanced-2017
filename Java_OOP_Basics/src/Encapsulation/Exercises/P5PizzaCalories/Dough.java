package Encapsulation.Exercises.P5PizzaCalories;

import java.util.HashMap;

public class Dough {
   private final double BASE_CALORIES = 2;

   private HashMap<String, Double> bakingTechniqueMap = new HashMap<>();
   private HashMap<String, Double> flourTypeMap = new HashMap<>();
   private String bakingTechnique;
   private String flourType;

   private double doughWeight;

    public Dough(String flourType, String bakingTechnique , double doughWeight) {
        constructMaps();
        setBakingTechnique(bakingTechnique);
        setFlourType(flourType);
        setDoughWeight(doughWeight);
    }

    private String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!this.bakingTechniqueMap.containsKey(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if(!this.flourTypeMap.containsKey(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private double getDoughWeight() {
        return doughWeight;
    }

    private void setDoughWeight(double doughWeight) {
        if(doughWeight < 1 || doughWeight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.doughWeight = doughWeight;
    }

    public double getTotalCalories(){
        double doughWeight = this.getDoughWeight();
        double flourTypeModifier = this.flourTypeMap.get(this.flourType);
        double bakingTypeModifier = this.bakingTechniqueMap.get(this.bakingTechnique);

        return (BASE_CALORIES * doughWeight) * flourTypeModifier * bakingTypeModifier;
    }

    private void constructMaps() {
        this.flourTypeMap = new HashMap<String, Double>() {{
            put("white", 1.5);
            put("wholegrain", 1.0);
        }};
        this.bakingTechniqueMap = new HashMap<String, Double>() {{
            put("chewy", 1.1);
            put("crispy", 0.9);
            put("homemade", 1.0);
        }};
    }
}
