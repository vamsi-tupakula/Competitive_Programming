package Java.Graphs.Creating_Graphs;

import java.util.*;

public class AdjacencyList {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(int[][] edges, HashMap<Integer, List<Integer>> graph) {
        for (int[] edge : edges) {
            // edge from edge[0] to edge[1]
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);

            // edge from edge[1] to edge[0]
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 2 },
                { 2, 3 },
                { 2, 1 },
                { 3, 1 }
        };

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(edges, graph);
    }
}
