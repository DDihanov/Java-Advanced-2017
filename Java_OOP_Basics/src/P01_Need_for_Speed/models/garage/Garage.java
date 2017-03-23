package P01_Need_for_Speed.models.garage;

import P01_Need_for_Speed.models.cars.Car;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Austin on 12/03/2017.
 */
public class Garage {
    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public void addCar(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    public void tune(int index, String addOn) {
        for (Car car :
                this.parkedCars.values()) {
            car.tune(index, addOn);
        }
    }

    public Car unpark(int id){
        Car car = this.parkedCars.get(id);
        this.parkedCars.remove(id);

        return car;
    }

    public Map<Integer, Car> getCars() {
        return Collections.unmodifiableMap(this.parkedCars);
    }
}

