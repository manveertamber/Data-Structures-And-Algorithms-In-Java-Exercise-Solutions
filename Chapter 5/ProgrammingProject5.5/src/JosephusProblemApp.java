import java.util.Scanner;

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
        else if(consider.next == null)
            current = null;
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
        System.out.println();
    }

    public void goTo(int k){
        while(current.key!=k){
            current = current.next;
        }
    }

}

public class JosephusProblemApp {
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        CircularList circle = new CircularList();
        System.out.println("Enter the number of people");
        int people = input.nextInt();
        System.out.println("Enter the increment");
        int count = input.nextInt();
        System.out.println("Enter the starting person");
        int start = input.nextInt();

        for(int i = 1;i <=people;i++){
            circle.insert(i,i);
        }
        circle.goTo(start);

        while(!circle.isEmpty()){
            for(int step = 0;step < count;step++){
                if(circle.current.next!=null)
                    circle.step();
            }
            System.out.println(circle.delete(circle.current.key).data);
            if(circle.isEmpty())
                break;

            if(circle.current.next!=null)
                circle.step();
        }
    }
}
