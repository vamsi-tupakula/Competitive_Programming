package Java.Graphs.ShortestPathAlgos;

import java.util.*;

public class DijkstraAlgorithm {
    static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static class Edge {
        int src;
        int des;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    private static void createList(int[][] edges, ArrayList<ArrayList<Edge>> graph, int vertex) {
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Edge(edge[0], edge[1], edge[2]));
        }
    }

    private static void dijkstra(ArrayList<ArrayList<Edge>> graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {return a.dist - b.dist;});
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] visited = new boolean[V];

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                for (Edge edge : graph.get(curr.node)) {
                    int u = edge.src;
                    int v = edge.des;

                    if(dist[u] + edge.wt < dist[v]) {
                        dist[v] = dist[u] + edge.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int num : dist) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 4 },
                { 1, 3, 7 },
                { 1, 2, 1 },
                { 2, 4, 3 },
                { 3, 5, 1 },
                { 4, 3, 2 },
                { 4, 5, 5 }
        };

        int vertex = 6;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertex);
        
        createList(edges, graph, vertex);
        dijkstra(graph, 0, vertex);
    }
}
