//Modified for Programming Challenge 4.4 by Manveer Tamber
class PriorityQ
{
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;
    //-------------------------------------------------------------
    public PriorityQ(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    //-------------------------------------------------------------
    public void insert(long item)    // insert item
    {
        if(!isFull()){
            queArray[nItems] = item;
            nItems++;
        }
    }  // end insert()
    //-------------------------------------------------------------
    public long remove()             // remove minimum item
    {
        reverseInsertionSort();
        return queArray[--nItems];
    }
    //-------------------------------------------------------------
    public long peekMin()            // peek at minimum item
    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    { return (nItems == maxSize); }
//-------------------------------------------------------------


    public void reverseInsertionSort(){
        for(int count = 1;count<nItems;count++){
            long toconsider = queArray[count];
            int pos = count;
            while(queArray[pos-1] < toconsider){
                queArray[pos] = queArray[pos-1];
                pos--;
                if(pos == 0){
                    break;
                }
            }
            queArray[pos] = toconsider;
        }
    }

    public void display(){
        for(int count = 0;count<nItems;count++){
            System.out.print(queArray[count] + " ");
        }
        System.out.println();
    }
}  // end class PriorityQ
////////////////////////////////////////////////////////////////
class PriorityQApp
{
    public static void main(String[] args)
    {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        thePQ.reverseInsertionSort();
        thePQ.display();

        while(!thePQ.isEmpty()){
            System.out.println("Removed: " + thePQ.remove());
        }
    }  // end main()
//-------------------------------------------------------------
}  // end class PriorityQApp
////////////////////////////////////////////////////////////////