import java.util.Arrays;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 *
 * Description:
 * This class demonstrates sorting of bogie type names
 * alphabetically using Java's built-in Arrays.sort() method.
 *
 * At this stage, the application:
 * - Creates an array of bogie names
 * - Uses Arrays.sort() for sorting
 * - Displays sorted results
 *
 * This maps optimized sorting using Java library utilities.
 *
 * @author Developer
 * @version 17.0
 */
public class Train_App {

    public static String[] sortBogieNames(String[] names) {
        Arrays.sort(names);
        return names;
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==============================================");
        System.out.println();

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}