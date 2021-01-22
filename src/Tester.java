//Class to perform the tests
public class Tester {
	//Number of test per input size and algorithm
	private int numberOfTest;
	//Object to test(sort) the arrays
	private SortingAlgorithms testSort;
	//Object to generate the random arrays
	private DataGenerator dg;
	//Algorithm selected for the test
	private String sortingAlgSelected;

	//Constructor
	public Tester(int numberOfTest) {
		testSort = new SortingAlgorithms();
		dg = new DataGenerator(numberOfTest);
		this.numberOfTest = numberOfTest;
	}

	//Method to get generate the Arrays for the test
	public void generateArrays(int size) {
		dg.generateArrays(size);
	}

	//Method to get the average time
	public double getAverageTime() {
		//Variable to store the average time
		double averageTime;
		//Variable to store the return of the method. Call the method to get the 10 running times
		double[] runningTimes = getRunningTimes();
		//Variable to perform arithmetics
		double totalTime = 0;
		//Loop over the array with all times
		for(int i = 0; i < runningTimes.length; i++) {
			//Add them
			totalTime += runningTimes[i];
		}
		//Get the average time: all times divided by the number of times
		averageTime = totalTime/runningTimes.length;
		//Return the result
		return averageTime;
	}

	//Method to set the Algorithm selected by Manager.getAllData
	public void setSortingAlgSelected(String sortingAlgSelected) {
		this.sortingAlgSelected = sortingAlgSelected;
	}

	//Method to measure running time
	//Code source: Project specifications with modifications
	private double[] getRunningTimes() {
		//Array to store all the times ()
		double[] times = new double[numberOfTest];
		//Loop the number of test times (different random arrays for each input size)
		for(int i = 0; i < times.length; i++) {
			//Get the array to test
			int[] test = dg.getTest(i);
			//Check the time with nano precision
			long startTime = System.nanoTime();
			//Call the method to perform the sorting passing the copy of the array
			callAlg(test);
			//Check the time once the sorting has been done
			long endTime = System.nanoTime();
			//Calculate the time elapsed
			long timeElapsedNanos = endTime-startTime;
			//Convert to milliseconds
			double timeElapsedMillis = timeElapsedNanos/1000000.0;
			//Save the time in the Array of times
			times[i] = timeElapsedMillis;
		}
		//All times have been gotten, return the array with the results
		return times;
	}

	//Method to switch between algorithms
	private void callAlg(int[] toSort) {
		//Switch based on Instance Variable
		switch (sortingAlgSelected) {
		case "Bubble":
			//Call the method with the Array as parameter
			testSort.bubble(toSort);
			//After sorting the array, break the statement
			break;
		case "Selection":
			testSort.selection(toSort);
			break;
		case "Insertion":
			testSort.insertion(toSort);
			break;
		case "Merge":
			testSort.sort(toSort, 0, toSort.length - 1);
			break;
		case "Radix":
			testSort.radix(toSort, toSort.length);
			break;
			//If no correct value passed to the switch statement, throw the message
		default:
			throw new IllegalArgumentException("Unexpected value: " + sortingAlgSelected);
		}
	}
}
