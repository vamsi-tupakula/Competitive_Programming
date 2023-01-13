package Java;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        for(int i=1;i<=50;i++){
            vec.add(i);
            System.out.println("size : " + vec.size() + " capacity : " + vec.capacity());
        }
    }
}
