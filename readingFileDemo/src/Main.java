import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        int total = 0;
        try {
            // Provide the file path correctly
            reader = new BufferedReader(new FileReader("your file path //numbers.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                total += Integer.parseInt(line); // Use Integer.parseInt instead of Integer.valueOf
            }
            System.out.println("Total = " + total);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found. " + exception);
        } catch (IOException exception) {
            System.out.println("File reading error: " + exception);
        } finally {
            // Check if the reader variable is null before closing
            if (reader != null) {
                reader.close();
            }
        }
    }
}
