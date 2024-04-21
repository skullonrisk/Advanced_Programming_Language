//****************************************************************
// Title : A java programme to demonstrate Open Close Principle.
// Author : Md Nazmul Huda Labib, CSE Discipline, Khulna University.
//****************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a payment method.
 */
abstract class PaymentMethod {
    /**
     * Process the payment for the given amount.
     *
     * @param amount The amount to be paid.
     */
    abstract void processPayment(double amount);
}

/**
 * Concrete payment method for credit card payment.
 */
class CreditCardPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Logic to process credit card payment
    }
}

/**
 * Concrete payment method for PayPal payment.
 */
class PayPalPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Logic to process PayPal payment
    }
}

/**
 * Class representing an online store that accepts payments.
 */
class OnlineStore {
    private List<PaymentMethod> paymentMethods;

    /**
     * Constructs an OnlineStore object with the given payment methods.
     *
     * @param paymentMethods The list of payment methods supported by the store.
     */
    public OnlineStore(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    /**
     * Process the payment using the available payment methods.
     *
     * @param amount The amount to be paid.
     */
    public void processPayment(double amount) {
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethod.processPayment(amount);
        }
    }
}

/**
 * Demo class demonstrating the usage of different payment methods.
 */
public class Open_Close_Principle {
    public static void main(String[] args) {
        // Create payment methods
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(new CreditCardPayment());
        paymentMethods.add(new PayPalPayment());

        // Create an online store with the available payment methods
        OnlineStore onlineStore = new OnlineStore(paymentMethods);

        // Process payment for an order
        double orderAmount = 50.0; // Amount to be paid for the order
        onlineStore.processPayment(orderAmount);
    }
}

/**
 * In the above programme, the processPayment method is different for
 * each payment method class, but whenever we need to process a payment,
 * we don't need to change anything in the OnlineStore class. We can
 * simply add new payment methods by creating concrete implementations
 * of the PaymentMethod interface, adhering to the Open-Closed Principle.
 */
