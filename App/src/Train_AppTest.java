import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Train_AppTest {

    private final String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testSearch_BogieFound() {
        assertTrue(Train_App.linearSearch(bogieIds, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        assertFalse(Train_App.linearSearch(bogieIds, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        assertTrue(Train_App.linearSearch(bogieIds, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        assertTrue(Train_App.linearSearch(bogieIds, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        assertTrue(Train_App.linearSearch(new String[]{"BG101"}, "BG101"));
    }
}