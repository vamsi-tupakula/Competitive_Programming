package Java.Graphs.Graph_Traversals;

import java.util.*;

public class AllPathsFromSrcToDest {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public static void printAllPaths(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int num : adjList.get(curr)) {
            if (!visited[num]) {
                visited[curr] = true;
                printAllPaths(adjList, visited, num, path + " -> " + num, target);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 7 },
                { 0, 2 },
                { 1, 3 },
                { 2, 4 },
                { 2, 6 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 6, 7 }
        };

        int vertex = 8;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertex);
        createList(edges, adjList, vertex);
        boolean[] visited = new boolean[vertex];
        printAllPaths(adjList, visited, 0, "0", 5);
    }
}