package Java;

import java.util.*;
import java.util.function.Consumer;

public class LambdaFunction {
    public static void main(String[] args) {
        // use java's consumer interface to store a lambda expression in a variable
        Consumer<Integer> fun = (i) -> System.out.println(i);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list.forEach(fun);
        System.out.println("squares : ");
        list.forEach((n) -> System.out.println(n*n));
    }
}
