package Polymorphism.P01_and_P02_Vehicles;

import Polymorphism.P01_and_P02_Vehicles.exceptions.VehicleException;
import Polymorphism.P01_and_P02_Vehicles.models.Bus;
import Polymorphism.P01_and_P02_Vehicles.models.Car;
import Polymorphism.P01_and_P02_Vehicles.models.Truck;
import Polymorphism.P01_and_P02_Vehicles.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        Vehicle[] vehicles = createVehicles(sc);

        int counter = Integer.parseInt(sc.readLine());

        for (int i = 0; i < counter; i++) {
            String[] params = sc.readLine().split("\\s+");
            try{
                switch(params[0]){
                    case"Drive":
                        tryToDrive(params, vehicles, false);
                        break;
                    case"DriveEmpty":
                        tryToDrive(params, vehicles, true);
                    case"Refuel":
                        tryToRefuel(params, vehicles);
                        break;
                }
            }catch(VehicleException e){
                System.out.println(e.getMessage());
            }
        }

        for (Vehicle v :
                vehicles) {
            System.out.println(v);
        }
    }

    private static Vehicle[] createVehicles(BufferedReader sc) throws IOException {
        Vehicle[] vehicles = new Vehicle[3];
        for (int i = 0; i < 3; i++) {
            String[] info = sc.readLine().split("\\s+");

            String type = info[0];
            double initialFuel = Double.parseDouble(info[1]);
            double litersPerKm = Double.parseDouble(info[2]);
            double tankCapacity = Double.parseDouble(info[3]);

            switch(type){
                case"Car":
                    Vehicle car = new Car(initialFuel, litersPerKm, tankCapacity);
                    vehicles[i] = car;
                    break;
                case"Truck":
                    Vehicle truck = new Truck(initialFuel, litersPerKm, tankCapacity);
                    vehicles[i] = truck;
                    break;
                case"Bus":
                    Vehicle bus = new Bus(initialFuel, litersPerKm, tankCapacity);
                    vehicles[i] = bus;
                    break;
            }
        }

        return vehicles;
    }

    private static void tryToRefuel(String[] params, Vehicle[] vehicles) {
        String vehicle = params[1];
        double liters = Double.parseDouble(params[2]);

        for (Vehicle v :
                vehicles) {
            if(v.getClass().getSimpleName().equals(vehicle)){
                v.refuel(liters);
                return;
            }
        }
    }

    private static void tryToDrive(String[] params, Vehicle[] vehicles, boolean isEmpty) {
        String vehicle = params[1];
        double distance = Double.parseDouble(params[2]);

        for (Vehicle v:
                vehicles) {
            if(v.getClass().getSimpleName().equals(vehicle)){
                if(isEmpty){
                    v.driveEmpty(distance);
                    return;
                }
                v.drive(distance);
                return;
            }
        }
    }

}
