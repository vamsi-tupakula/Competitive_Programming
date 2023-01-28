package Java.Graphs.CycleDetection;

import java.util.*;

public class CycleDetectionUndirected {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    private static boolean isCycleExist(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] vis, int parent) {
        vis[curr] = true;

        for (int num : graph.get(curr)) {
            if (vis[num] == true && parent != num) {
                return true;
            }

            if (!vis[num]) {
                if (isCycleExist(graph, num, vis, curr))
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 4 },
                { 1, 2 },
                { 2, 3 },
                { 4, 5 },
                // { 1, 4 }
        };

        int vertex = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertex);
        createList(edges, adjList, vertex);
        
        boolean[] visited = new boolean[vertex];
        System.out.println(isCycleExist(adjList, 0, visited, -1));
    }
}
