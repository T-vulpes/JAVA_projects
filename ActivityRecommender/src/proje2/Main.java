package proje2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome! This project will suggest activities based on the temperature and country you input.");
        
        // Initialize variables
        double temperature;
        String country;
        
        // Get the user's country
        System.out.print("Enter your country: ");
        country = scan.next();  // Correct String usage
        
        // Get the temperature
        System.out.print("Enter the temperature: ");
        temperature = scan.nextDouble();
        
        // Suggest activities based on temperature using switch-case
        suggestActivities(country, temperature);
    }
    
    // Function to suggest activities based on country and temperature
    public static void suggestActivities(String country, double temperature) {
        System.out.println("Suggested activities for " + country + ":");

        // Using switch-case for temperature ranges
        switch (country.toLowerCase()) {
            case "paris":
                if (temperature < 10) {
                    System.out.println("It's cold. You can visit museums or cozy cafes.");
                } else if (temperature >= 10 && temperature < 25) {
                    System.out.println("Great weather! How about a walk by the Seine River?");
                } else {
                    System.out.println("It's hot! Relax in a park or enjoy some ice cream.");
                }
                break;
                
            case "newyork":
                if (temperature < 5) {
                    System.out.println("It's freezing! Ice skating in Central Park could be fun.");
                } else if (temperature >= 5 && temperature < 20) {
                    System.out.println("Perfect weather for a walk in Times Square.");
                } else {
                    System.out.println("Maybe visit an air-conditioned museum or take a ferry.");
                }
                break;
            case "istanbul":
            	if (temperature < 10) {
                    System.out.println("It's chilly. How about visiting Hagia Sophia or relaxing in a tea house?");
                } else if (temperature >= 10 && temperature < 25) {
                    System.out.println("Great weather! A Bosphorus cruise or a walk in Sultanahmet would be perfect.");
                } else {
                    System.out.println("It's hot! A visit to the Princes' Islands or relaxing in a seaside cafe is ideal.");
                }
                break;

            case "st.petersburg":
                if (temperature < 5) {
                    System.out.println("It's freezing. You can visit the Hermitage Museum or take a cozy boat ride on the canals.");
                } else if (temperature >= 5 && temperature < 20) {
                    System.out.println("Nice weather! Consider exploring the city's palaces and parks.");
                } else {
                    System.out.println("Warm day! Take a river cruise or relax at a summer terrace.");
                }
                break;


            default:
                System.out.println("Sorry, we don't have activity suggestions for " + country + " at the moment.");
                break;
        }
    }
}
