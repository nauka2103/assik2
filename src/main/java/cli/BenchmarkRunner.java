package cli;

import algorithms.ShellSort; 
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random rand = new Random();
        String csvFile = "shellsort_results.csv";

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(size);
            }

            PerformanceTracker tracker = new PerformanceTracker();
            ShellSort shellSort = new ShellSort(tracker);

            long start = System.nanoTime();
            shellSort.sort(arr);
            long end = System.nanoTime();

            long timeMs = (end - start) / 1_000_000;

            System.out.println("Size: " + size);
            System.out.println("Time(ms): " + timeMs);
            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Swaps: " + tracker.getSwaps());
            System.out.println("Correctly sorted: " + isSorted(arr));
            System.out.println("------");

            tracker.exportToCSV(csvFile, size, timeMs);
        }

        System.out.println("📊 Results saved to: " + csvFile);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
