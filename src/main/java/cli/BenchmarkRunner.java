package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String MAGENTA = "\u001B[35m";

    public static void main(String[] args) {
        int trials = 5;
        int arraySize = 20000;
        String csvFile = "shellsort_table.csv";

        System.out.println(MAGENTA + "\n  Shell Sort Benchmark — " + arraySize + " elements" + RESET);
        System.out.println(CYAN + "--------------------------------------------------" + RESET);

        for (int t = 1; t <= trials; t++) {
            int[] arr = generateRandomArray(arraySize);
            PerformanceTracker tracker = new PerformanceTracker();
            ShellSort shellSort = new ShellSort(tracker);

            long start = System.nanoTime();
            shellSort.sort(arr);
            long end = System.nanoTime();

            long timeMs = (end - start) / 1_000_000;

            System.out.printf(GREEN + "Trial %d:%s Time = %d ms | Comparisons = %d | Swaps = %d%n" + RESET,
                    t, RESET, timeMs, tracker.getComparisons(), tracker.getSwaps());

            tracker.exportToPrettyCSV(csvFile, t, timeMs, arraySize);
        }

        System.out.println(YELLOW + "\n Table exported to " + csvFile + RESET);
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size);
        return arr;
    }
}
