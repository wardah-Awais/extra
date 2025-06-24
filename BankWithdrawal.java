package Tasks;

public class BankWithdrawal {
    public static void main(String[] args) {
        int balance = 1000;
        int withdraw = 1500;

        try {
            if (withdraw > balance) {
                throw new Exception("Insufficient balance.");
            }
            balance -= withdraw;
            System.out.println("Withdrawal successful. Remaining: " + balance);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
