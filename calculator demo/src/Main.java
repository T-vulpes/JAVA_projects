import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number A: ");
        int a = scanner.nextInt();
        System.out.print("Enter number B: ");
        int b = scanner.nextInt();

        Addition addition = new Addition();
        int sumResult = addition.sum(a, b);
        System.out.println("Sum: " + sumResult);

        Subtraction subtraction = new Subtraction();
        int subResult = subtraction.subtract(a, b);
        System.out.println("Difference: " + subResult);

        Division division = new Division();
        int divResult = division.divide(a, b);
        System.out.println("Quotient: " + divResult);

        Multiplication multiplication = new Multiplication();
        int mulResult = multiplication.multiply(a, b);
        System.out.println("Product: " + mulResult);

        Exponentiation exponentiation = new Exponentiation();
        int expResult = exponentiation.power(a, b);
        System.out.println("Power: " + expResult);
    }
}
