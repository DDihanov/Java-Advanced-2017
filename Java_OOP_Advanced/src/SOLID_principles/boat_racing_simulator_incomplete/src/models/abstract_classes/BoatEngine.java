package models.abstract_classes;

import Utility.Constants;
import Utility.Validator;
import contracts.IModelable;

public abstract class BoatEngine implements IModelable{
    private int cachedOutput;
    private String model;
    private int horsepower;
    private int displacement;

    protected BoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    public abstract int getOutput();

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    protected void setCachedOutput(int cachedOutput) {
        this.cachedOutput = cachedOutput;
    }

    protected int getHorsepower() {
        return horsepower;
    }

    protected int getDisplacement() {
        return displacement;
    }

    protected int getCachedOutput() {
        return cachedOutput;
    }
}
