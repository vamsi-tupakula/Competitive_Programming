package Java.Logical_Problems;

import java.util.Scanner;

public class Ques8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntObject num1 = new IntObject(sc.nextInt());
        IntObject num2 = new IntObject(sc.nextInt());
        swap(num1, num2);
        System.out.println(num1.data + " " + num2.data);
        sc.close();
    }

    private static void swap(IntObject num1, IntObject num2) {
        int temp = num1.data;
        num1.data = num2.data;
        num2.data = temp;
    }
}

class IntObject {
    int data;
    public IntObject(int value) {
        this.data = value;
    } 
}