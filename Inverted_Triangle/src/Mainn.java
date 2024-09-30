import java.util.Scanner;

public class Mainn{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan kaç satır olacağını alıyoruz
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Üçgen türünü seçtiriyoruz: 1 - Ters Üçgen, 2 - Düz Üçgen
        System.out.print("Choose triangle type (1 for Inverted, 2 for Normal): ");
        int choice = scanner.nextInt();

        // Kullanıcının seçimine göre üçgen çiziyoruz
        switch (choice) {
            case 1:
                // Ters Üçgen (Inverted Triangle)
                System.out.println("Inverted Triangle:");
                for (int i = rows; i >= 1; i--) {
                    for (int j = 1; j <= rows - i; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 1; k <= 2 * i - 1; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            case 2:
                // Düz Üçgen (Normal Triangle)
                System.out.println("Normal Triangle:");
                for (int i = 1; i <= rows; i++) {
                    for (int j = 1; j <= rows - i; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 1; k <= 2 * i - 1; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid choice! Please select either 1 or 2.");
                break;
        }

        scanner.close();
    }
}
