package P01_Need_for_Speed.models.cars;

/**
 * Created by Austin on 12/03/2017.
 */
public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand,
                String model,
                int yearOfProduction,
                int horsepower,
                int acceleration,
                int suspension,
                int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public int getOverallPerformance() {
        return this.getHorsepower() / this.getAcceleration() + (this.getSuspension() + this.getDurability());
    }

    public int getEnginePerformance() {
        return this.getHorsepower() / this.getAcceleration();
    }

    public int getSuspensionPerformance() {
        return this.getSuspension() + this.getDurability();
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public abstract void tune(int index, String addOn);

    protected void tuneParameters(int index){
        this.setHorsepower(this.getHorsepower()+index);
        this.setSuspension(this.getSuspension()+ (int)(index*0.5d));
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d\n", this.getBrand(), this.getModel(), this.getYearOfProduction()))
                .append(String.format("%d HP, 100 m/h in %d s\n", this.getHorsepower(), this.getAcceleration()))
                .append(String.format("%d Suspension force, %d Durability\n", this.getSuspension(), this.getDurability()));

        return sb.toString();
    }
}
