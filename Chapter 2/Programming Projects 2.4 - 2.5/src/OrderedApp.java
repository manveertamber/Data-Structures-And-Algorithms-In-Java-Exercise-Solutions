class OrdArray {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public OrdArray(int max) // constructor
	{
		a = new long[max]; // create array
		nElems = 0;
	}

	// -----------------------------------------------------------
	public int size() {
		return nElems;
	}

	// -----------------------------------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey)
				return curIn; // found it
			else if (lowerBound > upperBound)
				return nElems; // can’t find it
			else // divide range
			{
				if (a[curIn] < searchKey)
					lowerBound = curIn + 1; // it’s in upper half
				else
					upperBound = curIn - 1; // it’s in lower half
			} // end else divide range
		} // end while
	} // end find()
		// -----------------------------------------------------------
	
	
	
	
	
	
	//Modified insert method to add binary search for challenge 2.4 and modified find method to find where number belongs - Manveer Tamber
	public void insert(long value) // put element into array
	{
		int j = whereThisBelongs(value);
		for (int k = nElems; k > j; k--) // move bigger ones up
			a[k] = a[k - 1];
		a[j] = value; // insert it
		nElems++; // increment size
	} // end insert()
	// -----------------------------------------------------------
	public int whereThisBelongs(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey)
				return curIn; // found it
			else if (lowerBound > upperBound)
				return lowerBound;
			else // divide range
			{
				if (a[curIn] < searchKey)
					lowerBound = curIn + 1; // it’s in upper half
				else
					upperBound = curIn - 1; // it’s in lower half
			} // end else divide range
		} // end while
		} // end find()
			// -----------------------------------------------------------
	// End 2.4 Solution - Manveer Tamber
	
	// Solution for 2.5, merging two ordered arrays together - Manveer Tamber
	public long get(int index){
		return a[index];
	}
	
	public OrdArray merge(OrdArray r2){
		OrdArray destination = new OrdArray(nElems + r2.size());
			for(int count = 0;count<nElems;count++){
				destination.insert(a[count]);
			}
			for(int count = 0;count<r2.size();count++){
				destination.insert(r2.get(count));
			}
			return destination;
	}
	
	// End 2.5 Solution - Manveer Tamber
	
	
	
	
	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems) // can’t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++) // move bigger ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

public void display() // displays array contents
{
for(int j=0; j<nElems; j++) // for each element,
System.out.print(a[j] + " "); // display it
System.out.println("");
}
	// -----------------------------------------------------------
} // end class OrdArray
	////////////////////////////////////////////////////////////////

class OrderedApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		OrdArray arr; // reference to array
		arr = new OrdArray(maxSize); // create the array
		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		OrdArray arr2 = new OrdArray(maxSize);
		arr2.insert(9);
		arr2.insert(18);
		arr2.insert(36);
		arr2.insert(45);
		arr2.insert(54);
		arr2.insert(63);
		arr2.insert(72);
		
		// Displaying solution for 2.5, merging two ordered arrays together - Manveer Tamber
		OrdArray merged = new OrdArray(maxSize);
		merged = arr.merge(arr2);
		System.out.println("The contents of the first array are ...");
		arr.display();
		System.out.println("The contents of the second array are ...");
		arr2.display();
		System.out.println("The contents of the merged array are ...");
		merged.display();
		//End Solution 2.5
	} // end main()
} // end class OrderedApp
	////////////////////////////////////////////////////////////////