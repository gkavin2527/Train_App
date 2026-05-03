import java.util.ArrayList;
import java.util.List;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class enforces domain safety rules on goods bogies.
 *
 * At this stage, the application:
 * - Creates goods bogie list
 * - Converts list into stream
 * - Applies safety validation rule
 * - Checks compliance using allMatch()
 * - Displays safety status
 *
 * This maps real-world cargo safety rules using Streams.
 *
 * @author Developer
 * @version 12.0
 */
public class Train_App {

    // ---- Goods Bogie model ----
    static class GoodsBogie {
        String type;    // Bogie type  : Cylindrical, Open, Box
        String cargo;   // Cargo type  : Petroleum, Coal, Grain

        GoodsBogie(String type, String cargo) {
            this.type  = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    // ---- Safety Rule ----
    // Rule: Cylindrical bogies must carry ONLY Petroleum
    // Non-cylindrical bogies (Open, Box) can carry any cargo
    // allMatch() returns true only if ALL bogies pass the rule
    // Empty list returns true (vacuous truth — no violations exist)
    public static boolean isSafetyCompliant(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical")
                        || b.cargo.equals("Petroleum"));
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("============================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // VALID
        goodsBogies.add(new GoodsBogie("Open",        "Coal"));      // VALID
        goodsBogies.add(new GoodsBogie("Box",         "Grain"));     // VALID
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));      // INVALID

        // ---- DISPLAY all goods bogies ----
        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b);
        }

        // ---- SAFETY COMPLIANCE CHECK using allMatch() ----
        // Rule : Cylindrical → only Petroleum allowed
        // allMatch() short-circuits on first failure for efficiency
        boolean isSafe = isSafetyCompliant(goodsBogies);

        // ---- DISPLAY safety result ----
        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}