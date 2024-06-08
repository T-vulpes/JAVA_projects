import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int sum = 0;

        // Calculate the sum of proper divisors
        for (int divisor = 1; divisor < number; divisor++) {
            if (number % divisor == 0) {
                sum += divisor;
            }
        }

        // Check if the number is perfect
        if (number == sum) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.print(number + " is not a perfect number because ");
            if (sum < number) {
                System.out.println("the sum of its proper divisors (" + sum + ") is less than the number itself.");
            } else {
                System.out.println("the sum of its proper divisors (" + sum + ") is greater than the number itself.");
            }
        }
    }
}
