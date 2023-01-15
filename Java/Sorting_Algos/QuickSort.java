package Java.Sorting_Algos;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,7,2,5,4,8,10,9};
        quick_sort(arr,0,7);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick_sort(int[] arr,int a,int b) {
        if(a >= b) return;
        int p = partition(arr,a,b);
        quick_sort(arr,a,p-1);
        quick_sort(arr,p+1,b);
    }

    private static int partition(int[] arr, int a, int b) {
        int pivot = b;
        int left = a-1;
        for(int right=a;right<b;right++) {
            if(arr[right] < arr[pivot]) {
                left++;
                swap(arr, left, right);
            }
        }
        swap(arr, left+1, pivot);
        return left+1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] =temp;
    }
}