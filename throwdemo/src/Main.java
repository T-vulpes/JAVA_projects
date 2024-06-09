public class Main {
    public static void main(String[] args) {
        try {
            AccountManager manager = new AccountManager();
            System.out.println("Account Balance: " + manager.getBalance());
            manager.deposit(100);
            System.out.println("Account Balance after deposit: " + manager.getBalance());

            try {
                manager.withdraw(90);
                System.out.println("Withdrawal successful.");
            } catch (BalanceInsufficientException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }
            System.out.println("Account Balance after withdrawal: " + manager.getBalance());

            try {
                manager.withdraw(25);
                System.out.println("Withdrawal successful.");
            } catch (BalanceInsufficientException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }
            System.out.println("Final Account Balance: " + manager.getBalance());

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
