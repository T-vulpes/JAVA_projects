package tmExampleWithSwitchCase;
import java.util.Scanner;

public class atmain {

    public static void main(String[] args) {
        int balance = 1000;
        Scanner scan = new Scanner(System.in);
        int amount, recipientAccount;
        int operation;

        System.out.println("Welcome to the ATM");

        while (true) {
            System.out.println("\nPlease select an option: ");
            System.out.println("1: Check Balance");
            System.out.println("2: Deposit Money");
            System.out.println("3: Withdraw Money");
            System.out.println("4: Transfer Money");
            System.out.println("5: Exit");

            operation = scan.nextInt();

            switch (operation) {
                case 1:
                    // Case for checking balance
                    System.out.println("Your current balance is $" + balance);
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit: ");
                    amount = scan.nextInt();
                    if (amount > 0) {
                        balance += amount;
                        System.out.println("You have successfully deposited $" + amount);
                        System.out.println("Your new balance is $" + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the amount you want to withdraw: ");
                    amount = scan.nextInt();
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        System.out.println("You have successfully withdrawn $" + amount);
                        System.out.println("Your remaining balance is $" + balance);
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the recipient's account number: ");
                    recipientAccount = scan.nextInt();
                    System.out.println("Enter the amount you want to transfer: ");
                    amount = scan.nextInt();
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        System.out.println("You have successfully transferred $" + amount + " to account " + recipientAccount);
                        System.out.println("Your remaining balance is $" + balance);
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    scan.close();
                    return; // Exits the program
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
