package Java.Sorting_Algos;

import java.util.Arrays;

// sorting a 2D array based on certain column
public class Sort2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {5,1,0,7},
            {1,2,8,9},
            {3,7,6,4},
            {2,8,10,1}
        };

        sort(arr,2);
        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void sort(int[][] arr,int col) {
        if(col > arr.length) return;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length-1;j++) {
                if(arr[j][col-1] > arr[j+1][col-1]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
