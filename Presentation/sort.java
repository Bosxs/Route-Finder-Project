package Presentation;

import java.util.Scanner;

public class sort {
    public static void sortMenu(Scanner scanner) {
        // Prompt the user to select the sorting algorithm
        int sortingAlgorithm = getInputInRange(scanner,
                "Select the sorting algorithm:\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n4. Quick Sort\n5. Merge Sort\n6. Radix Sort",
                1, 6);

        // Perform the selected sorting algorithm
        switch (sortingAlgorithm) {
            case 1:
                performBubbleSort(scanner);
                break;
            case 2:
                performSelectionSort(scanner);
                break;
            case 3:
                performInsertionSort(scanner);
                break;
            case 4:
                performQuickSort(scanner);
                break;
            case 5:
                performMergeSort(scanner);
                break;
            case 6:
                performRadixSort(scanner);
                break;
            default:
                System.out.println("Invalid sorting algorithm!");
                break;
        }
    }

    public static int getInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int getInputInRange(Scanner scanner, String prompt, int minValue, int maxValue) {
        int value;
        do {
            value = getInput(scanner, prompt);
            if (value < minValue || value > maxValue) {
                System.out.println(
                        "Input out of range! Please enter a value between " + minValue + " and " + maxValue + ".");
            }
        } while (value < minValue || value > maxValue);
        return value;
    }

    public static void performBubbleSort(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        long startTime = System.currentTimeMillis();

        // Iterate through the array and compare adjacent elements, swapping them if
        // necessary
        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }
        long endTime = System.currentTimeMillis();

        bubbleSort(array);

        System.out.println("Array after bubble sort:");
        printArray(array);
        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
    }

    public static void performSelectionSort(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }
        long endTime = System.currentTimeMillis();

        selectionSort(array);

        System.out.println("Array after selection sort:");
        printArray(array);
        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
    }

    public static void performInsertionSort(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }
        long endTime = System.currentTimeMillis();

        insertionSort(array);

        System.out.println("Array after insertion sort:");
        printArray(array);
        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
    }

    public static void performQuickSort(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }
        long endTime = System.currentTimeMillis();

        quickSort(array, 0, size - 1);

        System.out.println("Array after quick sort:");
        printArray(array);
        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
    }

    public static void performMergeSort(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }
        long endTime = System.currentTimeMillis();

        mergeSort(array, 0, size - 1);

        System.out.println("Array after merge sort:");
        printArray(array);
        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
    }

    public static void performRadixSort(Scanner scanner) {
        int size = getInputInRange(scanner, "Enter the size of the array: ", 1, Integer.MAX_VALUE);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = getInput(scanner, "Element " + (i + 1) + ": ");
        }
        long endTime = System.currentTimeMillis();

        radixSort(array);

        System.out.println("Array after radix sort:");
        printArray(array);
        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void radixSort(int[] array) {
        int max = getMax(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    public static int getMax(int[] array) {
        int max = array[0];
        int n = array.length;

        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
