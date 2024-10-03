import java.util.Scanner;

public class Main {
        public static int calculatePower(int base, int exponent) {
        System.out.println("Calculating " + base + " raised to the power of " + exponent);
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        System.out.println("The result of " + base + "^" + exponent + " is " + result);
        return result;
    }
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        System.out.println("Step 1: Determining how many digits the number has.");
        int numDigits = String.valueOf(number).length(); 
        System.out.println("The number " + originalNumber + " has " + numDigits + " digits.");
        
        System.out.println("\nStep 2: Extracting each digit and raising it to the power of " + numDigits + ".");
        while (number > 0) {
            int digit = number % 10; 
            System.out.println("Extracted digit: " + digit);
            
            int poweredDigit = calculatePower(digit, numDigits); 
            System.out.println("Adding " + poweredDigit + " to the total sum.");
            
            sum += poweredDigit; 
            number /= 10; 
            System.out.println("Remaining number after removing the last digit: " + number);
        }
        
        System.out.println("\nStep 3: The sum of the digits raised to the power of " + numDigits + " is " + sum + ".");
        
        System.out.println("\nStep 4: Checking if the sum equals the original number.");
        if (sum == originalNumber) {
            System.out.println("Since " + sum + " equals the original number " + originalNumber + ", it is an Armstrong number.");
        } else {
            System.out.println("Since " + sum + " does not equal the original number " + originalNumber + ", it is not an Armstrong number.");
        }
        
        return sum == originalNumber; 
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number to check if it is an Armstrong number: ");
        if (input.hasNextInt()) {
            int number = input.nextInt();
            System.out.println("\nYou entered the number: " + number);
            
            System.out.println("\nChecking if " + number + " is an Armstrong number...");
            if (isArmstrong(number)) {
                System.out.println("\nResult: " + number + " is an Armstrong number.");
            } else {
                System.out.println("\nResult: " + number + " is not an Armstrong number.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
        
        input.close();
    }
}
