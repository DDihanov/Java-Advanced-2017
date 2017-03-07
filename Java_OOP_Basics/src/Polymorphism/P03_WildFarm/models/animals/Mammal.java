package Polymorphism.P03_WildFarm.models.animals;

import java.text.DecimalFormat;

public class Mammal extends Animal {
    public static final DecimalFormat decimalFormat;
    private String livingRegion;

    static {
        decimalFormat = new DecimalFormat("0.##################");
    }

    public Mammal(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String weight = decimalFormat.format(super.getAnimalWeight());
        //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        sb.append(String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                weight,
                this.getLivingRegion(),
                this.getFoodEaten()));

        return sb.toString();
    }
}
