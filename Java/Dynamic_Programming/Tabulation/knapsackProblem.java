package Java.Dynamic_Programming.Tabulation;

public class knapsackProblem {
    public static void main(String[] args) {
        int[] wt = { 3, 4, 6, 5 };
        int[] val = { 2, 3, 1, 4 };
        System.out.println(knapsack(wt, val, 8));
    }

    public static int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
/**
 *          0 1 2 3 4 5 6 7 8
 * p w    0 0 0 0 0 0 0 0 0 0
 * 2 3    1 0 0 0 2 2 2 2 2 2
 * 3 4    2 0 0 0 2 3 3 3 5 5
 * 1 6    3 0 0 0 2 3 3 3 5 5
 * 4 5    4 0 0 0 2 3 4 4 5 6
 */