//***********************************************************************
// Title : A java programme to demonstrate Liskov Substitution Principle.
// Author : Md Nazmul Huda Labib, CSE Discipline, Khulna University.
//***********************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a vehicle.
 */
interface Vehicle {
    /**
     * Starts the vehicle.
     */
    void start();

    /**
     * Stops the vehicle.
     */
    void stop();
}

/**
 * Class representing a Car.
 */
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
}

/**
 * Class representing a Bicycle, which is a subtype of Vehicle.
 */
class Bicycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bicycle started pedaling.");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle stopped.");
    }
}

/**
 * Demo class demonstrating the usage of vehicles and the Liskov Substitution Principle.
 */
public class Liskov_Substitution_Principle {
    /**
     * Starts and stops the vehicles in the list.
     *
     * @param vehicles The list of vehicles.
     */
    public static void operateVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
        }
    }

    public static void main(String[] args) {
        // Create a list of vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Bicycle());

        // Operate the vehicles
        operateVehicles(vehicles);
    }
}

/**
 * The Bicycle class is a subtype of Vehicle, and we can substitute
 * a Bicycle object for a Vehicle object without affecting the correctness
 * of the program. This adheres to the Liskov Substitution Principle.
 */
