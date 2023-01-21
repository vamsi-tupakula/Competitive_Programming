package Java.Dynamic_Programming;

/**
 * deletion in the first string means deletion in the first string
 * insertion in the first string means deletion in the second string
 */

public class EditDistance {
    public static void main(String[] args) {
        String one = "captain";
        String two = "america";

        System.out.println(editDistance(one, 0, two, 0));
    }
    public static int editDistance(String s1, int indexOne, String s2, int indexTwo) {
        if(indexOne >= s1.length()) return s2.length() - indexTwo;
        if(indexTwo >= s2.length()) return s1.length() - indexOne;

        if(s1.charAt(indexOne) == s2.charAt(indexTwo))
            return editDistance(s1, indexOne+1, s2, indexTwo+1);

        int deletionCost = editDistance(s1, indexOne+1, s2, indexTwo);
        int insertionCost = editDistance(s1, indexOne, s2, indexTwo+1);
        int replaceCost = editDistance(s1, indexOne+1, s2, indexTwo+1);

        return 1 + Math.min(replaceCost, Math.min(insertionCost, deletionCost));
    }
}
