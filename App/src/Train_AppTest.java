import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Train_AppTest {

    private final String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testBinarySearch_BogieFound() {
        assertTrue(Train_App.binarySearch(bogieIds.clone(), "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        assertFalse(Train_App.binarySearch(bogieIds.clone(), "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        assertTrue(Train_App.binarySearch(bogieIds.clone(), "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        assertTrue(Train_App.binarySearch(bogieIds.clone(), "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        assertTrue(Train_App.binarySearch(new String[]{"BG101"}, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        assertFalse(Train_App.binarySearch(new String[]{}, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] unsorted = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(Train_App.binarySearch(unsorted, "BG205"));
    }
}