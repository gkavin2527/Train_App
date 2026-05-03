import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Train_App (UC11)
 * Verifies Regex validation behavior for Train ID and Cargo Code.
 */
public class Train_AppTest {

    // ============================================================
    // TRAIN ID TESTS
    // ============================================================

    @Test
    void testRegex_ValidTrainID() {
        // TRN- followed by exactly 4 digits must be valid
        assertTrue(Train_App.isValidTrainId("TRN-1234"));
        assertTrue(Train_App.isValidTrainId("TRN-6524"));
        assertTrue(Train_App.isValidTrainId("TRN-0000"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Wrong prefix, letters in numeric part, reversed format
        assertFalse(Train_App.isValidTrainId("TRAIN12"));   // wrong prefix
        assertFalse(Train_App.isValidTrainId("TRN12A"));    // no hyphen, letter at end
        assertFalse(Train_App.isValidTrainId("1234-TRN"));  // reversed format
        assertFalse(Train_App.isValidTrainId("trn-1234"));  // lowercase prefix
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Must have exactly 4 digits — 3 or 5 digits must be rejected
        assertFalse(Train_App.isValidTrainId("TRN-123"));    // only 3 digits
        assertFalse(Train_App.isValidTrainId("TRN-12345"));  // 5 digits
        assertFalse(Train_App.isValidTrainId("TRN-12"));     // only 2 digits
        assertTrue(Train_App.isValidTrainId("TRN-1234"));    // exactly 4 digits
    }

    // ============================================================
    // CARGO CODE TESTS
    // ============================================================

    @Test
    void testRegex_ValidCargoCode() {
        // PET- followed by exactly 2 uppercase letters must be valid
        assertTrue(Train_App.isValidCargoCode("PET-AB"));
        assertTrue(Train_App.isValidCargoCode("PET-FH"));
        assertTrue(Train_App.isValidCargoCode("PET-ZZ"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Wrong format variations must be rejected
        assertFalse(Train_App.isValidCargoCode("PET123"));   // no hyphen
        assertFalse(Train_App.isValidCargoCode("AB-PET"));   // reversed format
        assertFalse(Train_App.isValidCargoCode("PETAB"));    // missing hyphen
        assertFalse(Train_App.isValidCargoCode("PET-A1"));   // digit in suffix
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Lowercase letters in suffix must be rejected
        assertFalse(Train_App.isValidCargoCode("PET-ab"));   // all lowercase
        assertFalse(Train_App.isValidCargoCode("PET-Ab"));   // mixed case
        assertFalse(Train_App.isValidCargoCode("PET-aB"));   // mixed case
        assertTrue(Train_App.isValidCargoCode("PET-AB"));    // valid uppercase
    }

    // ============================================================
    // EDGE CASE TESTS
    // ============================================================

    @Test
    void testRegex_EmptyInputHandling() {
        // Empty strings must return invalid for both validations
        assertFalse(Train_App.isValidTrainId(""));
        assertFalse(Train_App.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Extra characters beyond the pattern must be rejected
        // matches() checks the ENTIRE string, not partial matches
        assertFalse(Train_App.isValidTrainId("TRN-1234X"));    // extra char at end
        assertFalse(Train_App.isValidTrainId("XTRN-1234"));    // extra char at start
        assertFalse(Train_App.isValidCargoCode("PET-ABC"));    // 3 letters instead of 2
        assertFalse(Train_App.isValidCargoCode("PET-A"));      // only 1 letter
        assertFalse(Train_App.isValidCargoCode(" PET-AB"));    // leading space
        assertFalse(Train_App.isValidCargoCode("PET-AB "));    // trailing space
    }
}