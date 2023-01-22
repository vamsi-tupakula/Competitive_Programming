package Java.Dynamic_Programming.Tabulation;

public class EditDistance2 {
    public static void main(String[] args) {
        String sOne = "ABCD";
        String sTwo = "AECDB";
        System.out.println(editDistance(sOne, sTwo));
    }

    public static int editDistance(String sOne, String sTwo) {
        int m = sTwo.length();
        int n = sOne.length();
        int[][] cost = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    cost[i][j] = j;
                } else if (j == 0) {
                    cost[i][j] = i;
                } else {
                    if (sOne.charAt(j-1) == sTwo.charAt(i-1)) {
                        cost[i][j] = cost[i-1][j-1];
                    } else {
                        cost[i][j] = Math.min(cost[i-1][j], Math.min(cost[i][j-1], cost[i-1][j-1])) + 1;
                    }
                }
            }
        }

        return cost[m][n];
    }
}
