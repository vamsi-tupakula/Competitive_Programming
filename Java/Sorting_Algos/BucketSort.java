package Java.Sorting_Algos;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {1,7,2,5,4,8,10,9,1,7,2,5,4,8,10,9,1,7,2,5,4,8,10,9,1,7,2,5,4,8,10,9,1,7};
        bucket_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bucket_sort(int[] arr) {
        HashMap<Integer, Integer> buckets = new HashMap<>();
        for(int elem : arr) {
            if(buckets.containsKey(elem)) {
                buckets.put(elem, buckets.get(elem)+1);
            } else {
                buckets.put(elem, 1);
            }
        }

        int k = 0;
        for(int key : buckets.keySet()) {
            int count = buckets.get(key);
            int i=0;
            while(i < count) {
                arr[k] = key;
                k++;i++;
            }
        }
    }
}