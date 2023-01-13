package Java.Logical_Problems;

import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        displayDigits(n);
        sc.close();
    }

    private static void displayDigits(int n) {
        int i=0;
        int odd = 0,even = 0,zeros = 0;
        while(i < 4) {
            int ld = n%10;
            n = n/10;
            if(ld == 0) zeros++;
            else if(ld%2 == 0) even++;
            else odd++;
            i++;
        }
        System.out.println("zeros : " + zeros);
        System.out.println("odd: " + odd);
        System.out.println("even : " + even);
    }
}
