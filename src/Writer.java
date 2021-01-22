import java.io.*;
import java.util.*;

//Class to store results of Benchmarking, create a file and write in it
public class Writer {
	//Instance variable to store the results
	private List<String> storedResults;

	//Constructor
	public Writer(){
		this.storedResults = new ArrayList<String>();
	}

	//Method to store the results in the Array list
	public void store(String pieceOfData) {
		storedResults.add(pieceOfData);
		//Add "," for CSV file for different values. Avoid it on "new line"
		if(pieceOfData != "\n") storedResults.add(",");
	}

	//Method to write the CSV File
	//If successfully created a new file, write in it the data from the Array list
	public void csvWriter() {
		try {
			File benchMarkingResults = new File("./BenchmarkingResults.csv");
			if(benchMarkingResults.createNewFile()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(benchMarkingResults));
				//Loop to write stored results
				for(String i : storedResults) {
					bw.write(i);
				}
				//Make sure the buffer is empty
				bw.flush();
				//Close to avoid leaks
				bw.close();
				System.out.println("\nBenchmarking Results succesfully stored in \"BenchmarkingResults\" File");
			}else{
				//If file already exists
				System.out.println("\n\"BenchmarkingResults\" file already exists "
						+ "in \"" + benchMarkingResults.getAbsolutePath() + "\""
						+ "\nWARNING: Results NOT saved in File");
			}
		} catch (Exception e) {
			System.out.println("An error trying to store the results in a File has ocurred.");
			e.printStackTrace();
		}
	}
}
