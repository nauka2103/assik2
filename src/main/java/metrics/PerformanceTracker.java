package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    public void exportToCSV(String filename, int size, long timeMs) {
        boolean fileExists = new java.io.File(filename).exists();
        try (FileWriter writer = new FileWriter(filename, true)) {
            if (!fileExists) {
                writer.write("ArraySize,Time(ms),Comparisons,Swaps\n");
            }
            writer.write(size + "," + timeMs + "," + comparisons + "," + swaps + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
