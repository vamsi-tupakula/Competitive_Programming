package Java.Dynamic_Programming;

import java.util.*;

public class CoinChange {
    private static int coinChange(ArrayList<Integer> coins, int index, int requiredSum, Map<String, Integer> memo) {
        if(requiredSum == 0) return 1;
        if(requiredSum < 0)  return 0;
        if(index >= coins.size()) return 0;
        String key = index + " | " + requiredSum;

        if(memo.containsKey(key)) return memo.get(key);

        int coinConsidered = coinChange(coins, index, requiredSum - coins.get(index), memo);
        int coinNotConsidered = coinChange(coins, index+1, requiredSum, memo);

        memo.put(key, coinConsidered + coinNotConsidered);
        return memo.get(key);
    }
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        coins.add(10);
        coins.add(15);

        // creating a memo
        Map<String, Integer> memo = new HashMap<>();

        int requiredSum = 7;
        System.out.println(coinChange(coins, 0, requiredSum, memo));
    }
}