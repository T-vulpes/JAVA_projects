import java.util.Scanner;

public class Main {
        public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
        public static void fibonacciIterative(int n) {
        int a = 0, b = 1;
        System.out.println("Fibonacci sequence up to " + n + " numbers:");
        
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + a);
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
            input.next(); 
        }
        int n = input.nextInt();
        if (n < 0) {
            System.out.println("Number must be positive.");
            return;
        }
        System.out.println("Choose method: 1) Iterative 2) Recursive");
        int choice = input.nextInt();

        if (choice == 1) {
            fibonacciIterative(n);
        } else if (choice == 2) {
            System.out.println("The " + n + "th Fibonacci number (calculated recursively) is: " + fibonacciRecursive(n));
        } else {
            System.out.println("Invalid choice.");
        }

        input.close();
    }
}
