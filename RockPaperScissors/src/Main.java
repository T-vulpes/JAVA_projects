import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock-Paper-Scissors Game!");

        while (true) {
            System.out.print("Enter your move (Rock, Paper, Scissors). To exit the game, type 'exit': ");
            String userMove = scanner.nextLine();

            if (userMove.equalsIgnoreCase("exit")) {
                break;
            }

            if (!userMove.equalsIgnoreCase("Rock") && !userMove.equalsIgnoreCase("Paper") && !userMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move! Please try again.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerMove = options[computerIndex];

            System.out.println("Computer move: " + computerMove);

            if (userMove.equalsIgnoreCase(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((userMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
                    (userMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
                    (userMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }

        scanner.close();
        System.out.println("Thanks for playing Rock-Paper-Scissors!");
    }
}
