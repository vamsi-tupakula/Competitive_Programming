package Java.Backtracking;

import java.util.Scanner;

public class Permutations {
    public static void permutationsOfAString(String str, int p) {
        if(p == str.length()) {
            System.out.println(str);
            return;
        }
        for (int i = p; i < str.length(); i++) {
            permutationsOfAString(swap(str, i, p), p + 1);
        }
    }
    private static String swap(String str, int i, int p) {
        if ( i < 0 || i >= str.length() || p < 0 || p >= str.length()) {
            return str;
        }

        char[] charArr = str.toCharArray();
        char temp = charArr[i];
        charArr[i] = charArr[p];
        charArr[p] = temp;

        return new String(charArr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        permutationsOfAString(str, 0);
        sc.close();
    }
}
