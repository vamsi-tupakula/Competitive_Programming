package Java.Graphs;

import java.util.*;

public class AdjacentMatrix {
    public static void printMatrix(boolean[][] mat) {
        for (int i = 0;i < mat.length; i++) {
            for (int j = 0; j < mat[0].length ; j++) {
                if (mat[i][j] == false)
                    System.out.print(0 + " ");
                else 
                    System.out.print(1 + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 1, 3 },
                { 3, 4 }
        };

        boolean[][] matrix = new boolean[5][5];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = true;
            matrix[edge[1]][edge[0]] = true;
        }

        for (int[] edge : edges) {
            map.getOrDefault(edge[0], new ArrayList<>()).add(edge[1]);
            map.getOrDefault(edge[1], new ArrayList<>()).add(edge[0]);
        }

        printMatrix(matrix);
    }
}
