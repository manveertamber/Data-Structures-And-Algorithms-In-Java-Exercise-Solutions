class Link{
    Link next;
    int key;
    long data;
    public Link(long n, int k){
        data = n;
        key = k;
    }
    void display() {
        System.out.print(data + " ");
    }
}

class CircularList{
    Link current;

    public boolean isEmpty(){
        return current == null || current.next == current;
    }

    public void insert(long n, int k) {
        if (isEmpty())
            current = new Link(n,k);
        else {
            Link toadd = new Link(n,k);
            if(current.next == null) {
                current.next = toadd;
                toadd.next = current;
                step();
            }
            else{
                toadd.next = current.next;
                current.next = toadd;
                step();
            }
        }
    }

    public Link search(int k){
        Link temp = current;
        int startKey = current.key;
        if(startKey == k){
            return current;
        }
        else {
            while (temp.key != k) {
                temp = temp.next;
                if(temp == null) {
                    System.out.println("Could not find item: " + k);
                    return null;
                }
                if(temp.key == startKey) {
                    System.out.println("Could not find item: " + k);
                    return null;
                }
            }
            return temp;
        }
    }

    public Link delete(int k){
        Link previous = current;
        Link consider = current.next;
        if(consider == null){
            if(previous.key == k) {
                current = null;
                return previous;
            }
            else{
                System.out.println("Could not find item: " + k);
                return null;
            }
        }
        if(consider.key == k){
            if(consider.next == previous)
                previous.next = null;
            else if(consider.next == null)
                current = null;
            else
                previous.next = consider.next;
            return consider;
        }
        int startKey = consider.key;
        previous = consider;
        consider = previous.next;
        while(consider.key != k){
            previous = consider;
            consider = previous.next;
            if(consider.key == startKey){
                System.out.println("Could not find item: " + k);
                return null;
            }
        }
        if(consider.next == previous)
            previous.next = null;
        else
            previous.next = consider.next;
        return consider;
    }

    public void step(){
        current = current.next;
    }

    public void display(){
        if(!isEmpty()) {
            if(current.next == null){
                current.display();
            }
            else {
                int startKey = current.key;
                step();
                current.display();
                while (current.key != startKey) {
                    step();
                    current.display();
                }
            }
        }
        else{
            System.out.println("The List Is Empty");
        }
        System.out.println();
    }
}

public class CircleListApp {
    public static void main(String args[]){
        CircularList list = new CircularList();
        for(int count = 0;count < 100;count++){
            list.insert(count,count);
        }
        list.display();
        System.out.println("Deleting The Items");
        for(int count = 99;count >=0;count--){
            list.delete(count);
        }
        list.display();


    }
}
