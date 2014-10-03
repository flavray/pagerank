

public class Pagerank {
    public static void main(String[] args) {
        // Basic test graph from Mining Massive Data Sets lectures
        Graph graph = new Graph(3);

        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);

        System.out.println(graph.computePagerank(0.8, 0.0001));
    }
}
