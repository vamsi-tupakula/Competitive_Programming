package Java.Sorting_Algos;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = {1,5,7,9};
        int[] b = {2,3,4,6,10};
        int[] arr = merge(a,b);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] arr = new int[m+n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(a[i] < b[j]) { 
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }

        while(i<m) {
            arr[k] =a[i];
            i++;k++;
        }
        while(j<n) {
            arr[k] = b[j];
            j++;k++;
        }
        return arr;
    }
}