package list_iterator;

public class LinkList {
    private Node first;

    public LinkList() {
        first = null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node f) {
        first = f;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void displayList() {
        Node current = first;

        while(current != null) {
            current.displayLink();
            current = current.next;
        }

        System.out.println("");
    }
}
