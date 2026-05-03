import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Train_AppTest {

    @Test
    void testCargo_SafeAssignment() {
        Train_App.GoodsBogie bogie = new Train_App.GoodsBogie("Cylindrical");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        Train_App.GoodsBogie bogie = new Train_App.GoodsBogie("Rectangular");
        // Exception is caught inside assignCargo, so no throw propagates
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Train_App.GoodsBogie bogie = new Train_App.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        Train_App.GoodsBogie b1 = new Train_App.GoodsBogie("Rectangular");
        Train_App.GoodsBogie b2 = new Train_App.GoodsBogie("Cylindrical");
        // Both should complete without crashing
        assertDoesNotThrow(() -> {
            b1.assignCargo("Petroleum");
            b2.assignCargo("Petroleum");
        });
        assertNull(b1.getCargo());
        assertEquals("Petroleum", b2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        Train_App.GoodsBogie bogie = new Train_App.GoodsBogie("Rectangular");
        // finally always runs; method completes without propagating exception
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}