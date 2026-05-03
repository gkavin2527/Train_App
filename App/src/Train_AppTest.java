import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Train_App (UC8)
 * Verifies Stream filtering behavior across all scenarios.
 */
public class Train_AppTest {

    private List<Train_App.Bogie> bogies;

    @BeforeEach
    void setUp() {
        // Fresh bogie list before each test
        bogies = new ArrayList<>();
        bogies.add(new Train_App.Bogie("Sleeper",     72));
        bogies.add(new Train_App.Bogie("AC Chair",    56));
        bogies.add(new Train_App.Bogie("First Class", 24));
        bogies.add(new Train_App.Bogie("General",     90));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Bogies with capacity > 70: Sleeper(72), General(90)
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(bogies, 70);
        assertEquals(2, result.size());
        assertEquals("Sleeper", result.get(0).name);
        assertEquals("General", result.get(1).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Sleeper(72) is excluded since filter is strictly >
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(bogies, 72);
        assertEquals(1, result.size());
        assertEquals("General", result.get(0).name);
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        // threshold=100 excludes all bogies
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(bogies, 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        // threshold=50: Sleeper(72) and General(90) both qualify
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(bogies, 50);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        // threshold=200: no bogie qualifies
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(bogies, 200);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        // threshold=0: all bogies qualify
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(bogies, 0);
        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        // Filtering an empty list returns empty list without error
        List<Train_App.Bogie> emptyList = new ArrayList<>();
        List<Train_App.Bogie> result =
                Train_App.filterByCapacity(emptyList, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        // Original list must remain intact after stream processing
        int originalSize = bogies.size();
        Train_App.filterByCapacity(bogies, 60);
        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper",     bogies.get(0).name);
        assertEquals("AC Chair",    bogies.get(1).name);
        assertEquals("First Class", bogies.get(2).name);
        assertEquals("General",     bogies.get(3).name);
    }
}