import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Train_App (UC12)
 * Verifies safety compliance check behavior for goods bogies.
 *
 * Safety Rule:
 * Cylindrical bogies must carry ONLY Petroleum.
 * Non-cylindrical bogies (Open, Box) can carry any cargo.
 */
public class Train_AppTest {

    @Test
    void testSafety_AllBogiesValid() {
        // All cylindrical bogies carry Petroleum — train is SAFE
        List<Train_App.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new Train_App.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new Train_App.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new Train_App.GoodsBogie("Open",        "Coal"));
        bogies.add(new Train_App.GoodsBogie("Box",         "Grain"));

        assertTrue(Train_App.isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        // Cylindrical bogie carrying Coal — rule violation → UNSAFE
        List<Train_App.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new Train_App.GoodsBogie("Cylindrical", "Coal"));

        assertFalse(Train_App.isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        // Open and Box bogies can carry any cargo — no rule violation
        List<Train_App.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new Train_App.GoodsBogie("Open", "Coal"));
        bogies.add(new Train_App.GoodsBogie("Open", "Grain"));
        bogies.add(new Train_App.GoodsBogie("Box",  "Coal"));
        bogies.add(new Train_App.GoodsBogie("Box",  "Petroleum"));

        assertTrue(Train_App.isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        // One Cylindrical carries Coal — entire train is UNSAFE
        List<Train_App.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new Train_App.GoodsBogie("Cylindrical", "Petroleum")); // valid
        bogies.add(new Train_App.GoodsBogie("Open",        "Coal"));      // valid
        bogies.add(new Train_App.GoodsBogie("Box",         "Grain"));     // valid
        bogies.add(new Train_App.GoodsBogie("Cylindrical", "Coal"));      // VIOLATION

        assertFalse(Train_App.isSafetyCompliant(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        // Empty list → no violations exist → allMatch() returns true
        List<Train_App.GoodsBogie> emptyList = new ArrayList<>();

        assertTrue(Train_App.isSafetyCompliant(emptyList));
    }
}