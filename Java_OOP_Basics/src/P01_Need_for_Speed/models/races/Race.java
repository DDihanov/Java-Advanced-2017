package P01_Need_for_Speed.models.races;

import P01_Need_for_Speed.models.cars.Car;

import java.util.*;

/**
 * Created by Austin on 12/03/2017.
 */
public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Map<Integer, Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedHashMap<>();
    }

    public void register(int carId, Car car){
        this.participants.put(carId, car);
    }

    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public int determinePrize(int counter){
        if(counter == 1){
            return (int) (this.getPrizePool()*0.5d);
        }else if(counter == 2){
            return (int) (this.getPrizePool()*0.3d);
        }else if(counter == 3){
            return (int) (this.getPrizePool()*0.2d);
        }

        return 0;
    }

    public Map<Integer, Car> getParticipants(){
        return this.participants;
    }

    @Override
    public String toString() {
        return String.format("%s - %d\n", this.getRoute(), this.getLength());
    }
}
