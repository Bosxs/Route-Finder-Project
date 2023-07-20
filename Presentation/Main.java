package Presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Array Operations!");

        // Prompt the user to select the operation category
        int category = Main.getInputInRange(scanner,
                "Select the operation you want to perform:\n1. Searching Algorithms\n2. Sorting Algorithms", 1, 2);

        // Perform actions based on the selected category
        switch (category) {
            case 1:
                search.searchMenu(scanner);
                break;

            case 2:
                sort.sortMenu(scanner);
                break;

            default:
                System.out.println("Invalid category!");
                break;
        }
        // Close the scanner to release resources
        scanner.close();
    }

    public static int getInputInRange(Scanner scanner, String prompt, int min, int max) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
        return input;
    }
}
