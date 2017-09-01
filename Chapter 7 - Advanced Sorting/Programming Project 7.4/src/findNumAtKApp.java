//extended project 7.1, 7.3
import java.util.Random;
import java.util.Scanner;
class ArrayPar
{
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayPar(int max)          // constructor
    {
        theArray = new long[max];      // create the array
        nElems = 0;                    // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public int size()                 // return number of items
    { return nElems; }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        System.out.print("A=");
        for(int j=0; j<nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public int partitionIt(int left, int right)
    {
        long pivot = theArray[right];
        int leftPtr = left - 1;           // right of first elem
        int rightPtr = right;         // left of pivot
        while(true)
        {
            while(leftPtr < right &&       // find bigger item
                    theArray[++leftPtr] < pivot)
                ;  // (nop)

            while(rightPtr > left &&       // find smaller item
                    theArray[--rightPtr] > pivot)
                ;  // (nop)
            if(leftPtr >= rightPtr)        // if pointers cross,
                break;                      //    partition done
            else                           // not crossed, so
                swap(leftPtr, rightPtr);    //    swap elements

        }  // end while(true)
        swap(right, leftPtr);
        return leftPtr;                   // return partition
    }  // end partitionIt()
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2)  // swap two elements
    {
        long temp;
        temp = theArray[dex1];             // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }  // end swap()

    public long findNumAtIndex(int k){
        int left = 0;
        int right = nElems-1;
        while(true) {
            int currentIndex = partitionIt(left, right);
            if(currentIndex == k){
                return theArray[currentIndex];
            }
            else if(currentIndex > k){
                right = currentIndex - 1;
            }
            else{
                left = currentIndex  + 1;
            }
        }
    }
//--------------------------------------------------------------
}  // end class ArrayPar
////////////////////////////////////////////////////////////////
public class findNumAtKApp {
    public static void main(String args[]){
        int arrSize = 25;
        ArrayPar arr = new ArrayPar(arrSize);
        Random numGenerator = new Random();

        for(int i = 0;i < arrSize;i++){
            arr.insert(numGenerator.nextInt(100));
        }

        arr.display();
        System.out.println("Please input the kth smallest number you would like to know.");
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        if(k > 0 && k < 25)
            System.out.println("The number at K is " + arr.findNumAtIndex(k-1));
        else
            System.out.println("Please try again with a valid number between 0 and " + (arr.size()));
        arr.display();
    }
}
