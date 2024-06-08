import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, String> dictionary = new HashMap<String, String>();

        // Add key-value pairs to the HashMap
        dictionary.put("book", "книга");
        dictionary.put("table", "стол");
        dictionary.put("chair", "стул");
        dictionary.put("school", "школа");

        // Print the entire HashMap
        System.out.println(dictionary);

        // Retrieve the value associated with a specific key
        System.out.println(dictionary.get("chair"));

        // Remove a key-value pair from the HashMap
        dictionary.remove("chair");

        // Try to retrieve the value associated with the removed key
        System.out.println(dictionary.get("chair"));

        // Print the size of the HashMap
        System.out.println(dictionary.size());

        // Iterate over the keys and print key-value pairs
        for (String item : dictionary.keySet()) {
            System.out.println("Key: " + item + "   Value: " + dictionary.get(item));
        }
    }
}
