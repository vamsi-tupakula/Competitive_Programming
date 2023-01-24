package Java.Dynamic_Programming.Tabulation;

public class LongestCommonSubSequence {
    public static int lcs(String sOne, int indexOne, String sTwo, int indexTwo) {
        int[][] arr = new int[indexTwo + 1][indexOne + 1];
        for (int i = 1; i <= sOne.length(); i++) {
            for (int j = 1; j <= sTwo.length(); j++) {
                if (sOne.charAt(i - 1) == sTwo.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], Math.max(arr[i][j - 1], arr[i - 1][j - 1]));
                }
            }
        }
        return arr[sTwo.length()][sOne.length()];
    }

    public static void main(String[] args) {
        String one = "abcdefghi";
        String two = "edcgi";
        System.out.println(lcs(one, 0, two, 0));
    }
}
