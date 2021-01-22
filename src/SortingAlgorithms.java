import java.util.Arrays;

//Class to sort the data given by Manager
public class SortingAlgorithms {

	//Source of code: Objects, Abstraction, Data Structures and Design using Java; Koffman & Wolfgang
	//With modifications
	public void bubble(int[] toSort) {
		//Variable to reduce the number of pair comparisons
		//Initialize in 1 as they are pair-comparisons
		int pass = 1;
		//Flag to break the loop once it's already sorted
		boolean exchanges = false;
		//Do-while loop to implement the flag
		do {
			//Set exchanges to false in each iteration
			exchanges = false;
			//Iterate to make the pair-comparisons
			for(int i = 0; i < toSort.length - pass; i++) {
				//Compare by pairs
				if(toSort[i] > toSort[i+1]) {
					//Swap if necessary
					int temp = toSort[i];
					toSort[i] = toSort[i+1];
					toSort[i+1] = temp;
					//Set flag
					exchanges = true;
				}
			}
			//Reduce number of comparisons. Last element considered sorted
			pass++;
			//Condition of the do-while loop
		}while(exchanges);
	}

	//Source code: Class notes. Higher Diploma in Software Development GMIT
	public void selection(int[] toSort) {
		//Variables for the Loops
		int outer = 0, inner = 0, min = 0;
		//Loop over the array
		for(outer = 0; outer < toSort.length -1; outer++) {
			//Select index of the hypothetical but future minimum value
			//Increasing as the last element moved is considered sorted
			min = outer;
			//Loop over the array from the next element (outer+1)
			for(inner = outer + 1; inner < toSort.length; inner++) {
				//Compare each element with the one considered minimum
				//If its less, select its index as "min" element
				if(toSort[inner] < toSort[min]) {
					min = inner;
				}
			}
			//After iterating over the array comparing and having 
			//selected the minimum value, swap it with the next position on the left
			int temp = toSort[outer];
			toSort[outer] = toSort[min];
			toSort[min] = temp;
		}
	}

	//Source code: Class notes.
	public void insertion(int[] toSort) {
		//Loop over the array starting at the second element
		for(int i = 1; i < toSort.length; i++) {
			//Select the element to compare
			int key = toSort[i];
			//Select index where to start to compare (to the left)
			int j = i-1;
			/*While loop to compare all elements on the left of the key 
				with the key, until it reaches an element smaller (or the end of the array), where it stops, 
				assuming all elements to the left are already sorted and less than the key*/
			while(j >= 0 && toSort[j] > key) {
				/*If the element to compare is bigger than the key, "overwrite" the element to the right with it 
					(move it one position to the right). The element overwrote can be the element acting as key 
					or the duplicated valued of a previously "moved" element.
				//Note: If that happens, there is one "blank space" (duplicate value), fixed after the 
				  	"While loop".*/
				toSort[j+1] = toSort[j];
				//Move the index of comparison one position to the left
				j = j-1;
			}
			/*After comparison, insert (overwrite) the key value ("saved" as key) in the old position of the 
				last element moved (duplicated value as it in the Key position too after over writing in 
				the while).
				Explanation of "j+1":
					"j" moved to the left (index -= 1) one last time after the last movement until 
					the condition of the While didn't match, so the correct position (first to the left
					from last movement)is one to the right (index += 1) of its current position, as it was
					already pointing to the next hypothetical element to compare*/
			toSort[j+1] = key;
		}
		//All again but starting one position to the right
	}

	//Merge:
	//Source code: GeeksforGeeks.org

