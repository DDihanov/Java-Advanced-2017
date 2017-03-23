package P01_Need_for_Speed.models;

import P01_Need_for_Speed.models.cars.Car;
import P01_Need_for_Speed.models.cars.PerformanceCar;
import P01_Need_for_Speed.models.cars.ShowCar;
import P01_Need_for_Speed.models.garage.Garage;
import P01_Need_for_Speed.models.races.CasualRace;
import P01_Need_for_Speed.models.races.DragRace;
import P01_Need_for_Speed.models.races.DriftRace;
import P01_Need_for_Speed.models.races.Race;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Austin on 12/03/2017.
 */
public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Map<Integer, Car> racingCars;
    private Map<Integer, Race> closedRaces;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.racingCars = new LinkedHashMap<>();
        this.closedRaces = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand,
                         String model, int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability){
        switch(type){
            case"Performance":
                this.cars.put(id, new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability));
                break;
            case"Show":
                this.cars.put(id, new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability));
                break;
        }
    }

    public String check(int id){
//        if(!this.cars.containsKey(id)){
//            return;
//        }
        if(this.garage.getCars().containsKey(id)){
            return this.garage.getCars().get(id).toString();
        }

        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool){

        if(this.races.containsKey(id)){
            return;
        }

	    switch(type){
            case"Casual":
                this.races.put(id, new CasualRace(length, route, prizePool));
                break;
            case"Drag":
                this.races.put(id, new DragRace(length, route, prizePool));
                break;
            case"Drift":
                this.races.put(id, new DriftRace(length, route, prizePool));
                break;
        }
    }

    public void participate(int carId, int raceId){
	    if(this.garage.getCars().containsKey(carId)){
	        return;
        }

        if(!this.cars.containsKey(carId)){
            return;
        }
        if(this.closedRaces.containsKey(raceId)){
	        return;
        }

        Car car = this.cars.get(carId);
	    Race race = this.races.get(raceId);

	    if(race.getParticipants().containsKey(carId)){
	        return;
        }

	    this.racingCars.put(carId, car);
	    race.register(carId, car);
    }

    public String start(int id){
        StringBuilder sb = new StringBuilder();
	    Race race = this.races.get(id);

	    if(race.getParticipants().size() == 0){
	        return "Cannot start the race with zero participants.\n";
        }

	    sb.append(race.toString());

        for (int c:
             race.getParticipants().keySet()) {
            this.racingCars.remove(c);
        }

        this.closedRaces.put(id, race);
	    return sb.toString();
	}

    public void park(int id){
        if(this.racingCars.containsKey(id)){
            return;
        }

        if(!this.cars.containsKey(id)){
            return;
        }

        Car car = this.cars.get(id);
        this.cars.remove(id);
        this.garage.addCar(id, car);
    }

    public void unpark(int id){
        if(!this.garage.getCars().containsKey(id)){
            return;
        }
	    this.cars.put(id, this.garage.unpark(id));
    }

    public void tune(int tuneIndex, String addOn){
        if(garage.getCars().isEmpty()){
            return;
        }
        garage.tune(tuneIndex, addOn);
    }

    public Map<Integer, Race> getClosedRaces(){
        return Collections.unmodifiableMap(this.closedRaces);
    }

    public Race getRace(int id){
        return this.races.get(id);
    }
}
