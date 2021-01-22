
//Generate random arrays and store them
public class DataGenerator {

	//2D[] to store the random arrays (same arrays for different algorithms for same input size)
	private int[][] block;

	//Constructor to initialize the I.V.
	public DataGenerator(int numberOfTests) {
		this.block = new int[numberOfTests][];
	}

	//Method to send the array to test. Returns a copy of the array to keep it unsorted for the rest of algorithms
	public int[] getTest(int numberOfTest) {
		return block[numberOfTest].clone();
	}

	//Method to generate the Arrays for each Input size
	public void generateArrays(int n) {
		//Loop 10 times
		for(int i = 0; i < block.length; i++) {
			//Call to generate a random array and store it in the 2D array
			block[i] = generateRandomArray(n);
		}
	}

	//Method to generate an Array with random numbers
	//Code source: Project specifications
	//Parameter: size of the array
	private int[] generateRandomArray(int n) {
		//Declare and initialize an array of integer with size "n"
		int[] array = new int[n];
		//Loop over the array
		for(int i = 0; i < n; i++) {
			/*Assign to each index a random number
			  Math.random generates a random number between 0.0-1.0
			  Multiply by 100 to get the number between 0-99
			  Cast to int to eliminate decimals*/
			array[i] = (int) (Math.random() * 100);
		}
		//Return the array full with random numbers
		return array;
	}
}
