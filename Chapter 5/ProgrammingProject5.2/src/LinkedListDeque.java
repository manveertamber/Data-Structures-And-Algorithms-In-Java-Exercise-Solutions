class Link{
    public long data;

    public Link next;
    public Link previous;
    public Link(long n){
        data = n;
    }

    public void printData(){
        System.out.print(data + " ");
    }
}

class DoublyLinkedList
{
    public Link first;
    public Link last;

    public boolean isEmpty()
    { return first==null;}

    public void insertFirst(long dd)  // insert at front of list
    {
        Link newLink = new Link(dd);

        if( isEmpty() )
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd)   // insert at end of list
    {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;
        else
        {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Link deleteFirst()         // delete first link
    {
        Link temp = first;
        if(first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Link deleteLast()         // delete last link
    {
        Link temp = last;
        if(first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }
}

class Deque {
    DoublyLinkedList list;

    public Deque(int m) {
        list = new DoublyLinkedList();
    }

    public void insertLeft(long n) {
        list.insertFirst(n);
    }

    public void insertRight(long n) {
        list.insertLast(n);
    }

    public long removeLeft() {
        return list.deleteFirst().data;
    }

    public long removeRight() {
        return list.deleteLast().data;
    }

    public long peekLeft() {
        return list.first.data;
    }

    public long peekRight() {
        return list.last.data;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

 public class LinkedListDeque {

    public static void main(String[] args) {
        Deque thing = new Deque(100);
        for (int count = 0; count < 100; count++) {
            thing.insertLeft(count);
        }
        for (int count = 0; count < 10; count++) {
            thing.removeRight();
        }
        for (int count = 0; count < 10; count++) {
            thing.insertRight(count);
        }
        while (!thing.isEmpty()) {
            System.out.print(thing.removeLeft() + " ");
        }

    }

}