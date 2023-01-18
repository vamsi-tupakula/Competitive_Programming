package Java.Sorting_Algos;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1000,3,234,22,175,23,78,428));
        
        System.out.println(list);
        radix_sort(list);
        System.out.println(list);
    }

    private static void radix_sort(List<Integer> list) {
        int max = Collections.max(list); // get max elem from the list
        int digits = Integer.toString(max).length(); // get digits of max elem

        for(int p=0;p<digits;p++) {
            normal_sort(list,p);
        }
    }

    private static void normal_sort(List<Integer> list, int p) {
        Collections.sort(list,new SortByLast(p));
        System.out.println("sorted based on place value " + p + " : " + list);
    }
}

class SortByLast implements Comparator<Integer> {
    
    int p;
    public SortByLast(int p) {
        this.p = p;
    }

    @Override
    public int compare(Integer a, Integer b) {
        return getLastDigit(a, p) - getLastDigit(b, p);
    }

    public int getLastDigit(int a, int p) {
        return (a/(int)(Math.pow(10, p)))%10;
    }
}