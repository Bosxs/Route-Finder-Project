package Presentation.src;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Array Operations!");

        String[] categories = { "Searching Algorithms", "Sorting Algorithms" };
        int category = getInputInRange("Select the operation you want to perform:", categories);

        switch (category) {
            case 1:
                search.searchMenu();
                break;

            case 2:
                sort.sortMenu();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid category!");
                break;
        }
    }

    public static int getInputInRange(String prompt, String[] options) {
        int input = 0;
        while (input < 1 || input > options.length) {
            String inputString = (String) JOptionPane.showInputDialog(null, prompt, "Array Operations",
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (inputString == null) {
                System.exit(0); // Exit the program if the user cancels the input dialog
            }

            try {
                input = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
            }
        }
        return input;
    }

    public static int getInput(String prompt) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            String inputString = JOptionPane.showInputDialog(null, prompt);
            if (inputString != null) {
                try {
                    input = Integer.parseInt(inputString);
                    validInput = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                }
            } else {
                System.exit(0); // Exit the program if the user cancels the input dialog
            }
        }
        return input;
    }
}
