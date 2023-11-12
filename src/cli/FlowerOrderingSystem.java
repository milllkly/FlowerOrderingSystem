package cli;

import decorator.RibbonDecorator;
import factory.FlowerFactory;
import model.Flower;
import payment.CreditCardStrategy;
import payment.PayPalStrategy;
import payment.PaymentStrategy;

import java.util.Scanner;

public class FlowerOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome Message
        System.out.println("Welcome to the Flower Ordering System!");

        // Ask for Flower Type
        System.out.println("What type of flower would you like to order? (Rose/Tulip)");
        String flowerType = scanner.nextLine();
        Flower flower = new FlowerFactory().getFlower(flowerType.toUpperCase());

        // Decorator Option
        System.out.println("Would you like to add a ribbon? (yes/no)");
        String ribbonChoice = scanner.nextLine();
        if ("yes".equalsIgnoreCase(ribbonChoice)) {
            flower = new RibbonDecorator(flower);
        }

        // Personal Details
        System.out.println("Please enter the recipient's name:");
        String name = scanner.nextLine();

        System.out.println("Please enter the delivery address:");
        String address = scanner.nextLine();

        System.out.println("Any special message to include with the flowers?");
        String message = scanner.nextLine();

        // Contact Number
        System.out.println("Please provide a contact number for delivery:");
        String contactNumber = scanner.nextLine();

        // Payment and Price (Assuming fixed price for simplicity)
        System.out.println("The total price is $20. How would you like to pay? (CreditCard/PayPal)");
        String paymentMethod = scanner.nextLine();
        PaymentStrategy paymentStrategy = paymentMethod.equalsIgnoreCase("PayPal") ?
                new PayPalStrategy() : new CreditCardStrategy();

        // Processing Payment
        paymentStrategy.pay("20");

        // Order Confirmation
        System.out.println("Thank you for your order!");
        System.out.println("Order Details:");
        flower.displayInfo();
        System.out.println("To: " + name);
        System.out.println("Address: " + address);
        System.out.println("Message: " + message);
        System.out.println("Contact Number: " + contactNumber);

        scanner.close();
    }
}
