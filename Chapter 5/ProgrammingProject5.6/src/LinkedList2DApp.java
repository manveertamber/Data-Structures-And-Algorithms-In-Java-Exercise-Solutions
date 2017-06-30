class Link
{
    public int iData;              // data item (key)
    public double dData;           // data item
    public Link next;              // next link in list
    public Link below;
    // -------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
        iData = id;
        dData = dd;
    }
    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
    private Link first;            // ref to first link on list
    // -------------------------------------------------------------
    public LinkList()              // constructor
    {
        first = null;               // no links on list yet
    }
    // -------------------------------------------------------------
    public void insertFirst(int id, double dd) {                           // make new link
        Link newLink = new Link(id, dd);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }
    // -------------------------------------------------------------
    public void displayList()      // display the list
    {
        System.out.println("List (first-->last): ");
        Link current = first;       // start at beginning of list
        int rownum = 1;
        while(current!=null) {
            while (current != null)      // until end of list,
            {
                current.displayLink();   // print data
                current = current.next;  // move to next link
            }
            current = first;
            rownum++;
            for(int count = 1;count < rownum;count++){
                current = current.below;
            }
            System.out.println();
        }
        System.out.println();
    }
    // -------------------------------------------------------------
    public void newRow(int width){
        int rownum = 1;
        Link current = first;
        if(current == null){
            first = new Link(1,0);
            current = first;
            for(int count = 2; count <= width;count++){
                current.next = new Link(count,0);
                current = current.next;
            }
        }
        else {
            int count = 1;
            while (current.below != null) {
                current = current.below;
                rownum++;
            }
            current.below = new Link(count + rownum * 10, 0);
            count++;
            while (count <= width) {
                current.next.below = new Link(count + rownum * 10, 0);
                current.below.next = current.next.below;
                current = current.next;
                count++;
            }
        }
    }
// -------------------------------------------------------------
    public void setLink(int x, int y, long n){
        Link current = first;
        for(int count = 1;count < x;count++){
            if(current == null)
                break;
            current = current.next;
        }
        for(int count = 1;count < y;count++){
            if(current == null)
                break;
            current = current.below;
        }
        current.dData = n;

    }
}  // end class LinkList

public class LinkedList2DApp {
    public static void main(String args[]){
        LinkList list = new LinkList();

        list.newRow(4);
        list.displayList();
        list.newRow(4);
        list.displayList();
        list.newRow(4);
        list.displayList();
        list.setLink(4,2,52);
        list.setLink(2,3,2);
        list.displayList();


    }
}
