
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Prompt the user for input
            System.out.print("Enter the first integer (numerator): ");
            int numerator = scanner.nextInt();
            
            System.out.print("Enter the second integer (denominator): ");
            int denominator = scanner.nextInt();
            
            // Perform division and handle division by zero
            if (denominator == 0) {
                System.out.println("Error: Division by zero is not allowed.");
            } else {
                int result = numerator / denominator;
                System.out.println("Result: " + numerator + " / " + denominator + " = " + result);
            }
        } catch (java.util.InputMismatchException e) {
            // Handle invalid input
            System.out.println("Error: Please enter valid integers.");
        } finally {
            // Close the scanner
            scanner.close();
            System.out.println("Program has ended.");
        }
    }
}

