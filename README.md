# Sorting Algorithms Benchmark

##### Author: Andres Penas Palmeiro
##### Final Project for the Module "Computational Thinking with Algorithms" of the H.Dip in Computer Science in Software Development - GMIT
##### Version 1.0 (Jun 2020)

## Summary
This application benchmarks five different sorting algorithms and outputs the result on a CSV format. A Report introducing the algorithms and discussing the result is also included.

### Algorithms Benchmarked
* Bubble Sort
* Selection Sort
* Insertion Sort
* Merge Sort
* Radix Sort

All the Algorithms are heavily commented detailing step by step their internal logic.

### Benchmarking Mechanism

Each Sorting Algorithm is benchmarked using arrays of randomly generated integers of different sizes. The running time of each Algorithm is calculated by the average of the running time of each Algorithm and each input size measured 10 times (new array of random integers for each run).

Sizes of randomly generated integers used: 100 | 500 | 1,000 | 2,500 | 5,000 | 7,500 | 10,000 | 15,000 | 20,000 | 25,000

Example: The running time for Bubble Sort on Size 100 is the average running time of Bubble Sort sorting 100 random integers 10 times.

### Report Overview
The Report explains step by step the internal logic of the different sorting algorithms used in the Benchmark, with examples and drawings to follow the different steps and discussing their time and space complexity; the explanation of the best, average and worst scenario is analyzed too and the implementation of each algorithm is explained.

Finally, an analysis of the results is made with the help of Statistical graphics.

#### Examples:
<p align="center">
    <img src="https://imgur.com/btQ9Sxg.jpeg" alt="HomePage" width="500"/>
</p>

<p align="center">
    <img src="https://imgur.com/xbEfn9H.jpeg" alt="HomePage" width="500"/>
</p>
<p align="center">
    <img src="https://imgur.com/W7zndqe.jpeg" alt="HomePage" width="500"/>
</p>
<p align="center">
    <img src="https://imgur.com/5YyPyve.jpeg" alt="HomePage" width="500"/>
</p>


## Technologies
Java

## Requirements
JAVA JRE 8 (or superior)

## Launch
Compile and run the "Runner" from the Command Prompt.

## Usage
The results will be printed in console and exported to a CSV file in the root directory.

## License
MIT License. See "LICENSE" for further information.

## Contact Information
G00376379@gmit.ie