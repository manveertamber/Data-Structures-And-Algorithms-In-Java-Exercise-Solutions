class HighArray {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public HighArray(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// -----------------------------------------------------------
	public boolean find(long searchKey) { // find specified value
		int j;
		for (j = 0; j < nElems; j++) // for each element,
			if (a[j] == searchKey) // found item?
				break; // exit loop before end
		if (j == nElems) // gone to end?
			return false; // yes, can’t find it
		else
			return true; // no, found it
	} // end find()
		// -----------------------------------------------------------

	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) // look for it
			if (value == a[j])
				break;
		if (j == nElems) // can’t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++) // move higher ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}
	
	
	
	
	// Added for Exercise Solution 2.1 by Manveer Tamber
	public long getMax(){
		if(nElems <= 0){
			return -1;
		}
		else{
			long highestnum = Long.MIN_VALUE;
			for(int count = 0;count<nElems;count++){
				if(a[count]>highestnum)
					highestnum = a[count];
			}
				return highestnum;
		}
	}
	// end Manveer Solution 2.1
	
	
	// Added for Exercise Solution 2.2 by Manveer Tamber
	public void removeMax(){
		long toremove = getMax();
		delete(toremove);
		// nElems already decremented by delete()
	}
	// end Manveer Solution 2.2
	

	
	
	
	// -----------------------------------------------------------
} // end class HighArray
	////////////////////////////////////////////////////////////////

class HighArrayApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		HighArray arr; // reference to array
		arr = new HighArray(maxSize); // create the array
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
		arr.display();
				
		// Added for Exercise Solution 2.1 by Manveer Tamber
		if(arr.getMax() == -1)
			System.out.println("Array is empty");
		else 
			System.out.println(arr.getMax() + " is the highest number in the array");
		// end Manveer Solution 2.1
		
		// Added for Exercise Solution 2.2 by Manveer Tamber
		System.out.println("Removed highest number");
		arr.removeMax();
		arr.display();
		// end Manveer Solution 2.2
		
		// Added for Exercise Solution 2.3 by Manveer Tamber
		HighArray inverseArr = new HighArray(maxSize);
		while(arr.getMax() !=-1){
			inverseArr.insert(arr.getMax());
			arr.removeMax();
		}
		System.out.println("Sorted the array in descending order");
		inverseArr.display();
		arr.display();
		// end Manveer Solution 2.3
		
		
	} // end main()
} // end class HighArrayApp
	////////////////////////////////////////////////////////////////