package Java.Graphs.Creating_Graphs;

import java.util.*;

public class TransposeGraph {
    private static void createList(int[][] edges, ArrayList<ArrayList<Integer>> adjList, int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
    }

    private static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            trans.add(new ArrayList<>());
        }

        int i = 0;
        for (ArrayList<Integer> ls : adjList) {
            for (int num : ls) 
                trans.get(num).add(i);
            i++;
        }
        return trans;
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
                { 1, 0},
                { 1, 2},
                { 2, 3},
                { 3, 0}
        };

        int vertex = 4;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertex);
        createList(edges, adjList, vertex);
        System.out.println("Original Adjacency List : ");
        printGraph(adjList);

        System.out.println("Transpose Adjacency List : ");
        ArrayList<ArrayList<Integer>> transposeList = getTranspose(adjList);
        printGraph(transposeList);
    }
}

/**
 * ! Original Adjacency List :
 * 0 : { }
 * 1 : { 0, 2}
 * 2 : { 3 }
 * 3 : { 0 }
 * 
 * 
 * ! Transpose Adjacency List :
 * 0 : { 1, 3}
 * 1 : { }
 * 2 : { 1 }
 * 3 : { 2 }
 */
