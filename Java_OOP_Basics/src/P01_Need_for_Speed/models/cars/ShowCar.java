package P01_Need_for_Speed.models.cars;

/**
 * Created by Austin on 12/03/2017.
 */
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand,
                      String model,
                      int yearOfProduction,
                      int horsepower,
                      int acceleration,
                      int suspension,
                      int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public void tune(int index, String addOn) {
        super.tuneParameters(index);
        this.stars+=index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(String.format("%d *\n", this.stars));

        return sb.toString();
    }
}
