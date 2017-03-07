package Polymorphism.P01_and_P02_Vehicles.models;

public class Truck extends Vehicle{
    private final double REFUELING_MODIFIER = 0.95d;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * REFUELING_MODIFIER);
    }
}
