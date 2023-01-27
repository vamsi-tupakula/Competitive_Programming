package Java.Graphs.Graph_Traversals;

import java.util.*;

public class BreadthFirstSearch {
    private static void breadthFirstSearch(ArrayList<ArrayList<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];

        queue.add(0); // start

        while (!queue.isEmpty()) {
            if (visited[queue.peek()] == true) {
                queue.poll();
            } else {
                int peek = queue.peek();
                visited[peek] = true;
                for (int neigh : adjList.get(peek)) {
                    queue.add(neigh);
                }
                queue.poll();
                System.out.print(peek + " ");
            }
        }
    }

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
        System.out.println("Original Adjacency List : ");
        printGraph(adjList);
        System.out.println("Breadth First Search");
        breadthFirstSearch(adjList);

        /**
         * ! for disconnected graph we run bfs for every vertex like below
         */
        /**
         * boolean[] visited = new boolean[];
         * for (int i = 0; i < vertex; i++) {
         *      if (visited[i] == false)
         *          breadthFirstSearch(adjList, visited, i) // i will be our start
         * }
         */
    }
}