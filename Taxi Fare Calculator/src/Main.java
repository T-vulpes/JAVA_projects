import java.util.Scanner;

public class Main {

    private static final double BASE_FARE = 10.0;
    private static final double PER_KM_RATE = 2.20;
    private static final double MIN_FARE = 20.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueTrip = true;

        System.out.println("Welcome to the Taxi Fare Calculator!");

        while (continueTrip) {
            double distance = getValidDistance(scanner);
            
            double fare = calculateFare(distance);
            printFareDetails(distance, fare);

            continueTrip = promptForAnotherTrip(scanner);
        }

        System.out.println("Thank you for using the Taxi Fare Calculator!");
        scanner.close();
    }

    private static double calculateFare(double km) {
        double totalFare = BASE_FARE + (km * PER_KM_RATE);

        if (totalFare < MIN_FARE) {
            totalFare = MIN_FARE;
        }
        return totalFare;
    }

    private static double getValidDistance(Scanner scanner) {
        double km = -1;
        while (km < 0) {
            System.out.print("Please enter the distance traveled (in km): ");
            if (scanner.hasNextDouble()) {
                km = scanner.nextDouble();
                if (km < 0) {
                    System.out.println("Distance cannot be negative. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear invalid input
            }
        }
        return km;
    }

    private static void printFareDetails(double km, double fare) {
        System.out.println("\n--- Fare Breakdown ---");
        System.out.println("Base fare: " + BASE_FARE + " TL");
        System.out.println("Distance traveled: " + km + " km");
        System.out.println("Per km rate: " + PER_KM_RATE + " TL/km");
        System.out.println("Calculated fare: " + fare + " TL");
        System.out.println("-----------------------\n");
    }

    // Method to ask if the user wants to calculate another trip
    private static boolean promptForAnotherTrip(Scanner scanner) {
        System.out.print("Would you like to calculate fare for another trip? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.startsWith("y");
    }
}
