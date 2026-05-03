/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Description:
 * This class prevents creation of passenger bogies
 * with invalid seating capacity using a custom exception.
 *
 * At this stage, the application:
 * - Defines a custom exception
 * - Validates capacity inside constructor
 * - Throws exception if capacity <= 0
 * - Prevents invalid bogie creation
 * - Continues execution safely
 *
 * This maps fail-fast validation using checked exceptions.
 *
 * @author Developer
 * @version 14.0
 */
public class Train_App {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- Passenger Bogie model with validation ----
    static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    // ---- MAIN ----
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity");
        System.out.println("==============================================");
        System.out.println();

        // Valid bogie
        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Invalid bogie (zero capacity)
        try {
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + b2);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("UC14 exception handling completed...");
    }
}