package Java.Graphs.CycleDetection;

import java.util.*;

public class CycleDetectionDirected {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
    }

    public static boolean isCycleExist(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int curr, boolean[] recursion_stack) {
        visited[curr] = true;
        recursion_stack[curr] = true;

        for (int num : adjList.get(curr)) {
            if (recursion_stack[num]) 
                return true;
            else if(!visited[num])
                if(isCycleExist(adjList, visited, num, recursion_stack))
                    return true;
        }

        recursion_stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 1, 0 },
                { 0, 2 },
                { 2, 3 },
                { 3, 0 }
        };

        int vertex = edges.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertex);
        createList(edges, adjList, vertex);

        System.out.println(isCycleExist(adjList, new boolean[vertex], 0, new boolean[vertex]));
    }
}
