import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ========================================================
 * MAIN CLASS - Train_App
 * ========================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime().
 *
 * At this stage, the application:
 * - Creates bogie test dataset
 * - Measures loop execution time
 * - Measures stream execution time
 * - Calculates elapsed duration
 * - Displays performance results
 *
 * This maps performance benchmarking using high-resolution timing.
 *
 * @author Developer
 * @version 13.0
 */
public class Train_App {

    // ---- Bogie model ----
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type     = type;
            this.capacity = capacity;
        }
    }

    // ---- Loop-based filtering ----
    // Traditional for-each loop to filter bogies by capacity threshold
    // Returns a new list — original list is NOT modified
    public static List<Bogie> filterByLoops(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // ---- Stream-based filtering ----
    // Declarative Stream pipeline to filter bogies by capacity threshold
    // Returns a new list — original list is NOT modified
    public static List<Bogie> filterByStreams(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("============================================\n");

        // ---- Create large test dataset ----
        // 100,000 bogies with alternating capacities to ensure both
        // above-threshold and below-threshold entries are present
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            bogies.add(new Bogie("Sleeper", 50 + (i % 60))); // capacity: 50 to 109
        }

        // ---- BENCHMARK: Loop-based filtering ----
        long loopStart    = System.nanoTime();
        List<Bogie> loopResult = filterByLoops(bogies, 60);
        long loopEnd      = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // ---- BENCHMARK: Stream-based filtering ----
        long streamStart    = System.nanoTime();
        List<Bogie> streamResult = filterByStreams(bogies, 60);
        long streamEnd      = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        // ---- DISPLAY performance results ----
        System.out.println("Loop Execution Time   (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);

        System.out.println("\nLoop   filtered count : " + loopResult.size());
        System.out.println("Stream filtered count : " + streamResult.size());

        // ---- DISPLAY winner ----
        System.out.println("\nPerformance Verdict:");
        if (loopDuration < streamDuration) {
            System.out.println("Loop approach was FASTER by "
                    + (streamDuration - loopDuration) + " ns.");
        } else if (streamDuration < loopDuration) {
            System.out.println("Stream approach was FASTER by "
                    + (loopDuration - streamDuration) + " ns.");
        } else {
            System.out.println("Both approaches took equal time.");
        }

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}