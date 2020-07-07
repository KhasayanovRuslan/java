package list_iterator;

public class Node {
    public long dData;
    public Node next;

    public Node(long dd) {
        dData = dd;
    }

    public void displayNode() {
        System.out.print(dData + " ");
    }
}
