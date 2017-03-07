package Polymorphism.P01_and_P02_Vehicles.models;

import Polymorphism.P01_and_P02_Vehicles.exceptions.FuelBelowZeroException;
import Polymorphism.P01_and_P02_Vehicles.exceptions.InsufficientFuelQuantityException;

import java.text.DecimalFormat;
import java.util.HashMap;

public abstract class Vehicle {
    private double fuelQuantity;
    private double tankCapacity;
    private double fuelConsumption;
    public static HashMap<String, Double> fuelModifier;

    static {
        fuelModifier = new HashMap<>();
        fuelModifier.put("Car", 0.9d);
        fuelModifier.put("Truck", 1.6d);
        fuelModifier.put("Bus", 1.4d);
    }

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        if (tankCapacity <= 0) {
            throw new FuelBelowZeroException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double distance) {
        String vehicle = this.getClass().getSimpleName();
        double consumption = this.getFuelConsumption() + fuelModifier.get(vehicle);

        double maximumDistance = this.getFuelQuantity() / consumption;
        if (distance > maximumDistance) {
            throw new InsufficientFuelQuantityException(String.format("%s needs refueling", vehicle));
        }
        this.setFuelQuantity(this.getFuelQuantity() - distance * consumption);
        this.printTraveled(vehicle, distance);
    }

    public void driveEmpty(double distance) {
        String vehicle = this.getClass().getSimpleName();
        double consumption = this.getFuelConsumption();

        double maximumDistance = this.getFuelQuantity() / consumption;

        if (distance > maximumDistance) {
            throw new InsufficientFuelQuantityException(String.format("%s needs refueling", vehicle));
        }
        this.setFuelQuantity(this.getFuelQuantity() - distance * consumption);
        this.printTraveled(vehicle, distance);
    }

    protected void printTraveled(String vehicle, double distance) {
        String kilometers = new DecimalFormat("0.##################").format(distance);
        System.out.printf("%s travelled %s km\n", vehicle, kilometers);
    }

    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
