import java.util.ArrayList;
import java.util.Random;

class Array{
    long arr[];
    int size;
    public Array(int maxSize){
        arr = new long[maxSize];
        size = 0;
    }
    public void insert(long n){
        arr[size] = n;
        size++;
    }
    public int getSize(){
        return size;
    }
    public void display(){
        for(int count = 0;count < size;count++){
            System.out.print(arr[count] + " ");
        }
        System.out.println();
    }
    public void radixSort(){
        String nums[] = new String[size];
        for(int count = 0;count < size;count++){
            nums[count] = Long.toString(arr[count]);
        }
        ArrayList<String> groups[] = new ArrayList[10];
        for(int count = 0; count < 10;count++){
            groups[count] = new ArrayList<String>();
        }
        int currentDigit = 0;
        boolean changed = true;
        while(changed){
            changed = false;
            for(String x: nums){
                if(x.length() < currentDigit + 1){
                    groups[0].add(x);
                }
                else{
                    groups[Character.getNumericValue(x.charAt(x.length() - 1 - currentDigit))].add(x);
                    changed = true;
                }
            }
            int currentIndex = 0;
            for(int count = 0;count < 10;count++){
                for(String x: groups[count]){
                    nums[currentIndex] = x;
                    currentIndex++;
                }
                groups[count].clear();
            }
            currentDigit++;
        }
        for(int count = 0;count < size;count++){
            arr[count] = Long.parseLong(nums[count]);
        }
    }
}


public class radixSortApp {
    public static void main(String args[]){
        int arraySize = 20;
        Array arr = new Array(arraySize);
        Random numGenerator = new Random();

        for(int count = 0;count < arraySize;count++){
            arr.insert(numGenerator.nextInt(10000));
        }
        arr.display();
        arr.radixSort();
        arr.display();
    }
}
