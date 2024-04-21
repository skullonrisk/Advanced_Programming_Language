//************************************************************************
// Title : A java programme to demonstrate Dependency Inversion Principle.
// Author : Md Nazmul Huda Labib, CSE, Khulna University.
//************************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a delivery method.
 */
interface DeliveryMethod {
    /**
     * Delivers a package.
     *
     * @param packageDetails Details of the package to be delivered.
     */
    void deliverPackage(String packageDetails);
}

/**
 * Class representing a delivery system.
 */
class DeliverySystem {
    private final List<DeliveryMethod> deliveryMethods;

    /**
     * Constructs a new DeliverySystem with the given delivery methods.
     *
     * @param deliveryMethods The list of delivery methods.
     */
    public DeliverySystem(List<DeliveryMethod> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }

    /**
     * Delivers a package using all the configured delivery methods.
     *
     * @param packageDetails Details of the package to be delivered.
     */
    public void deliverPackage(String packageDetails) {
        for (DeliveryMethod method : deliveryMethods) {
            method.deliverPackage(packageDetails);
        }
    }
}

/**
 * Class representing a drone delivery method.
 */
class DroneDelivery implements DeliveryMethod {
    @Override
    public void deliverPackage(String packageDetails) {
        System.out.println("Delivering package using drone: " + packageDetails);
    }
}

/**
 * Class representing a truck delivery method.
 */
class TruckDelivery implements DeliveryMethod {
    @Override
    public void deliverPackage(String packageDetails) {
        System.out.println("Delivering package using truck: " + packageDetails);
    }
}

/**
 * Demo class demonstrating the usage of a delivery system with different delivery methods.
 */
public class Dependency_Inversion_Principle {
    public static void main(String[] args) {
        // Create drone and truck delivery methods
        DeliveryMethod droneMethod = new DroneDelivery();
        DeliveryMethod truckMethod = new TruckDelivery();

        // Create a delivery system with drone and truck delivery methods
        List<DeliveryMethod> methods = new ArrayList<>();
        methods.add(droneMethod);
        methods.add(truckMethod);
        DeliverySystem deliverySystem = new DeliverySystem(methods);

        // Deliver a package using all methods
        deliverySystem.deliverPackage("Package containing books");
    }
}

/**
 * We have an interface DeliveryMethod representing a method for delivering packages.
 * The DroneDelivery and TruckDelivery classes implement the DeliveryMethod
 * interface to represent drone and truck delivery methods, respectively.
 * The DeliverySystem class represents a delivery system that can deliver packages
 * using different methods. It depends on the abstraction provided by the DeliveryMethod
 * interface, allowing it to use any delivery method without being coupled to specific implementations.
 * The Dependency_Inversion_Principle class demonstrates the usage of the delivery system
 * with different delivery methods. It creates instances of DroneDelivery and TruckDelivery
 * and configures the delivery system with them, adhering to the Dependency Inversion Principle
 * by depending on abstractions rather than concrete implementations.
 */
