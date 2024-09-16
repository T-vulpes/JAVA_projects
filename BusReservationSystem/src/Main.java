import java.util.Scanner;
import java.util.Random;

class Bus {
    String busNumber;
    String destination;
    boolean[] seats; 

    public Bus(String busNumber, String destination, int totalSeats) {
        this.busNumber = busNumber;
        this.destination = destination;
        this.seats = new boolean[totalSeats]; 
    }

    public void displaySeatAvailability() {
        System.out.println("Seat Availability for Bus " + busNumber + " to " + destination + ":");
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Booked" : "Available"));
        }
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber > seats.length || seatNumber < 1) {
            System.out.println("Invalid seat number.");
            return false;
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        } else {
            seats[seatNumber - 1] = true; // Mark the seat as booked
            System.out.println("Seat " + seatNumber + " has been successfully booked on Bus " + busNumber + " to " + destination + ".");
            return true;
        }
    }

    public boolean cancelSeat(int seatNumber) {
        if (seatNumber > seats.length || seatNumber < 1) {
            System.out.println("Invalid seat number.");
            return false;
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is not booked.");
            return false;
        } else {
            seats[seatNumber - 1] = false; 
            System.out.println("Seat " + seatNumber + " has been successfully canceled on Bus " + busNumber + " to " + destination + ".");
            return true;
        }
    }

    public void displayBookedSeats() {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.println("Bus " + busNumber + " to " + destination + ": Seat " + (i + 1));
            }
        }
    }

    public boolean hasBookedSeats() {
        for (boolean seat : seats) {
            if (seat) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static String generateRandomBusNumber() {
        Random random = new Random();
        int busNumber = random.nextInt(9000) + 1000; 
        return "BUS-" + busNumber;
    }

    public static String[] cities = {"Moscow", "St. Petersburg", "Kazan", "Sochi", "Novosibirsk", "Ekaterinburg", "Vladivostok", "Nizhny Novgorod", "Kaliningrad", "Samara"};

    public static String getRandomCity() {
        Random random = new Random();
        int index = random.nextInt(cities.length);
        return cities[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Bus[] buses = new Bus[5]; 
        for (int i = 0; i < buses.length; i++) {
            String busNumber = generateRandomBusNumber();
            String destination = getRandomCity();
            buses[i] = new Bus(busNumber, destination, random.nextInt(10) + 5); 
        }

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Welcome to the Russian Bus Reservation System!");
            System.out.println("Please select an option:");
            System.out.println("1. Purchase Ticket");
            System.out.println("2. View Booked Tickets");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    boolean keepBooking = true;
                    while (keepBooking) {
                        System.out.println("Please select a bus:");
                        for (int i = 0; i < buses.length; i++) {
                            System.out.println((i + 1) + ". Bus " + buses[i].busNumber + " to " + buses[i].destination);
                        }

                        int busChoice = scanner.nextInt();
                        if (busChoice >= 1 && busChoice <= buses.length) {
                            Bus selectedBus = buses[busChoice - 1];
                            selectedBus.displaySeatAvailability();
                            System.out.print("Select a seat to book: ");
                            int seatNumber = scanner.nextInt();
                            selectedBus.bookSeat(seatNumber);
                        } else {
                            System.out.println("Invalid bus selection.");
                        }

                        System.out.println("Do you want to book another ticket? (yes/no)");
                        String anotherTicket = scanner.next();
                        if (anotherTicket.equalsIgnoreCase("no")) {
                            keepBooking = false;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Displaying all booked seats across all buses:");
                    boolean anySeatsBooked = false;
                    for (Bus bus : buses) {
                        if (bus.hasBookedSeats()) {
                            bus.displayBookedSeats();
                            anySeatsBooked = true;
                        }
                    }
                    if (!anySeatsBooked) {
                        System.out.println("No seats have been booked yet.");
                    }
                    break;

                case 3: 
                    System.out.println("Please select the bus to cancel a seat:");
                    for (int i = 0; i < buses.length; i++) {
                        System.out.println((i + 1) + ". Bus " + buses[i].busNumber + " to " + buses[i].destination);
                    }

                    int busCancelChoice = scanner.nextInt();
                    if (busCancelChoice >= 1 && busCancelChoice <= buses.length) {
                        Bus selectedBus = buses[busCancelChoice - 1];
                        selectedBus.displaySeatAvailability();
                        System.out.print("Select a seat to cancel: ");
                        int seatNumber = scanner.nextInt();
                        selectedBus.cancelSeat(seatNumber);
                    } else {
                        System.out.println("Invalid bus selection.");
                    }
                    break;

                case 4: 
                    keepRunning = false;
                    System.out.println("Thank you for using the Russian Bus Reservation System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
