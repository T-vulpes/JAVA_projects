import math.FourOperations;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Entered number: " + number);

        System.out.println("Enter the second number: ");
        int number2 = Integer.parseInt(scanner.nextLine());

        System.out.println("Entered number: " + number2);

        FourOperations operation = new FourOperations();
        System.out.println(operation.sum(number, number2));

        FourOperations operation2 = new FourOperations();
        System.out.println(operation2.divide(number, number2));

        FourOperations operation3 = new FourOperations();
        System.out.println(operation3.multiply(number, number2));

        FourOperations operation4 = new FourOperations();
        System.out.println(operation4.subtract(number, number2));
    }
}
