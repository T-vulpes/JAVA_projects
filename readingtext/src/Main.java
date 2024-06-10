import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (Character.isLetter(character)) {
                if (charCounts.containsKey(character)) {
                    charCounts.put(character, charCounts.get(character) + 1);
                } else {
                    charCounts.put(character, 1);
                }
            }
        }

        System.out.println("Character counts in the text:");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
