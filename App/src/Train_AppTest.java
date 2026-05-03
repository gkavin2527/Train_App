import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Train_App (UC10)
 * Verifies Stream reduce() aggregation behavior across all scenarios.
 */
public class Train_AppTest {

    private List<Train_App.Bogie> bogies;

    @BeforeEach
    void setUp() {
        // Fresh bogie list before each test
        // Total = 72 + 56 + 24 + 70 = 222
        bogies = new ArrayList<>();
        bogies.add(new Train_App.Bogie("Sleeper",     72));
        bogies.add(new Train_App.Bogie("AC Chair",    56));
        bogies.add(new Train_App.Bogie("First Class", 24));
        bogies.add(new Train_App.Bogie("Sleeper",     70));
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        // 72 + 56 + 24 + 70 = 222
        int total = Train_App.getTotalSeatingCapacity(bogies);
        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        // All four bogies must contribute to the total
        int total = Train_App.getTotalSeatingCapacity(bogies);
        assertEquals(222, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Single bogie: total must equal that bogie's capacity
        List<Train_App.Bogie> single = new ArrayList<>();
        single.add(new Train_App.Bogie("Sleeper", 72));
        int total = Train_App.getTotalSeatingCapacity(single);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Empty list: reduce identity value (0) must be returned
        List<Train_App.Bogie> emptyList = new ArrayList<>();
        int total = Train_App.getTotalSeatingCapacity(emptyList);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // Verify map() extracts correct values before reduction
        // Manual sum: 72 + 56 + 24 + 70 = 222
        int expectedTotal = 72 + 56 + 24 + 70;
        int total = Train_App.getTotalSeatingCapacity(bogies);
        assertEquals(expectedTotal, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        // Add extra bogie and verify it is included in the total
        bogies.add(new Train_App.Bogie("General", 100));
        // New total = 222 + 100 = 322
        int total = Train_App.getTotalSeatingCapacity(bogies);
        assertEquals(322, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Original list must remain intact after stream aggregation
        int originalSize = bogies.size();
        Train_App.getTotalSeatingCapacity(bogies);
        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper",     bogies.get(0).name);
        assertEquals("AC Chair",    bogies.get(1).name);
        assertEquals("First Class", bogies.get(2).name);
        assertEquals("Sleeper",     bogies.get(3).name);
    }
}