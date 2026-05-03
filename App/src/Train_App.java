import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ========================================================
 * MAIN CLASS - UseCase5TrainConsistMgmnt
 * ========================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class maintains the exact attachment order of bogies
 * while also preventing duplicate entries using LinkedHashSet.
 *
 * At this stage, the application:
 * - Attaches bogies in order
 * - Preserves insertion sequence
 * - Avoids duplicate bogies
 * - Displays final train formation
 *
 * This maps ordered uniqueness using LinkedHashSet.
 *
 * @author Developer
 * @version 5.0
 */
public class Train_App {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("====================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("====================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // ---- ATTACH bogies in physical sequence ----
        // add() inserts bogies; duplicates are silently ignored
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // ---- ATTEMPT duplicate attachment ----
        // LinkedHashSet will ignore this automatically
        formation.add("Sleeper"); // Duplicate - will be ignored

        // ---- DISPLAY final train formation ----
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        // ---- NOTE about LinkedHashSet behavior ----
        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}