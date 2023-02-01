package Java.Graphs.MST;

import java.util.*;

public class PrimsAlgorithm {
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

    static class Pair {
        int node;
        int cost;

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
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

    private static void primsAlgo(ArrayList<ArrayList<Edge>> graph, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)  -> {return a.cost - b.cost;});
        boolean[] vis = new boolean[V];

        int mstCost = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;
                mstCost += curr.cost;

                for (Edge edge : graph.get(curr.node)) {
                    if(!vis[edge.des]) {
                        pq.add(new Pair(edge.des, edge.wt));
                    }
                }
            }
        }

        System.out.println("minimum spanning tree cost: " + mstCost);
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 10 },
                { 0, 2, 15 },
                { 2, 3, 50 },
                { 1, 3, 40 },
                { 0, 3, 30 }
        };

        int vertex = 4;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertex);
        createList(edges, graph, vertex);

        primsAlgo(graph, vertex);
    }
}
