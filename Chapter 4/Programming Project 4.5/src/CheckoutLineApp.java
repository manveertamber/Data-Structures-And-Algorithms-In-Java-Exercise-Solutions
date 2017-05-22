//Programming Challenge 4.5 by Manveer Tamber

import java.util.Random;
import java.util.Scanner;

class customer{
    public int bags;
    int id;

    public customer(int bags, int id) {
        this.bags = bags;
        this.id = id;
    }

    public String toString(){
        return "Customer num: " + id + ", " + bags + " bags left to checkout";
    }
}

class Queue
{
    private int maxSize;
    private customer[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public int bags = 0;
    public int linenumber;
    //--------------------------------------------------------------
    public Queue(int s, int n)          // constructor
    {
        maxSize = s;
        queArray = new customer[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        linenumber = n;
    }
    //--------------------------------------------------------------
    public void insert(customer j)   // put item at rear of queue
    {
        if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }
    //--------------------------------------------------------------
    public customer remove()         // take item from front of queue
    {
        customer temp = queArray[front++]; // get value and incr front
        if(front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }
    //--------------------------------------------------------------
    public customer peekFront()      // peek at front of queue
    {
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if queue is empty
    {
        return (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if queue is full
    {
        return (nItems==maxSize);
    }
    //--------------------------------------------------------------
    public int size()           // number of items in queue
    {
        return nItems;
    }
    //--------------------------------------------------------------
    public void display(){
    	System.out.print("Line " + linenumber + " ");
        if(!isEmpty()){
    	int pos = front;
        for(int count = 0;count<nItems;count++){
            System.out.print(queArray[pos] + "        ");
            pos++;
            if(pos==maxSize){
                pos = 0;
            }
        }
        System.out.println();
        }
        else{
        System.out.print("Empty");
        System.out.println();
        }
    }

    public void bagcheckout(){
        try {
            queArray[front].bags--;
            bags--;
            if (queArray[front].bags == 0) {
                remove();
            }
        }
        catch(Exception e){

        }
    }
}

public class CheckoutLineApp {
   public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        Queue line1 = new Queue(100,1);
        Queue line2 = new Queue(100,2);
        Queue line3 = new Queue(100,3);
        int nextid = 1;
        
        while(true){
            System.out.println("Press P to have one bag checked out.");
            System.out.println("Press N for a new customer with a random number of bags.");
            String command = input.next().trim();
            if(command.equals("P")){
                line1.bagcheckout();
                line2.bagcheckout();
                line3.bagcheckout();

                line1.display();
                line2.display();
                line3.display();
            }
            else if(command.equals("N")){
                customer toAdd = newCustomer(nextid);
                nextid++;
                if(line1.bags <= line2.bags && line1.bags <= line3.bags){
                    line1.insert(toAdd);
                    line1.bags+=toAdd.bags;
                }
                else if(line2.bags <= line1.bags && line2.bags <= line3.bags){
                    line2.insert(toAdd);
                    line2.bags+=toAdd.bags;
                }
                else {
                    line3.insert(toAdd);
                    line3.bags += toAdd.bags;
                }
                line1.display();
                line2.display();
                line3.display();
            }
        }
    }

    public static customer newCustomer(int id){
        Random bagnum = new Random();
        int bags = 1 + bagnum.nextInt(9);
        return new customer(bags,id);
    }
}
