package models.boats;

import Utility.Validator;
import contracts.IRace;
import models.abstract_classes.Boat;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = (this.oars * 100) - this.getWeight() + race.getOceanCurrentSpeed();
        return speed;
    }
}
