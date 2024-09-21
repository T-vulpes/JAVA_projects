package project1;
import java.util.Scanner;
class Product {
    String name;
    double pricePerKg;
    public Product(String name, double pricePerKg) {
        this.name = name;
        this.pricePerKg = pricePerKg;
    }

    public double calculateCost(double weight) {
        return pricePerKg * weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product cucumber = new Product("Cucumber", 3.14);
        Product apple = new Product("Apple", 4.11);
        Product zucchini = new Product("Zucchini", 2.22);
        Product tomato = new Product("Tomato", 0.95);
        Product eggplant = new Product("Eggplant", 7.00);
        Product fig = new Product("Fig", 12.00);

        Product[] products = {cucumber, apple, zucchini, tomato, eggplant, fig};
        double totalCost = 0;
        for (Product product : products) {
            double weight = getPositiveWeight(scanner, product.name);
            totalCost += product.calculateCost(weight); 
        }
        System.out.printf("Your total amount is: %.2f TL%n", totalCost);  
    }
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
                scanner.next();  
            }
        }
        return weight;
    }
}
