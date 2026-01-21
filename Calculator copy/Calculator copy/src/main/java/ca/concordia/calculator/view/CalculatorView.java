package ca.concordia.calculator.view;
import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public void showPrompt(double currentValue) {
        System.out.println("\nCurrent value: " + currentValue);
        System.out.print("> ");
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showGoodbye() {
        System.out.println("Goodbye!");
    }
}
