/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 16: Sort Passenger Bogies by Capacity
 *
 * Description:
 * This class demonstrates manual sorting of passenger
 * bogie capacities using the Bubble Sort algorithm
 * instead of built-in sorting utilities.
 *
 * At this stage, the application:
 * - Creates an array of capacities
 * - Compares adjacent values
 * - Swaps values when required
 * - Repeats passes until sorted
 * - Displays sorted result
 *
 * This maps algorithmic sorting logic using Bubble Sort.
 *
 * @author Developer
 * @version 16.0
 */
public class Train_App {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("==============================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }
}