import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code (Regex)
 *
 * Description:
 * This class validates input formats using Regular Expressions.
 *
 * At this stage, the application:
 * - Accepts Train ID input
 * - Accepts Cargo Code input
 * - Applies regex validation
 * - Displays validation result
 *
 * This maps format validation logic using Pattern matching.
 *
 * @author Developer
 * @version 11.0
 */
public class Train_App {

    // ---- REGEX PATTERNS ----
    // Train ID  : TRN- followed by exactly 4 digits
    // Cargo Code: PET- followed by exactly 2 uppercase letters
    private static final String TRAIN_ID_PATTERN    = "TRN-\\d{4}";
    private static final String CARGO_CODE_PATTERN  = "PET-[A-Z]{2}";

    // ---- Reusable validation methods for testability ----

    // Validates Train ID against TRN-\d{4} pattern
    public static boolean isValidTrainId(String trainId) {
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    // Validates Cargo Code against PET-[A-Z]{2} pattern
    public static boolean isValidCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("============================================\n");

        Scanner scanner = new Scanner(System.in);

        // ---- Accept input from user ----
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        // Pattern.compile() compiles the regex for reuse
        // Matcher.matches() checks if the ENTIRE string matches
        boolean trainIdValid   = isValidTrainId(trainId);
        boolean cargoCodeValid = isValidCargoCode(cargoCode);

        // ---- DISPLAY validation results ----
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid   : " + trainIdValid);
        System.out.println("Cargo Code Valid : " + cargoCodeValid);

        // ---- Show descriptive feedback ----
        if (!trainIdValid) {
            System.out.println("  [ERROR] Train ID must follow format: TRN-XXXX (4 digits)");
        }
        if (!cargoCodeValid) {
            System.out.println("  [ERROR] Cargo Code must follow format: PET-XX (2 uppercase letters)");
        }
        if (trainIdValid && cargoCodeValid) {
            System.out.println("  [SUCCESS] All inputs are valid. Train is ready for dispatch.");
        }

        System.out.println("\nUC11 validation completed...");
        scanner.close();
    }
}