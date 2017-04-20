package models.engines;

import models.abstract_classes.BoatEngine;

public class JetEngine extends BoatEngine {
    private static final int Multiplier = 5;

    public JetEngine(String model, int horsepower, int displacement) {
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
