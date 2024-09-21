package project1;
import java.util.Scanner;

// Define a Product class to encapsulate item details
class Product {
    String name;
    double pricePerKg;

    // Constructor for initializing product name and price per kg
    public Product(String name, double pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    // Method to calculate the cost for the given weight
    public double calculateCost(double weight) {
        return pricePerKg * weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create product objects with name and price per kg
        Product cucumber = new Product("Cucumber", 3.14);
        Product apple = new Product("Apple", 4.11);
        Product zucchini = new Product("Zucchini", 2.22);
        Product tomato = new Product("Tomato", 0.95);
        Product eggplant = new Product("Eggplant", 7.00);
        Product fig = new Product("Fig", 12.00);

        // Array to store the products
        Product[] products = {cucumber, apple, zucchini, tomato, eggplant, fig};

        double totalCost = 0;
        
        // Loop through each product and get user input
        for (Product product : products) {
            double weight = getPositiveWeight(scanner, product.name);
            totalCost += product.calculateCost(weight); // Calculate and add to total
        }

        System.out.printf("Your total amount is: %.2f TL%n", totalCost);  // Display the total in a cleaner format
    }

    // Function to ensure valid weight input (positive number)
    public static double getPositiveWeight(Scanner scanner, String productName) {
        double weight = -1;
        while (weight < 0) {
            System.out.print("How many kilograms of " + productName + "? ");
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                if (weight < 0) {
                    System.out.println("Please enter a valid positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear the invalid input
            }
        }
        return weight;
    }
}
