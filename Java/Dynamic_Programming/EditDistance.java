package Java.Dynamic_Programming;

import java.util.*;

/**
 * deletion in the first string means deletion in the first string
 * insertion in the first string means deletion in the second string
 */

public class EditDistance {
    public static void main(String[] args) {
        String one = "captain";
        String two = "america";

        Map<String, Integer> map = new HashMap<>();
        System.out.println(editDistance(one, 0, two, 0, map));
    }
    public static int editDistance(String s1, int indexOne, String s2, int indexTwo, Map<String, Integer> map) {
        if(indexOne >= s1.length()) return s2.length() - indexTwo;
        if(indexTwo >= s2.length()) return s1.length() - indexOne;

        String key = indexOne + " | " + indexTwo;

        if(map.containsKey(key)) return map.get(key);

        if(s1.charAt(indexOne) == s2.charAt(indexTwo)) {
            map.put(key, editDistance(s1, indexOne+1, s2, indexTwo+1, map));
            return map.get(key);
        }

        int deletionCost = editDistance(s1, indexOne+1, s2, indexTwo, map);
        int insertionCost = editDistance(s1, indexOne, s2, indexTwo+1, map);
        int replaceCost = editDistance(s1, indexOne+1, s2, indexTwo+1, map);

        map.put(key, 1 + Math.min(replaceCost, Math.min(insertionCost, deletionCost)));
        return map.get(key);
    }
}
