package Java.Graphs.Graph_Traversals;

import java.util.*;

public class DepthFirstSearch {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    private static void depthFirstSearch(ArrayList<ArrayList<Integer>> adjList, int curr, boolean[] visited) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int num : adjList.get(curr)) {
            if (visited[num] == false)
                depthFirstSearch(adjList, num, visited);
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
        depthFirstSearch(adjList, 0, visited);
    }
}
