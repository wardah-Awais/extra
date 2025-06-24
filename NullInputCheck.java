package Tasks;

import java.util.Scanner;

public class NullInputCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be null or empty.");
            }
            System.out.println("Hello, " + name);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
