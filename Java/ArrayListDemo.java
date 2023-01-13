package Java;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int i=0;i<20;i++){
            ls.add(i+1);
        }
        for(int num : ls){
            System.out.println(num);
        }
    }
}
