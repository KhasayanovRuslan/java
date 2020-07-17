package list_iterator;

public class ListIterator {
    private Node current;
    private Node previous;
    private LinkList ourList;

    public ListIterator(LinkList list) {
        ourList = list;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public void nextNode() {
        previous = current;
        current = current.next;
    }

    public Node getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {
        Node newNode = new Node(dd);

        if ( ourList.isEmpty() ) {
            ourList.setFirst(newNode);
            current = newNode;
        }
        else {
            newNode.next = current.next;
            current.next = newNode;
            nextNode();
        }
    }

    public void insertBefore(long dd) {
        Node newNode = new Node(dd);

        if(previous == null) {
            newNode.next = ourList.getFirst();
            ourList.setFirst(newNode);
            reset();
        }
        else {
            newNode.next = previous.next;
            previous.next = newNode;
            current = newNode;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;

        if(previous == null) {
            ourList.setFirst(current.next);
            reset();
        }
        else {
            previous.next = current.next;

            if( atEnd() )
                reset();
            else
                current = current.next;
        }

        return value;
    }
}
