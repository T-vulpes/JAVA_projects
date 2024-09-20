import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Welcome to the Advanced Body Mass Index (BMI) Calculator!");

        // Main loop to allow multiple calculations
        while (continueCalculating) {
            // Get valid weight and height inputs
            double weight = getValidWeight(scanner);
            double height = getValidHeight(scanner);

            // Calculate BMI
            double bmi = calculateBMI(weight, height);

            // Display BMI result and category
            displayBMIDetails(bmi);

            // Ask the user if they want to calculate again
            continueCalculating = promptForAnotherCalculation(scanner);
        }

        System.out.println("Thank you for using the BMI Calculator. Stay healthy!");
        scanner.close();
    }

    // Method to calculate BMI
    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);  // BMI formula: weight (kg) / height^2 (m^2)
    }

    // Method to get valid weight from the user
    private static double getValidWeight(Scanner scanner) {
        double weight = -1;
        while (weight <= 0) {
            System.out.print("Please enter your weight in kilograms (e.g., 70.5): ");
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be a positive number. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for your weight.");
                scanner.next(); // Clear the invalid input
            }
        }
        return weight;
    }

    // Method to get valid height from the user
    private static double getValidHeight(Scanner scanner) {
        double height = -1;
        while (height <= 0) {
            System.out.print("Please enter your height in meters (e.g., 1.75): ");
            if (scanner.hasNextDouble()) {
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive number. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for your height.");
                scanner.next(); // Clear the invalid input
            }
        }
        return height;
    }

    // Method to display BMI details and category
    private static void displayBMIDetails(double bmi) {
        System.out.printf("Your BMI is: %.2f\n", bmi);

        // Display BMI category based on WHO standards
        if (bmi < 18.5) {
            System.out.println("You are underweight.");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You have a normal weight.");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }
        System.out.println("-----------------------\n");
    }

    // Method to prompt the user for another calculation
    private static boolean promptForAnotherCalculation(Scanner scanner) {
        System.out.print("Would you like to calculate BMI for another person? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.startsWith("y");
    }
}
