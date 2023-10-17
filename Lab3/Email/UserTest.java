package Email;

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	User user = new User();
       
        System.out.print("Enter your name: ");
        user.setName(scanner.nextLine());

        while (true) {
            try {
                System.out.print("Enter your salary: ");
                String salaryInput = scanner.nextLine();
                user.setSalary(salaryInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary format. Please try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter your email address: ");
                String emailInput = scanner.nextLine();
                user.setEmail(emailInput);
                break;
            } catch (MalformedEmailAddressException e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid email address format. Please try again.");
            }
        }

        System.out.println("\nUser Information:\n" + user.toString());

        scanner.close();
    }
}