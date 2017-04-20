package models.engines;

import models.abstract_classes.BoatEngine;

public class SterndriveEngine extends BoatEngine {
    private static final int Multiplier = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        if (this.getCachedOutput() != 0) {
            return this.getCachedOutput();
        }

        this.setCachedOutput((this.getHorsepower() * Multiplier) + this.getDisplacement());
        return this.getCachedOutput();
    }
}
