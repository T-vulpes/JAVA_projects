import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        int number;
        int triesLeft;
        String playAgain;
        boolean keepPlaying = true;

        while (keepPlaying) {
            triesLeft = 5; 
            Random r = new Random(); 
            int targetNumber = r.nextInt(100) + 1; 
            System.out.println("Welcome to the Number Guessing Game! You need to guess a number between 1 and 100. You have " + triesLeft + " tries. Good luck!");

            while (triesLeft > 0) {
                System.out.println("Enter your guess:");
                number = scan.nextInt();

                if (number == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    break; 
                } else if (number > targetNumber) {
                    triesLeft--;
                    System.out.println("Try a smaller number. Tries left: " + triesLeft);
                } else if (number < targetNumber) {
                    triesLeft--;
                    System.out.println("Try a larger number. Tries left: " + triesLeft);
                }

                if (triesLeft == 0) {
                    System.out.println("Sorry, you've run out of tries. The correct number was: " + targetNumber);
                }
            }

            // Asking the player if they want to play again
            System.out.println("Would you like to play again? (yes/no):");
            playAgain = scan.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                keepPlaying = false;
                System.out.println("Thank you for playing! Goodbye.");
            }
        }
        scan.close();
    }
}
