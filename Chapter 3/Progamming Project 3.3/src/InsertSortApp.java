//  modified by Manveer Tamber
// demonstrates insertion sort
//--------------------------------------------------------------
class ArrayIns {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayIns(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public void insertionSort() {
		int in, out;

		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item
			in = out; // start shifts at out
			while (in > 0 && a[in - 1] >= temp) // until one is smaller,
			{
				a[in] = a[in - 1]; // shift item to right
				--in; // go left one position
			}
			a[in] = temp; // insert marked item
		} // end for
	} // end insertionSort()
	// --------------------------------------------------------------
	// Added for 3.3 Solution
	public void noDups() { // works only for sorted arrays
		long current = a[0];
		for (int count = 1; count < nElems; count++) { // set every duplicate
														// number after original
														// to -1
			if (a[count] == current) {
				a[count] = -1;
			} else {
				current = a[count];
			}
		}

		int toInsert = 0;
		for (int count = 0; count < nElems; count++) { // pushes all -1 values
														// to end of array,
														// every value only gets
														// moved once
			if (a[count] == -1) {
				toInsert = count;
				for (int next = count + 1; next < nElems; next++) {
					if (a[next] != -1) {
						a[toInsert] = a[next];
						a[next] = -1;
						// System.out.println("Moved " + a[toInsert]);
						break;
					}
				}
			}
		}

		for (int count = nElems - 1; count > 0; count--) { // gets rid of -1
															// values at end of
															// array
			if (a[count] == -1)
				nElems--;
		}

	}
	// end 3.3 Solution

} // end class ArrayIns
////////////////////////////////////////////////////////////////

class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayIns arr; // reference to array
		arr = new ArrayIns(maxSize); // create the array

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display(); // display items

		arr.insertionSort();
							
		arr.display(); // display them again

		System.out.print("Removed Duplicates: ");
		arr.noDups(); // for solution to 3.3
		arr.display();	

	} // end main()
} // end class InsertSortApp
