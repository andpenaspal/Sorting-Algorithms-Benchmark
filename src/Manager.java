import java.text.DecimalFormat;

//Class to manage the creation of test cases, the collection and storage and print of the results
public class Manager {

	private String[] sortingAlg;
	private int[] sizes;

	public Manager(String[] sortingAlgs, int[] inputSizes) {
		this.sortingAlg = sortingAlgs;
		this.sizes = inputSizes;
	}

	//Method to store all the results
	public void getAllData(int numberOfTest) {
		//Create object Tester with the number of test specified
		Tester test = new Tester(numberOfTest);
		//Variables of the length of the 2D array with the data. 
		int nCol = sizes.length;
		int nRow = sortingAlg.length;
		//2D array to store the data
		//String as the Decimal Conversion returns Strings
		double[][] data = new double[nRow][nCol];
		//Loop over the columns of the 2D data array
		for(int j = 0; j < nCol; j++) {
			//Generate random Arrays [j = index of the Array with the Number of Input Data]
			//One set of random Arrays repeated over all the sorting algorithms
			test.generateArrays(sizes[j]);
			//Print to keep track of the operation
			System.out.println("Analyzing Algorithms' Performance for " + sizes[j] + " inputs...");
			//Random Arrays generated and stored in 2D IV. Loop over the 2D array
			for(int i = 0; i < nRow; i++) {
				//Select one algorithm from the Array storing their names and assign it to the IV. 
				String sortingAlgSelected = sortingAlg[i];
				//Indicate to the Tester which one should test
				test.setSortingAlgSelected(sortingAlgSelected);
				//Store in the 2D Array Data the average time of the selected algorithm sorting 
				//the generated random arrays with the number of inputs selected
				data[i][j] = test.getAverageTime();
			}
		}
		//Send the data to print
		printAllData(data);
	}

	//Method to print all the data
	private void printAllData(double[][] data) {
		//New array to include "Time"
		String[] printSizes = new String[sizes.length + 1];
		printSizes[0] = "Size";
		//Variable for the printSizes[]
		int z = 0;
		//Loop to fill the new array with the "n" sizes used
		for(int i = 1; i < printSizes.length; i++) {
			printSizes[i] = Integer.toString(sizes[z]);
			z++;
		}

		//Decimal format for storage
		DecimalFormat df = new DecimalFormat("#.000");
		//Object to Write .csv file
		Writer writer = new Writer();

		//Title
		System.out.println("\nSorting Algorithms Benchmarking");

		//Print all data
		//Loop to print the first row (printSizes[])
		for(int i = 0; i < printSizes.length; i++) {
			//Print
			System.out.printf("%-11s", printSizes[i]);
			//Store data
			writer.store(printSizes[i]);
		}
		System.out.printf("%n");
		writer.store("\n");
		//Loop to print all data stored in the 2D[] with the results of the benchmarking
		for(int i = 0; i < data.length; i++) {
			//Print the first column with format aligning to the left leaving 11 spaces between columns
			//Print the correspondent name of the algorithm at the beginning of each row
			System.out.printf("%-11s", sortingAlg[i]);
			//Store it
			writer.store(sortingAlg[i]);
			for(int j = 0; j < data[0].length; j++) {
				//Print data value of this row with floats rounding to 3 decimals (each column for this row)
				System.out.printf("%-11.3f", data[i][j]);
				//Store it applying 3 decimals format
				writer.store(df.format(data[i][j]));
			}
			System.out.printf("%n");
			writer.store("\n");
		}
		//Write to .csv
		writer.csvWriter();
	}
}
