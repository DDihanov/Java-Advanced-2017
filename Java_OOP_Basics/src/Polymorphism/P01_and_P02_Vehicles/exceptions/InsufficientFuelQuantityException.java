package Polymorphism.P01_and_P02_Vehicles.exceptions;

public class InsufficientFuelQuantityException extends VehicleException {
    public InsufficientFuelQuantityException(String message) {
        super(message);
    }
}
