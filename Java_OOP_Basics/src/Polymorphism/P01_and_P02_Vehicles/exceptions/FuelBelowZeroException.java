package Polymorphism.P01_and_P02_Vehicles.exceptions;

public class FuelBelowZeroException extends VehicleException {
    public FuelBelowZeroException(String s) {
        super(s);
    }
}
