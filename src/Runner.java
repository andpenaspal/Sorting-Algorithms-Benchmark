
//Class to start the Benchmarking
public class Runner {
	
	/*
	 * Andres Penas Palmeiro
	 * G00376379
	 * GMIT - Computational Thinking with Algorithms
	 * 2020
	 * 
	 * */
	
	//Main method
	public static void main(String[] args) {
		//Sorting Algorithms to test
		//To analyze different algorithms:
		//Implement them in "SortingAlgorithms", ad Switch cases in "Tester.callAlg" to call them
		String[] sortingAlgs = new String[] {"Bubble", "Selection", "Insertion", "Merge", "Radix"};

		//Number of different test for each Input Size and each Algorithm (Result will be the average of all)
		int numberOfTest = 10;

		//Input sizes to test
		int[] inputSizes = new int[] {100, 500, 1000, 2500, 5000, 7500, 10000, 15000, 20000, 25000};

		//New object Manager(Algorithms to test, input sizes to test)
		Manager go = new Manager(sortingAlgs, inputSizes);

		//Initialize test
		go.getAllData(numberOfTest);
	}

}
