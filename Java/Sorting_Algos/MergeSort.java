package Java.Sorting_Algos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,7,2,5,4,8,10,9};
        mergeSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int a, int b) {
        if(a == b) return;
        int mid = a + (b-a)/2;
        mergeSort(arr, a, mid);
        mergeSort(arr, mid+1, b);
        merge(arr,a,b,mid);
    }

    private static void merge(int[] arr, int a, int b, int mid) {
        int n1 = mid-a+1;
        int n2 = b-mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++) L[i] = arr[a+i];
        for(int i=0;i<n2;i++) R[i] = arr[mid+i+1];
        int i=0,j=0,k=a;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}