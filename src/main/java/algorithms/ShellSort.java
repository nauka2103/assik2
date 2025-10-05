package algorithms;

import metrics.PerformanceTracker;

public class ShellSort {

    private final PerformanceTracker tracker;

    public ShellSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    //
    public void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        // Начальный шаг (gap) = половина длины массива, уменьшаем в 2 раза каждый раз
        for (int gap = n >>> 1; gap > 0; gap >>>= 1) {

            // Проходим по всем элементам начиная с gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // Сортировка вставками с шагом gap
                while (j >= gap) {
                    tracker.addComparison();
                    if (arr[j - gap] <= temp) break;

                    tracker.addSwap(); // смещение элемента на gap вправо
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }
}