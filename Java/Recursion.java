package Java;

public class Recursion {
    public static void main(String[] args) {
        count_down(4);
    }

    private static void count_down(int i) {
        if(i == 0) return;
        System.out.println(i);
        i--;
        count_down(i);
    }
}