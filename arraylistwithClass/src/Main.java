import java.util.ArrayList;

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

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}

class Student {
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class Main {
    public static void main(String[] args) {
        // Customer Management
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "John", "Doe"));
        customers.add(new Customer(2, "Jane", "Smith"));
        customers.add(new Customer(3, "Mike", "Brown"));
        customers.add(new Customer(4, "Emily", "Davis"));

        System.out.println("Customer List:");
        for (Customer customer : customers) {
            System.out.println(customer.firstName + " " + customer.lastName);
        }

        // Book Management
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        books.add(new Book("1984", "George Orwell", "9780451524935"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        books.add(new Book("Moby Dick", "Herman Melville", "9781503280786"));

        System.out.println("\nBook List:");
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author);
        }

        // Student Grade Management
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Alice", 85.5));
        students.add(new Student(2, "Bob", 92.0));
        students.add(new Student(3, "Charlie", 78.0));
        students.add(new Student(4, "Diana", 88.5));

        System.out.println("\nStudent List:");
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Grade: " + student.grade);
        }
    }
}
