# ASSIGNMENT-2


# ShellSort Benchmark and Performance Analysis


## Overview

This project implements the Shell Sort algorithm in Java with performance tracking and benchmarking tools.
It measures the performance of sorting operations and records key metrics such as comparisons, swaps, array accesses, and execution time.

The project includes:

* Full Shell Sort implementation
* Performance tracking
* Command-line benchmark runner
* CSV results export
* Unit tests for validation
* Performance plots and analysis report

---

## Project Structure

```
assignment2-shellsort/
├── src/
│   ├── main/java/
│   │   ├── algorithms/ShellSort.java
│   │   ├── metrics/PerformanceTracker.java
│   │   └── cli/BenchmarkRunner.java
│   └── test/java/
│       └── algorithms/ShellSortTest.java
├── docs/
│   ├── analysis-report.pdf
│   └── performance-plots/
│       ├── runtime-vs-input.png
│       └── comparisons-vs-swaps.png
├── shellsort-results.csv
├── README.md
└── pom.xml
```

---


### PerformanceTracker

Tracks:

* Comparisons
* Swaps
* Array accesses
* Memory allocations

---

## Benchmark Runner

The `BenchmarkRunner` runs multiple trials and outputs timing and metric data.
It also saves the results to `shellsort-results.csv`.

**Example output:**

```
Benchmark ShellSort (size=10000, trials=5)
Trial 1: time=11 ms, Comparisons=229097, Swaps=119376, Accesses=20000, Allocs=0
Trial 2: time=4 ms, Comparisons=229156, Swaps=119301, Accesses=20000, Allocs=0
Trial 3: time=3 ms, Comparisons=229495, Swaps=119644, Accesses=20000, Allocs=0
Trial 4: time=3 ms, Comparisons=229392, Swaps=119569, Accesses=20000, Allocs=0
Trial 5: time=3 ms, Comparisons=229571, Swaps=119732, Accesses=20000, Allocs=0
```

---

## Running the Benchmark

Compile and run with Maven:

```bash
mvn clean compile exec:java -Dexec.mainClass="cli.BenchmarkRunner"
```

Or run directly from Java:

```bash
java -cp target/classes cli.BenchmarkRunner
```

The program prints results to the console and writes them into `minheap-results.csv`.

---

## Unit Testing

JUnit 5 test cases validate:

* Empty array
*  Single element
* Sorted array
* Reverse array
* Random input


Run all tests:

```bash
mvn test
```

---

## Performance Plots

Performance data from `minheap-results.csv` is visualized in:

* **runtime-vs-input.png** – shows runtime scaling
* **comparisons-vs-swaps.png** – shows correlation of operations

Example :
![img.png](<img width="361" height="217" alt="image" src="https://github.com/user-attachments/assets/7218fbac-27ca-419a-9ffd-b9c8a119e434" />
)


---

## Analysis Report

The `analysis-report.pdf` includes:

* Theoretical vs. experimental complexity
*  Benchmark setup
*  Charts and graphs
* Discussion of results
*  Conclusions and future improvements

---

## Future Improvements

* Compare Shell Sort with Heap Sort and Quick Sort
* Implement adaptive gap sequences
*  Integrate JMH for advanced benchmarking
*  Add GUI-based visualization
*  Track memory footprint and garbage collection
---

## Conclusion

This project demonstrates the practical performance behavior of the Shell Sort algorithm.
It connects theoretical analysis with experimental results through benchmarking, CSV export, and structured documentation.
The combination of algorithmic efficiency, clean Java code, and data-driven analysis makes it a solid foundation for algorithm performance evaluation.
---

