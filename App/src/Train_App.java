import java.util.Arrays;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 19: Binary Search for Bogie ID
 *
 * Description:
 * This class demonstrates searching for a specific bogie ID
 * using the Binary Search algorithm on sorted data.
 *
 * At this stage, the application:
 * - Creates sorted bogie ID array
 * - Defines search key
 * - Applies binary search logic
 * - Narrows search range each iteration
 * - Displays result
 *
 * This maps optimized searching logic using divide-and-conquer.
 *
 * @author Developer
 * @version 19.0
 */
public class Train_App {

    public static boolean binarySearch(String[] bogieIds, String key) {
        // Sort before searching (precondition enforcement)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("==============================================\n");

        // Create sorted array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure data is sorted before binary search (precondition)
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display available bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println();

        // Binary search and display result
        boolean found = binarySearch(bogieIds, key);
        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found in train consist.");
        }

        System.out.println("\nUC19 search completed...");
    }
}