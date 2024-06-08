import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> cities = new ArrayList<String>();

        // Adding elements to the ArrayList
        cities.add("Moscow");
        cities.add("St. Petersburg");
        cities.add("Los Angeles");
        cities.add("Hamburg");

        // Display the ArrayList
        System.out.println("Original ArrayList: " + cities);

        // Accessing an element from the ArrayList
        String city = cities.get(1);
        System.out.println("Element at index 1: " + city);

        // Updating an element in the ArrayList
        cities.set(2, "LA");
        System.out.println("Updated ArrayList: " + cities);

        // Sorting the ArrayList
        Collections.sort(cities);
        System.out.println("Sorted ArrayList: " + cities);

        // Removing an element from the ArrayList
        cities.remove("LA");
        System.out.println("ArrayList after removing 'LA': " + cities);

        // Checking if an element exists in the ArrayList
        boolean containsMoscow = cities.contains("Moscow");
        System.out.println("ArrayList contains 'Moscow': " + containsMoscow);

        // Iterating over the ArrayList using for-each loop
        System.out.println("Iterating using for-each loop:");
        for (String c : cities) {
            System.out.println(c);
        }

        // Iterating over the ArrayList using an iterator
        System.out.println("Iterating using iterator:");
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Clearing the ArrayList
        cities.clear();
        System.out.println("ArrayList after clearing: " + cities);

        // Checking if the ArrayList is empty
        boolean isEmpty = cities.isEmpty();
        System.out.println("ArrayList is empty: " + isEmpty);
    }
}
