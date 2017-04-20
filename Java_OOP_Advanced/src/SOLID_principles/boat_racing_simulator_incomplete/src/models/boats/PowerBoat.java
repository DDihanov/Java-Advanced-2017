package models.boats;

import contracts.IRace;
import models.abstract_classes.Boat;
import models.abstract_classes.BoatEngine;

import java.util.List;

public class PowerBoat extends Boat{
    private List<BoatEngine> engines;

    public PowerBoat(String model, int weight, List<BoatEngine> engines) {
        super(model, weight);
        this.engines = engines;
    }


    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = this.engines.stream().mapToInt(x-> x.getOutput()).sum() - this.getWeight() + (race.getOceanCurrentSpeed() / 5d);
        return speed;
    }


}


