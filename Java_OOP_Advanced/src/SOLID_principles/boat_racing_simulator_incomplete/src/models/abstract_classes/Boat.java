package models.abstract_classes;

import Utility.Constants;
import Utility.Validator;
import contracts.IModelable;
import contracts.IRace;

public abstract class Boat implements IModelable{
    private String model;
    private int weight;

    protected Boat(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }

    public abstract double calculateRaceSpeed(IRace race);

    protected int getWeight() {
        return weight;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}

