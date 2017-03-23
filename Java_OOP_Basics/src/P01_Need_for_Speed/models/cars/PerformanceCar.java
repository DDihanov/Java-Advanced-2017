package P01_Need_for_Speed.models.cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Austin on 12/03/2017.
 */
public class PerformanceCar extends Car {
    private List<String> addOns;
    private static final double HORSEPOWER_MODIFIER = 0.5d;
    private static final double SUSPENSION_MODIFIER = 0.25d;

    public PerformanceCar(String brand,
                           String model,
                           int yearOfProduction,
                           int horsepower,
                           int acceleration,
                           int suspension,
                           int durability) {
        super(brand, model, yearOfProduction,
                (int) (horsepower + horsepower*HORSEPOWER_MODIFIER),
                acceleration,
                (int) (suspension - suspension*SUSPENSION_MODIFIER),
                durability);
        this.addOns = new ArrayList<>();
    }


    public void tune(int index, String addOn) {
        super.tuneParameters(index);
        this.addOns.add(addOn);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(String.format("Add-ons: %s\n", this.addOns.size() > 1 ? String.join(", ", this.addOns) : "None"));

        return sb.toString();
    }


}
