import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Train_AppTest {

    @Test
    void testException_ValidCapacityCreation() throws Train_App.InvalidCapacityException {
        Train_App.PassengerBogie bogie = new Train_App.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(Train_App.InvalidCapacityException.class, () -> {
            new Train_App.PassengerBogie("Sleeper", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(Train_App.InvalidCapacityException.class, () -> {
            new Train_App.PassengerBogie("AC Chair", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Train_App.InvalidCapacityException ex = assertThrows(
                Train_App.InvalidCapacityException.class, () -> {
                    new Train_App.PassengerBogie("First Class", 0);
                }
        );
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Train_App.InvalidCapacityException {
        Train_App.PassengerBogie bogie = new Train_App.PassengerBogie("First Class", 48);
        assertEquals("First Class", bogie.getType());
        assertEquals(48, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Train_App.InvalidCapacityException {
        Train_App.PassengerBogie b1 = new Train_App.PassengerBogie("Sleeper", 72);
        Train_App.PassengerBogie b2 = new Train_App.PassengerBogie("AC Chair", 60);
        Train_App.PassengerBogie b3 = new Train_App.PassengerBogie("First Class", 48);
        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}