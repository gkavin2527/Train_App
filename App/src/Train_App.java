/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 *
 * Description:
 * This class safely assigns cargo to goods bogies
 * while handling unsafe combinations using structured
 * exception handling blocks.
 *
 * At this stage, the application:
 * - Defines a custom runtime exception
 * - Validates cargo assignment rules
 * - Throws exception for unsafe cargo
 * - Catches and handles the exception
 * - Executes finally block for logging
 *
 * This maps runtime safety handling using try-catch-finally.
 *
 * @author Developer
 * @version 15.0
 */
public class Train_App {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ---- Goods Bogie model ----
    public static class GoodsBogie {
        String shape;
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public String getShape() { return shape; }
        public String getCargo() { return cargo; }

        // Assign cargo with safety validation
        public void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC15 - Safe Cargo Assignment");
        System.out.println("==============================================");
        System.out.println();

        // Valid assignment
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        // Invalid assignment
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println();
        System.out.println("UC15 runtime handling completed...");
    }
}