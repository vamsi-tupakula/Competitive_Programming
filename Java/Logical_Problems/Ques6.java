package Java.Logical_Problems;
import java.util.Scanner;

public class Ques6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.next();
        }
        sortNames(arr);
        for(String elem : arr) {
            System.out.print(elem + " ");
        }
        sc.close();
    }

    private static void sortNames(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
