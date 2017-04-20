package models.boats;

import Utility.Constants;
import contracts.IRace;
import models.abstract_classes.Boat;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = (race.getWindSpeed() * (this.sailEfficiency / 100d)) - this.getWeight() + (race.getOceanCurrentSpeed() / 2d);
        return speed;
    }
}
