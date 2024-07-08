import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String[] WORDS = {
            "argentina", "australia", "brazil", "canada", "china", "denmark",
            "egypt", "france", "germany", "india", "italy", "japan", "mexico",
            "netherlands", "norway", "portugal", "russia", "spain", "sweden",
            "switzerland", "turkey"
    };
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        int tries = 0;
        List<Character> guessedLetters = new ArrayList<>();
        boolean wordGuessed = false;

        Scanner scanner = new Scanner(System.in);

        while (tries < MAX_TRIES && !wordGuessed) {
            System.out.println("Current word: " + getWordDisplay(word, guessedLetters));
            System.out.print("Guess a letter or word: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() == 1) {
                char letter = guess.charAt(0);
                if (guessedLetters.contains(letter)) {
                    System.out.println("You already guessed that letter.");
                } else if (word.contains(String.valueOf(letter))) {
                    System.out.println("Good guess!");
                    guessedLetters.add(letter);
                } else {
                    System.out.println("Wrong guess.");
                    guessedLetters.add(letter);
                    tries++;
                }
            } else if (guess.equals(word)) {
                wordGuessed = true;
            } else {
                System.out.println("Wrong guess.");
                tries++;
            }

            printHangman(tries);
            System.out.println();
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Sorry, you ran out of tries. The word was: " + word);
        }

        scanner.close();
    }

    private static String getWordDisplay(String word, List<Character> guessedLetters) {
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                display.append(letter).append(" ");
            } else {
                display.append("_ ");
            }
        }
        return display.toString();
    }

    private static void printHangman(int tries) {
        switch (tries) {
            case 0:
                System.out.println("  --------\n  |      |\n  |      \n  |      \n  |      \n  |      \n  -");
                break;
            case 1:
                System.out.println("  --------\n  |      |\n  |      O\n  |      \n  |      \n  |      \n  -");
                break;
            case 2:
                System.out.println("  --------\n  |      |\n  |      O\n  |      |\n  |      \n  |      \n  -");
                break;
            case 3:
                System.out.println("  --------\n  |      |\n  |      O\n  |     \\|\n  |      \n  |      \n  -");
                break;
            case 4:
                System.out.println("  --------\n  |      |\n  |      O\n  |     \\|/\n  |      \n  |      \n  -");
                break;
            case 5:
                System.out.println("  --------\n  |      |\n  |      O\n  |     \\|/\n  |      |\n  |      \n  -");
                break;
            case 6:
                System.out.println("  --------\n  |      |\n  |      O\n  |     \\|/\n  |      |\n  |     / \\\n  -");
                break;
        }
    }



}
