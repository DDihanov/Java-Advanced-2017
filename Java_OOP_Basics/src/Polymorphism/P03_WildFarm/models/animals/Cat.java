package Polymorphism.P03_WildFarm.models.animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String weight = decimalFormat.format(super.getAnimalWeight());
        //{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        sb.append(String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getBreed(),
                weight,
                this.getLivingRegion(),
                this.getFoodEaten()));

        return sb.toString();
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
}
