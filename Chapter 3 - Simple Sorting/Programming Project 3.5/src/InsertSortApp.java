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
	// Added for challenge 3.5

	public void countinsertionSort() {
		int in, out;
		int comparisons = 0;
		int copies = 0;
		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item

			in = out; // start shifts at out

			while (in > 0) {
				comparisons++;
				if (a[in - 1] >= temp) {
					a[in] = a[in - 1]; // shift item to right
					copies++;
					in--;
				} else {
					break;
				}
			}

			a[in] = temp; // insert marked item

		} // end for
		System.out.println("The number of comparisons are " + comparisons);
		System.out.println("The number of copies are " + copies);
	}

	// End 3.5 Challenge
	// --------------------------------------------------------------
} // end class ArrayIns
////////////////////////////////////////////////////////////////

class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayIns arr; // reference to array
		arr = new ArrayIns(maxSize); // create the array

		arr.insert(77); // insert 10 items
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

		arr.countinsertionSort(); // insertion-sort, while also counting comparisons and copies for solution to 3.5

		arr.display(); // display them again


		System.out.println();
		System.out.println("Now, sort almost sorted data");
		ArrayIns arr2 = new ArrayIns(maxSize); // create array for almost sorted data
		arr2.insert(1);
		arr2.insert(2);
		arr2.insert(5);
		arr2.insert(3);
		arr2.insert(5);
		arr2.insert(6);
		arr2.insert(8);
		arr2.insert(10);
		arr2.insert(2);
		arr2.insert(5);
		arr2.insert(12);
		arr2.insert(13);
		arr2.insert(10);
		arr2.insert(18);
		arr2.insert(20);
		arr2.insert(13);
		arr2.insert(12);
		arr2.insert(25);

		arr2.display();
		arr2.countinsertionSort();
		arr2.display();
		
		

	} // end main()
} // end class InsertSortApp
