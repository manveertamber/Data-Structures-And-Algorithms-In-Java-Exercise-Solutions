//  modified by Manveer Tamber
// demonstrates bubble sort
////////////////////////////////////////////////////////////////
class ArrayBub {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayBub(int max) // constructor
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
	public void bubbleSort() {
		int out, in;

		for (out = nElems - 1; out > 1; out--) // outer loop (backward)
			for (in = 0; in < out; in++) // inner loop (forward)
				if (a[in] > a[in + 1]) // out of order?
					swap(in, in + 1); // swap them
	} // end bubbleSort()

	// modified method for challenge 3.1 by Manveer Tamber
	public void biBubbleSort() // bidirectional bubble sort
	{
		int out = nElems - 1;
		int start = 1;
		boolean changed = true;
		while (changed && out > start) {
			changed = false;
			for (int in = 0; in < out; in++) // inner loop (forward)
				if (a[in] > a[in + 1]) { // out of order?
					swap(in, in + 1);// swap them
					changed = true;
					// System.out.println("Swapped " + a[in] + " with " +
					// a[in+1]);
				}
			out--;
			for (int count = out; count > start; count--) {
				if (a[count] < a[count - 1]) {
					swap(count, count - 1);
					changed = true;
					// System.out.println("Swapped " + a[count] + " with " +
					// a[count-1]);
				}
			}
			start++;

		}
	} // end biBubbleSort()
		// end 3.1 Challenge
	// --------------------------------------------------------------
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	// --------------------------------------------------------------
} // end class ArrayBub
////////////////////////////////////////////////////////////////

class BubbleSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayBub arr; // reference to array
		arr = new ArrayBub(maxSize); // create the array

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display(); // display items

		arr.biBubbleSort(); // bubble sort them using bidirectional bubble sort

		arr.display(); // display them again
	} // end main()
} // end class BubbleSortApp
////////////////////////////////////////////////////////////////
