class Link{
    public long data;
    public Link next;

    public Link(long n){
        data = n;
    }

    public void printData(){
        System.out.print(data + " ");
    }
}

class SortedList{
    public Link first;

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(long key)
    {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        // until end of list,
        while(current != null && key > current.data)
        {
            previous = current;
            current = current.next;
        }
        if(previous==null)
            first = newLink;
        else
            previous.next = newLink;
        newLink.next = current;
    }

    public Link remove()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        Link current = first;
        while(current != null)
        {
            current.printData();
            current = current.next;
        }
        System.out.println();
    }

}

class PriorityQ{

    SortedList linkedList;

    public PriorityQ(){
        linkedList = new SortedList();
    }
    public long remove(){
        Link temp  = linkedList.remove();
        return temp.data;
    }
    public long peek(){
        return linkedList.first.data;
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void insert(long n){
        linkedList.insert(n);
    }

}

public class LinkedListPriorityQ {
    public static void main(String args[]){
        PriorityQ test = new PriorityQ();
        test.insert(1);
        test.insert(5);
        test.insert(3);
        test.insert(4);
        test.insert(2);
        while(!test.isEmpty()){
            System.out.println(test.remove());
        }
    }
}
