package Java;

public class VarArgs {
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 523, 231, 343));
        printer("vamsi", "krishna", "tupakula");
    }

    public static int sum(int... args) {
        int ans = 0;
        for (int i : args) {
            ans += i;
        }
        return ans;
    }

    public static void printer(Object ...v_args) {
        for(Object obj : v_args) {
            System.out.println(obj);
        }
    }
}