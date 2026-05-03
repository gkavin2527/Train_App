import java.util.ArrayList;
import java.util.List;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 10: Count Total Seats in Train (reduce)
 *
 * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total using Stream reduce().
 *
 * At this stage, the application:
 * - Creates bogie list
 * - Maps bogies to capacity
 * - Reduces values into total
 * - Displays total seat count
 *
 * This maps aggregation logic using reduce().
 *
 * @author Developer
 * @version 10.0
 */
public class Train_App {

    // ---- Reusing Bogie model ----
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

    // ---- Reusable aggregation method for testability ----
    // map()    : extracts int capacity from each Bogie object
    // reduce() : sums all capacity values into one total
    // Identity value 0 ensures empty list returns 0 safely
    // Original list is NOT modified
    public static int getTotalSeatingCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .mapToInt(b -> b.capacity)   // Extract capacity as IntStream
                .reduce(0, Integer::sum);     // Sum all values; identity = 0
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("============================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper",     70));

        // ---- DISPLAY all bogies ----
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // ---- AGGREGATE USING REDUCE ----
        // map()    : extracts capacity field from Bogie object
        // reduce() : combines all capacity values into one total
        int totalCapacity = getTotalSeatingCapacity(bogies);

        // ---- DISPLAY total seating capacity ----
        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);

        System.out.println("\nUC10 aggregation completed...");
    }
}