import java.util.LinkedList;
import java.util.List;

/**
 * ========================================================
 * MAIN CLASS - UseCase4TrainConsistMgmnt
 * ========================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 *
 * At this stage, the application:
 * - Adds bogies in sequence
 * - Inserts bogies at specific positions
 * - Removes bogies from front and rear
 * - Displays updated train structure
 *
 * This maps positional operations using LinkedList.
 *
 * @author Developer
 * @version 4.0
 */
public class Train_App {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("====================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("====================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        LinkedList<String> trainConsist = new LinkedList<>();

        // ---- ADD bogies in sequence ----
        // addLast() appends each bogie to the end of the train
        trainConsist.addLast("Engine");
        trainConsist.addLast("Sleeper");
        trainConsist.addLast("AC");
        trainConsist.addLast("Cargo");
        trainConsist.addLast("Guard");

        // ---- READ: Display initial consist ----
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // ---- INSERT at specific position ----
        // add(index, element) inserts 'Pantry Car' at position 2
        // Positions: 0=Engine, 1=Sleeper, 2=Pantry Car (inserted), 3=AC, 4=Cargo, 5=Guard
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        // ---- REMOVE from front and rear ----
        // removeFirst() detaches the locomotive (Engine)
        // removeLast() detaches the guard coach (Guard)
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}