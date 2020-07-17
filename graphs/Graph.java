//Реализовать программу, в которой задается граф из 10 вершин.
//Задать ребра и найти кратчайший путь с помощью поиска в ширину.

package graphs;

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int size;
    private Queue queue;

    public Graph() {
        queue = new Queue(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }

        return -1;
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int i1, int i2) {
        adjMatrix[i1][i2] = 1;
        adjMatrix[i2][i1] = 1;
    }

    public void displayVertex(int indexVertex) {
        System.out.println(vertexList[indexVertex].label);
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);

        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }


    public void bfsPathTo(char label) {
        int j;
        for (j = 0; j < size; j++) {
            if (vertexList[j].label == label) {
                break;
            }
        }

        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);

        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                if (adjMatrix[j][v2] == 1) {
                    displayVertex(v2);
                }
                queue.insert(v2);
            }
        }

        displayVertex(j);

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

}
