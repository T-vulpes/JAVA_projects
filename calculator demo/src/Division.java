public class Division {
    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }
}
