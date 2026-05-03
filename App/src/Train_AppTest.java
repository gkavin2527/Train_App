import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Train_App (UC13)
 * Verifies loop vs stream filtering logic, result consistency,
 * execution time measurement, and large dataset processing.
 */
public class Train_AppTest {

    private List<Train_App.Bogie> bogies;

    @BeforeEach
    void setUp() {
        // Standard test dataset before each test
        bogies = new ArrayList<>();
        bogies.add(new Train_App.Bogie("Sleeper",     72));
        bogies.add(new Train_App.Bogie("AC Chair",    56));
        bogies.add(new Train_App.Bogie("First Class", 24));
        bogies.add(new Train_App.Bogie("General",     90));
        bogies.add(new Train_App.Bogie("Sleeper",     60)); // boundary — not included (> not >=)
    }

    @Test
    void testLoopFilteringLogic() {
        // Loop filter: capacity > 60 → Sleeper(72), General(90)
        List<Train_App.Bogie> result = Train_App.filterByLoops(bogies, 60);
        assertEquals(2, result.size());
        // Verify capacities of returned bogies are all > 60
        for (Train_App.Bogie b : result) {
            assertTrue(b.capacity > 60,
                    "Loop filter returned bogie with capacity <= 60");
        }
    }

    @Test
    void testStreamFilteringLogic() {
        // Stream filter: capacity > 60 → Sleeper(72), General(90)
        List<Train_App.Bogie> result = Train_App.filterByStreams(bogies, 60);
        assertEquals(2, result.size());
        // Verify capacities of returned bogies are all > 60
        for (Train_App.Bogie b : result) {
            assertTrue(b.capacity > 60,
                    "Stream filter returned bogie with capacity <= 60");
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        // Both approaches must produce identical result sizes
        List<Train_App.Bogie> loopResult   = Train_App.filterByLoops(bogies, 60);
        List<Train_App.Bogie> streamResult = Train_App.filterByStreams(bogies, 60);
        assertEquals(loopResult.size(), streamResult.size(),
                "Loop and Stream filtering produced different result sizes");
    }

    @Test
    void testExecutionTimeMeasurement() {
        // Elapsed time must be a positive non-zero value
        long start  = System.nanoTime();
        Train_App.filterByLoops(bogies, 60);
        long end     = System.nanoTime();
        long elapsed = end - start;
        assertTrue(elapsed > 0,
                "Execution time must be greater than zero");
    }

    @Test
    void testLargeDatasetProcessing() {
        // Generate 100,000 bogies and verify both approaches work correctly
        List<Train_App.Bogie> largeBogies = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            largeBogies.add(new Train_App.Bogie("Sleeper", 50 + (i % 60)));
        }

        List<Train_App.Bogie> loopResult   = Train_App.filterByLoops(largeBogies, 60);
        List<Train_App.Bogie> streamResult = Train_App.filterByStreams(largeBogies, 60);

        // Both must return the same count on large dataset
        assertEquals(loopResult.size(), streamResult.size(),
                "Large dataset: Loop and Stream produced different counts");

        // Result must be non-empty since dataset contains capacity > 60
        assertTrue(loopResult.size() > 0,
                "Large dataset: Expected non-empty filtered result");
    }
}