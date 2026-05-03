/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 18: Linear Search for Bogie ID
 *
 * Description:
 * This class demonstrates searching for a specific bogie ID
 * using a simple Linear Search algorithm.
 *
 * At this stage, the application:
 * - Creates an array of bogie IDs
 * - Accepts a search key
 * - Traverses array sequentially
 * - Stops when match is found
 * - Displays search result
 *
 * This maps basic searching logic using sequential traversal.
 *
 * @author Developer
 * @version 18.0
 */
public class Train_App {

    public static boolean linearSearch(String[] bogieIds, String searchId) {
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC18 - Linear Search for Bogie ID");
        System.out.println("==============================================");
        System.out.println();

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG309";

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println();

        // Linear search and display result
        boolean found = linearSearch(bogieIds, searchId);
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}