package Presentation.src;

import javax.swing.JOptionPane;

public class search {
    public static void searchMenu() {
        String[] searchAlgorithms = { "Linear Search", "Binary Search" };
        int searchAlgorithm = Main.getInputInRange("Select the searching algorithm:", searchAlgorithms);

        switch (searchAlgorithm) {
            case 1:
                performLinearSearch();
                break;
            case 2:
                performBinarySearch();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid search algorithm!");
                break;
        }
    }

    public static void performLinearSearch() {
        int size = Main.getInputInRange("Enter the size of the array:", null);
        int[] array = new int[size];

        JOptionPane.showMessageDialog(null, "Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            array[i] = Main.getInput("Element " + (i + 1) + ":");
        }

        int searchElement = Main.getInput("Enter the element to search:");

        long startTime = System.currentTimeMillis();
        int linearSearchIndex = linearSearch(array, searchElement);
        long endTime = System.currentTimeMillis();

        if (linearSearchIndex != -1) {
            JOptionPane.showMessageDialog(null, "Element found at index " + linearSearchIndex + "\nRuntime: "
                    + (endTime - startTime) + " milliseconds");
        } else {
            JOptionPane.showMessageDialog(null, "Element not found in the array.");
        }
    }

    public static void performBinarySearch() {
        int size = Main.getInputInRange("Enter the size of the array:", null);
        int[] array = new int[size];

        JOptionPane.showMessageDialog(null, "Enter the elements of the array (in sorted order):");

        for (int i = 0; i < size; i++) {
            array[i] = Main.getInput("Element " + (i + 1) + ":");
        }

        int searchElement = Main.getInput("Enter the element to search:");

        long startTime = System.currentTimeMillis();
        int binarySearchIndex = binarySearch(array, searchElement);
        long endTime = System.currentTimeMillis();

        if (binarySearchIndex != -1) {
            JOptionPane.showMessageDialog(null, "Element found at index " + binarySearchIndex + "\nRuntime: "
                    + (endTime - startTime) + " milliseconds");
        } else {
            JOptionPane.showMessageDialog(null, "Element not found in the array.");
        }
    }

    public static int linearSearch(int[] array, int searchElement) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchElement) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int searchElement) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == searchElement) {
                return mid;
            }

            if (array[mid] < searchElement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
