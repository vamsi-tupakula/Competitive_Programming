package Java.Graphs.CycleDetection;

import java.util.*;

public class TopologicalSorting {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    private static void topologicalSortUtil(ArrayList<ArrayList<Integer>> adjList, int curr, Stack<Integer> stack, boolean[] visited) {
        visited[curr] = true;

        for (int num : adjList.get(curr)) {
            if (!visited[num])
                topologicalSortUtil(adjList, num, stack, visited);
        }

        stack.push(curr);
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> adjList, int vertex) {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertex; i++) {
            if (!visited[i])
                topologicalSortUtil(adjList, i, stack, visited);
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 3 }
        };

        int vertex = 4;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertex);
        createList(edges, adjList, vertex);
        
        topologicalSort(adjList, vertex);
    }
}
