package Java.Sorting_Algos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6,5,2,4,26,4344,234,43,1,47};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            int smallest = i;
            for(int j=i+1;j<arr.length;j++) {
                if(compare(arr[j], arr[smallest])) {
                    smallest = j;
                }
            }
            swap(arr, i, smallest);
        }
    }

    private static boolean compare(int i, int j) {
        return i<j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}