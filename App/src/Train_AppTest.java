import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Train_AppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> {
            Train_App.searchBogie(new String[]{}, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        assertDoesNotThrow(() -> {
            Train_App.searchBogie(new String[]{"BG101", "BG205"}, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        assertTrue(Train_App.searchBogie(
                new String[]{"BG101", "BG205", "BG309"}, "BG205"
        ));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        assertFalse(Train_App.searchBogie(
                new String[]{"BG101", "BG205", "BG309"}, "BG999"
        ));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        assertTrue(Train_App.searchBogie(new String[]{"BG101"}, "BG101"));
    }
}