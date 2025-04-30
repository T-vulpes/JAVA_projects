public class Main {
    public static void main(String[] args) {
        // Example 1: Sum of three numbers
        int sum1 = topla(3, 4, 5);
        System.out.println("Sum of three numbers: " + sum1);

        // Example 2: Sum of multiple numbers
        int sum2 = topla(2, 10, 22, 7, 9);
        System.out.println("Sum of multiple numbers: " + sum2);
    }

    public static int topla(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
