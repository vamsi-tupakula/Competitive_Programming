package Java;

import java.util.*;

public class FibonacciUsingDP {
    public static void main(String[] args) {
        int n = 100;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            System.out.println(i + " " + fibo(i, map));
        }
    }

    private static int fibo(int n, Map<Integer, Integer> map) {
        if(n == 0 || n == 1) return n;
        if(map.containsKey(n)) return map.get(n);
        map.put(n, fibo(n-1, map) + fibo(n-2, map));
        return map.get(n);
    }
}