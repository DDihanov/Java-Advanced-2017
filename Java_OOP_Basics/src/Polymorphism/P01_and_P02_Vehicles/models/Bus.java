package Polymorphism.P01_and_P02_Vehicles.models;

import Polymorphism.P01_and_P02_Vehicles.exceptions.TankCapacityOverflowException;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        if(fuel + this.getFuelQuantity() > this.getTankCapacity()){
            throw new TankCapacityOverflowException("Cannot fit fuel in tank");
        }
        super.refuel(fuel);
    }
}
