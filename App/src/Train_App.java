import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 9: Group Bogies by Type
 *
 * Description:
 * This class groups similar bogies together using
 * Java Stream Collectors.groupingBy().
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Streams the list
 * - Groups bogies by name
 * - Stores grouped data in a Map
 * - Displays grouped structure
 *
 * This maps classification logic using groupingBy.
 *
 * @author Developer
 * @version 9.0
 */
public class Train_App {

    // ---- Reusing Bogie model from UC7 / UC8 ----
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name     = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    // ---- Reusable grouping method for testability ----
    // Groups bogies by their name (type)
    // Returns Map<String, List<Bogie>>
    // Original list is NOT modified
    public static Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("============================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper",     70));  // Duplicate type, different capacity
        bogies.add(new Bogie("AC Chair",    60));  // Duplicate type, different capacity

        // ---- DISPLAY all bogies before grouping ----
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // ---- GROUP USING COLLECTORS.GROUPINGBY ----
        // Key   : Bogie name/type  (String)
        // Value : List of bogies under that type (List<Bogie>)
        Map<String, List<Bogie>> groupedBogies = groupByType(bogies);

        // ---- DISPLAY grouped structure ----
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}