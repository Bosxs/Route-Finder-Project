package Presentation;

import java.util.Scanner;

public class search {
    public static void searchMenu(Scanner scanner) {
        // Prompt the user to select the searching algorithm
        int searchAlgorithm = getInputInRange(scanner,
                "Select the searching algorithm:\n1. Linear Search\n2. Binary Search", 1, 2);

        // Perform linear search if option 1 is selected, binary search if option 2 is
        // selected
        switch (searchAlgorithm) {
            case 1:
                performLinearSearch(scanner);
                break;
            case 2:
                performBinarySearch(scanner);
                break;
            default:
                System.out.println("Invalid search algorithm!");
                break;
        }
    }

    private static int getInputInRange(Scanner scanner, String prompt, int min, int max) {
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

    public static int linearSearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int element) {
        int left = 0;
        int right = array.length - 1;

        sort.bubbleSort(array);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == element) {
                return mid;
            }

            if (array[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void performLinearSearch(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }

        int searchElement = getInput(scanner, "Enter the element to search: ");

        long startTime = System.currentTimeMillis();
        int linearSearchIndex = linearSearch(array, searchElement);
        long endTime = System.currentTimeMillis();

        if (linearSearchIndex != -1) {
            System.out.println("Element found at index " + linearSearchIndex);
            System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static void performBinarySearch(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }

        int searchElement = getInput(scanner, "Enter the element to search: ");

        long startTime = System.currentTimeMillis();
        int binarySearchIndex = binarySearch(array, searchElement);
        long endTime = System.currentTimeMillis();

        if (binarySearchIndex != -1) {
            System.out.println("Element found at index " + binarySearchIndex);
            System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");

        } else {
            System.out.println("Element not found in the array.");
        }
    }

    private static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
