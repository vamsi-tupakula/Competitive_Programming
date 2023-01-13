package Java;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCollections {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<5;i++){
            list.add(i+1);
        }
        for(int i=0;i<5;i++) {
            System.out.println(list.get(i));
            list.set(i, (int)(Math.pow(list.get(i), 2)));
        }
        print_iter(list);
    }

    private static void print_iter(LinkedList<Integer> list) {
        System.out.println("using iterator ::");
        Iterator<Integer> itr = list.iterator();
        while (true) {
            System.out.println(itr.next());
            if(!itr.hasNext()) {
                break;
            }
        }
    }
}
