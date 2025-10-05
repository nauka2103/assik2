package metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long accesses = 0;
    private long allocations = 0;

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addAccess() { accesses++; }
    public void addAllocation() { allocations++; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }
    public long getAllocations() { return allocations; }

    public void reset() {
        comparisons = swaps = accesses = allocations = 0;
    }

 
    public void exportToPrettyCSV(String filename, int trial, long timeMs, int arraySize) {
        boolean fileExists = new File(filename).exists();
        try (FileWriter writer = new FileWriter(filename, true)) {

            if (!fileExists) {
                writer.write("| Trial | Time_ms | Comparisons | Swaps  | Accesses | Allocs |\n");
                writer.write("|-------|----------|-------------|--------|-----------|--------|\n");
            }

            writer.write(String.format(
                    "| %-5d | %-8d | %-11d | %-6d | %-9d | %-6d |\n",
                    trial, timeMs, comparisons, swaps, accesses, allocations
            ));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
