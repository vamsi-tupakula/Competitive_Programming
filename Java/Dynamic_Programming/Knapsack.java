package Java.Dynamic_Programming;

import java.util.*;

/**
 * ! Problem Statement:
 * Given a set of items where each item contains a weight and value, determine the number of each to include in
 * a collection so that the total weight is less than or equal to a given limit and the total value is as large as
 * possible and return the max profit
 */

public class Knapsack {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(40, 100));
        items.add(new Item(20, 39));
        items.add(new Item(20, 39));
        items.add(new Item(15, 29));

        Map<String, Integer> memo = new HashMap<>();

        System.out.println(knapsack(60, items, 0, memo));
    }

    private static int knapsack(int weight_left, ArrayList<Item> items, int itemNo, Map<String, Integer> memo) {
        if(itemNo >= items.size() || weight_left == 0) return 0;
        String key = weight_left + " | " + itemNo;

        if(memo.containsKey(key)) return memo.get(key);

        if(weight_left < items.get(itemNo).weight) {
            memo.put(key, knapsack(weight_left, items, itemNo+1, memo));
            return memo.get(key);
        }
        int case_1 = items.get(itemNo).value + knapsack(weight_left - items.get(itemNo).weight, items, itemNo+1, memo);
        int case_2 = knapsack(weight_left, items, itemNo+1, memo);
        memo.put(key, Math.max(case_1, case_2));
        return memo.get(key);
    }
}

class Item {
    int weight;
    int value;
    public Item(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }
}