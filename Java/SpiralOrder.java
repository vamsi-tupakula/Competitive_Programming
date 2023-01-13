package Java;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {5, 6, 7},
            {9, 10, 11}
        };
        spiral(arr);
    }
    public static void spiral(int[][] arr) {
        int top = 0;
        int bottom = arr.length - 1;
        int left = 0;
        int right = arr[0].length-1;
        while(top <= bottom && left <= right) {
            for(int i=left;i<=right;i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            for(int i=top;i<=bottom;i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;

            if(top > bottom || left > right) {
                break;
            }

            for(int i=right;i>=left;i--) {
                System.out.print(arr[bottom][i] + " ");
            }
            bottom--;
 
            for(int i=bottom;i>=top;i--) {
                System.out.print(arr[i][left] + " ");
            }
            left++;
        }
    }
}