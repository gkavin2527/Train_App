import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ========================================================
 * MAIN CLASS - UseCase7TrainConsistMgmnt
 * ========================================================
 *
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 *
 * Description:
 * This class sorts passenger bogies based on seating
 * capacity using a custom Comparator.
 *
 * At this stage, the application:
 * - Creates bogie objects
 * - Stores them in a list
 * - Displays unsorted data
 * - Sorts using Comparator logic
 * - Displays sorted result
 *
 * This maps custom ordering using Comparator.
 *
 * @author Developer
 * @version 7.0
 */
public class Train_App {

    // ---- Inner Bogie class to model passenger bogies ----
    static class Bogie {
        String name;
        int capacity;

        // Constructor to initialize bogie name and capacity
        Bogie(String name, int capacity) {
            this.name     = name;
            this.capacity = capacity;
        }

        // toString() for clean display output
        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("============================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // ---- ADD bogie objects with name and capacity ----
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General",     90));

        // ---- DISPLAY unsorted bogies ----
        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // ---- SORT using Comparator by capacity (ascending) ----
        // Comparator.comparingInt() extracts the int field to compare
        // Lambda: (b) -> b.capacity tells Java what field to sort on
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // ---- DISPLAY sorted bogies ----
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}