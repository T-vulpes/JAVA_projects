import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = input.nextInt();
        double result = 0.0;

        // Calculating the harmonic series
        for (int i = 1; i <= n; i++) {
            result += 1.0 / i;
        }

        System.out.println("Harmonic series result: " + result);
        input.close(); // Closing the scanner
    }
}
