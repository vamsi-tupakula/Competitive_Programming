package Java.Dynamic_Programming;

import java.util.*;

public class CoinChange {
    private static int coinChange(ArrayList<Integer> coins, int index, int requiredSum) {
        if(requiredSum == 0) return 1;
        if(requiredSum < 0)  return 0;
        if(index >= coins.size()) return 0;

        int coinConsidered = coinChange(coins, index, requiredSum - coins.get(index));
        int coinNotConsidered = coinChange(coins, index+1, requiredSum);

        return coinConsidered + coinNotConsidered;
    }
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        coins.add(10);
        coins.add(15);

        int requiredSum = 7;
        System.out.println(coinChange(coins, 0, requiredSum));
    }
}