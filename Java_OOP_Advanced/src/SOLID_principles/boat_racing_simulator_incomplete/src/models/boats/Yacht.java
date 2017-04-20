package models.boats;

import Utility.Validator;
import contracts.IRace;
import models.abstract_classes.Boat;
import models.abstract_classes.BoatEngine;

public class Yacht extends Boat {
    private int cargoWeight;
    private BoatEngine boatEngine;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.boatEngine = engine;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = this.boatEngine.getOutput() - this.getWeight() + this.cargoWeight + (race.getOceanCurrentSpeed() / 2d);
        return speed;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }
}
