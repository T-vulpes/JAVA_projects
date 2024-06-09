public class Main {
    public static void main(String[] args) {
        try {
            int[] numbers = new int[]{1, 2, 4, 5, 6, 0};
            System.out.println(numbers[9]);
        } catch (Exception exception) {
            System.out.println("An error occurred: " + exception);
        } finally {
            System.out.println("The Finally block runs regardless of try-catch! ");
        }
    }
}
