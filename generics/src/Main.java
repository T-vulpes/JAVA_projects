// Generic class Container
//Generics in Java is a feature that allows you to define classes, interfaces, and methods with placeholder types, providing a way
// to create classes, methods, and interfaces that operate on a specified type.
// This enables type safety and eliminates the need for type casting, enhancing code reusability and robustness.
class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void showType() {
        System.out.println("Type of T is: " + value.getClass().getName());
    }
}

// Main class to test the generic Container class
public class Main {
    public static void main(String[] args) {
        // Create a Container for Integer type
        Container<Integer> integerContainer = new Container<>(123);
        System.out.println("Value in integerContainer: " + integerContainer.getValue());
        integerContainer.showType();

        // Create a Container for String type
        Container<String> stringContainer = new Container<>("Hello Generics");
        System.out.println("Value in stringContainer: " + stringContainer.getValue());
        stringContainer.showType();

        // Create a Container for Double type
        Container<Double> doubleContainer = new Container<>(45.67);
        System.out.println("Value in doubleContainer: " + doubleContainer.getValue());
        doubleContainer.showType();

        // Create a Container for a custom type (Customer)
        Customer customer = new Customer(1, "John", "Doe");
        Container<Customer> customerContainer = new Container<>(customer);
        System.out.println("Value in customerContainer: " + customerContainer.getValue().firstName + " " + customerContainer.getValue().lastName);
        customerContainer.showType();
    }
}

// Customer class used in the generic example
class Customer {
    int id;
    String firstName;
    String lastName;

    Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
