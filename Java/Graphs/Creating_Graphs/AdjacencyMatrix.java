package Java.Graphs.Creating_Graphs;

public class AdjacencyMatrix {
    private static void createMatrix(int[][] matrix, int[][] edges) {
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
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
        int[][] matrix = new int[vertex][vertex];
        createMatrix(matrix, edges);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
