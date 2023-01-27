package Java.Graphs.Creating_Graphs;

import java.util.*;

public class AdjacencyList {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        System.out.println("node : its neighbours" );
        int i = 0;
        for (ArrayList<Integer> neigh : adjList) {
            System.out.println(i++ + " : " + neigh);
        }
    }
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 3 },
                { 0, 4 },
                { 1, 3 },
                { 1, 2 },
                { 2, 4 }
        };

        int vertex = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertex);
        createList(edges, adjList, vertex);

        printGraph(adjList);
    }
}
