import java.util.HashMap;
import java.util.Map;

/**
 * ========================================================
 * MAIN CLASS - UseCase6TrainConsistMgmnt
 * ========================================================
 *
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * This class associates each bogie with its seating or
 * load capacity using a key-value mapping structure.
 *
 * At this stage, the application:
 * - Creates a HashMap for bogie-capacity mapping
 * - Inserts capacity values for each bogie
 * - Iterates through map entries
 * - Displays bogie and capacity information
 *
 * This maps lookup-based access using HashMap.
 *
 * @author Developer
 * @version 6.0
 */
public class Train_App {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("====================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("====================================\n");

        // HashMap stores data in key -> value format
        // Key   : Bogie name  (String)
        // Value : Capacity    (Integer)
        Map<String, Integer> capacityMap = new HashMap<>();

        // ---- Insert bogie capacities ----
        // put(key, value) maps each bogie to its capacity
        capacityMap.put("Sleeper",     72);   // 72 berths
        capacityMap.put("AC Chair",    56);   // 56 seats
        capacityMap.put("First Class", 24);   // 24 seats
        capacityMap.put("Cargo",       120);  // 120 tonne load capacity

        // ---- Iterate and display all bogie-capacity entries ----
        // entrySet() returns all key-value pairs as a Set of Map.Entry objects
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}