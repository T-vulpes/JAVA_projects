import java.util.Scanner;

public class Main {
    private static boolean powerOn = true;
    private static boolean occupancy = false;
    private static int currentTemperature = 25;
    private static int desiredTemperature = 25;
    private static int guestCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hotel Management System!");

        while (powerOn) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check in");
            System.out.println("2. Check out");
            System.out.println("3. Set desired temperature");
            System.out.println("4. Adjust current temperature");
            System.out.println("5. View occupancy status");
            System.out.println("6. View current temperature");
            System.out.println("7. Power off");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    setDesiredTemperature(scanner);
                    break;
                case 4:
                    adjustCurrentTemperature(scanner);
                    break;
                case 5:
                    viewOccupancyStatus();
                    break;
                case 6:
                    viewCurrentTemperature();
                    break;
                case 7:
                    powerOff();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void checkIn() {
        if (!occupancy) {
            guestCount++;
            occupancy = true;
            System.out.println("Check in successful. Total guests: " + guestCount);
        } else {
            System.out.println("Room is already occupied.");
        }
    }

    private static void checkOut() {
        if (occupancy) {
            guestCount--;
            occupancy = false;
            System.out.println("Check out successful. Total guests: " + guestCount);
        } else {
            System.out.println("Room is already empty.");
        }
    }

    private static void setDesiredTemperature(Scanner scanner) {
        System.out.print("Enter the desired temperature: ");
        desiredTemperature = scanner.nextInt();
        System.out.println("Desired temperature set to " + desiredTemperature + "°C");
    }

    private static void adjustCurrentTemperature(Scanner scanner) {
        System.out.print("Enter the new current temperature: ");
        currentTemperature = scanner.nextInt();
        System.out.println("Current temperature adjusted to " + currentTemperature + "°C");
    }

    private static void viewOccupancyStatus() {
        if (occupancy) {
            System.out.println("Room is occupied.");
        } else {
            System.out.println("Room is empty.");
        }
    }

    private static void viewCurrentTemperature() {
        System.out.println("Current temperature is " + currentTemperature + "°C");
    }

    private static void powerOff() {
        powerOn = false;
        System.out.println("Hotel Management System is powering off.");
    }
}
