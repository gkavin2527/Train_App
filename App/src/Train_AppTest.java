import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Test class for Train_App (UC9)
 * Verifies Stream groupingBy behavior across all scenarios.
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
        bogies.add(new Train_App.Bogie("Sleeper",     70));
        bogies.add(new Train_App.Bogie("AC Chair",    60));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Bogies with same name must appear under same Map key
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(bogies);
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        // Sleeper appears twice — both must be in the same group
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(bogies);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        // Three distinct types must produce three separate keys
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(bogies);
        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // Grouping an empty list must return an empty Map without errors
        List<Train_App.Bogie> emptyList = new ArrayList<>();
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        // Only one bogie type — Map must contain exactly one key
        List<Train_App.Bogie> singleType = new ArrayList<>();
        singleType.add(new Train_App.Bogie("Sleeper", 72));
        singleType.add(new Train_App.Bogie("Sleeper", 70));
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(singleType);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        // Verify all expected bogie type keys exist in the Map
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(bogies);
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        // Sleeper group = 2, AC Chair group = 2, First Class group = 1
        Map<String, List<Train_App.Bogie>> result =
                Train_App.groupByType(bogies);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // Original list must remain intact after grouping
        int originalSize = bogies.size();
        Train_App.groupByType(bogies);
        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper",     bogies.get(0).name);
        assertEquals("AC Chair",    bogies.get(1).name);
        assertEquals("First Class", bogies.get(2).name);
        assertEquals("Sleeper",     bogies.get(3).name);
        assertEquals("AC Chair",    bogies.get(4).name);
    }
}