	//Merge method 2
	//Method to sort subarrays and merge them
	private void merge(int[] toSort, int l, int m, int r) {
		//Get the length of the two subarrays to sort/merge (subarrays as index values of the complete array)
		int n1 = m - l + 1;
		int n2 = r - m;
		//Temporary arrays to store the subarrays
		int L[] = new int [n1];
		int R[] = new int [n2];
		//Populate the temporary arrays
		for(int i = 0; i < n1; i++) {
			L[i] = toSort[l + i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = toSort[m + 1 + j];
		}
		//Sorting and merging
		//Variables for sorting
		int i = 0, j = 0;
		//Variable to locate the index of the array to sort
		int k = l;
		//While there are elements to be sorted in both subarrays
		while(i < n1 && j < n2) {
			//Compare, assign and move index (of assigned and array to sort)
			if(L[i] <= R[j]) {
				toSort[k] = L[i];
				i++;
			}else {
				toSort[k] = R[j];
				j++;
			}
			k++;
		}
		/*System.out.println("Before adding side elements: \n" + "subarrays: " + Arrays.toString(L) + "//"
				+ Arrays.toString(R) + "\nFull Array: "+ Arrays.toString(toSort));*/
		//Check for any element left in the subarrays and assign it to the array
		while (i < n1) {
			toSort[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			toSort[k] = R[j];
			j++;
			k++;
		}
		/*System.out.println("After adding side elements: \n" + "subarrays: " + Arrays.toString(L) + "//"
				+ Arrays.toString(R) + "\nFull Array: "+ Arrays.toString(toSort));
		System.out.println("End Merge");*/
		//Done, recursion in "sort()" will continue and sort/merge the next subarray until all done
	}

	//Merge Method1
	//Method to recursively divide the array until we reach subarrays of 1 element, where stops recursion
	//Merge is always a subarray of at least two elements
	public void sort(int toSort[], int l, int r) {
		//Base case for recursion
		if(l < r) {
			//System.out.println("Sort: ");
			//Get the index in the middle
			int m = (l + r)/2;
			//Recursively get half of both subarray

			/*System.out.println("l: " + l + " m: " + m + " r: " + r);
			System.out.println("l: " + toSort[l] + " m: " + toSort[m] + " r: " + toSort[r]);*/

			sort(toSort, l, m);
			sort(toSort, m + 1, r);
			//Once you have the minimum subarrays, send it to merge step
			/*System.out.println("Merge: l: " + l + " m: " + m + " r: " + r);
			System.out.println("Merge:");*/
			merge(toSort, l, m, r);
		}
	}

	//Radix:
	//Source code: GeeksforGeeks.org

	//Method to sort the array by LSD (LSD: Least Significant Digit) -> From the rightmost side of the numbers
	//Parameters: Array, length of the array
	public void radix(int[] toSort, int n) {
		//Get max value of the array
		int m = getMax(toSort, n);
		//Loop over the array
		//Initialize with SD = 1 (first digit on the rightmost side of each value)
		//Until reaching the max SD (max value divided by the SD number)
		//SD number expressed as 10^i
		for(int exp = 1; m/exp > 0; exp *= 10) {
			//Send to counting sort with the radix to analyze 
			countSort(toSort, n, exp);
		}
	}

	//Method to get the maximum value of the array
	private int getMax(int[] toSort, int n) {
		//Assume the first element is the max
		int mx = toSort[0];
		//Compare and swap to get the max
		for(int i = 1; i < n; i++) {
			if (toSort[i] > mx) {
				mx = toSort[i];
			}
		}
		return mx;
	}
	//Method to sort by "Counting sort" (subroutine of Radix Sort)
	private void countSort(int[] toSort, int n, int exp) {
		//Array to store the result
		int[] output = new int[n];
		//Variable for the loops
		int i;
		//Array to store the counts of each value
		// Radix: 10 as it's for integers (0-9), decimal system
		int[] count = new int[10];
		//Fill the array with "0" as we start from 0 existance of any value
		Arrays.fill(count, 0);
		//Loop over the array
		for (i = 0; i < n; i++) {
			//Counting sort:
			//Add 1 to the correspondent value in count[] for each value found in toSort[], 
			//in count index = toSort value
			//i.e. Count the number of times each value is in toSort[], storing the count in count[]
			//Radix sort additions:
			//Divide the value of toSort between the SD where its analyzing (exp)
			//This eliminates digits to the right when exp is increasing 
			//(e.g. 84/10 => 8 when analyzing SD: 2, as the second digit from the right 
			//is the pertinent to analyze)
			//Modulus 10, opposite of "divide by" purpose, eliminate non relevant digits to the 
			//left depending on the SD to analyze
			//10 because of the same as above (0-9) Radix
			count[(toSort[i]/exp)%10]++;
		}
		//Loop and add to each value in count[] the value of the element on the left
		//This sets the index where the values should be in the sorted array, as it adds 1 each 
		//time a value appears and keeps the count when there's no value (0) in count[]
		//NOTE: if there are duplicates values, adds 1 for each time the value appears
		for(i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		//Loop and assign in the output[] the value of toSort
		//Takes the value of toSort, exp-%10 to find the pertinent SD. 
		//This value as index in count, which stores the amount of times the value appears
		//Subtract 1 to the value, as existence is 1 extra than index (index start at 0)
		//For duplicate values will place the value in the rightmost possible position for the value
		//subtract one to the value in Count[] as the element has been placed
		//Reverse Loop to make the algorithm stable
		for(i = n - 1; i >= 0; i--) {
			output[count[(toSort[i]/exp)%10] -1] = toSort[i];
			count[(toSort[i]/exp)%10]--;
		}
		//Change toSort with the partially/fully sorted result
		for(i = 0; i < n; i++) {
			toSort[i] = output[i];
		}
	}
}
