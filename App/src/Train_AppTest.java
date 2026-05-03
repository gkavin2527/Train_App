import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Train_AppTest {

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        Train_App.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        Train_App.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        Train_App.bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 56, 72}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        Train_App.bubbleSort(arr);
        assertArrayEquals(new int[]{50}, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        Train_App.bubbleSort(arr);
        assertArrayEquals(new int[]{40, 40, 40}, arr);
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