package graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');

        graph.addEdge(0, 1);
        graph.addEdge(1, 9);
        graph.addEdge(9, 2);
        graph.addEdge(8, 4);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        graph.addEdge(0, 3);
        graph.addEdge(0, 8);

        graph.bfs();
        System.out.println();
        graph.bfsPathTo('E');
    }
}
