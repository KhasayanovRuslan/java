package doubly_linked_list;

public class Node {
    public long dData;
    public Node next;
    public Node previous;

    public Node(long d) {
        dData = d;
    }

    public void displayNode() {
        System.out.print(dData + " ");
    }
}
