package Java.Graphs.ShortestPathAlgos;

import java.util.*;

public class BellmanFord {
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

    private static void bellmanFord(ArrayList<ArrayList<Edge>> graph, int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Edge> ls : graph) {
                for (Edge edge : ls) {
                    int u = edge.src;
                    int v = edge.des;
                    if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + edge.wt) {
                        dist[v] = dist[u] + edge.wt;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 4 },
                { 1, 2, -4 },
                { 2, 3, 2 },
                { 3, 4, 4 },
                { 4, 1, -1 }
        };

        int vertex = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertex);

        createList(edges, graph, vertex);
        bellmanFord(graph, 0, vertex);
    }
}
