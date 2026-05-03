import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * Description:
 * This class filters passenger bogies based on seating
 * capacity using Java Stream API.
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Converts list into stream
 * - Applies filter condition
 * - Collects filtered result
 * - Displays qualifying bogies
 *
 * This maps functional filtering using Streams.
 *
 * @author Developer
 * @version 8.0
 */
public class Train_App {

    // ---- Reusing Bogie model from UC7 ----
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

    // ---- Reusable filter method for testability ----
    // Accepts a list and threshold, returns filtered list
    // Original list is NOT modified (stream creates a new list)
    public static List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()                             // Convert list to Stream
                .filter(b -> b.capacity > threshold)  // Keep only bogies above threshold
                .collect(Collectors.toList());         // Collect result into new List
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("============================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General",     90));

        // ---- DISPLAY all bogies before filtering ----
        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // ---- FILTER bogies with capacity > 60 ----
        List<Bogie> filteredBogies = filterByCapacity(bogies, 60);

        // ---- DISPLAY filtered results ----
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }
}