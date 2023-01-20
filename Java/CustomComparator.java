package Java;

import java.util.*;

public class CustomComparator {
    public static void main(String[] args) {
        Student one = new Student();
        one.roll = 253;
        one.name = "John";
        one.age = 20;
        Student two = new Student();
        two.roll = 176;
        two.name = "Jane";
        two.age = 19;
        Student three = new Student();
        three.roll = 89;
        three.name = "Mike";
        three.age = 22;

        ArrayList<Student> arr = new ArrayList<>();
        arr.add(one);
        arr.add(two);
        arr.add(three);
        // Collections.sort(arr, new SortByRoll());
        
        Collections.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.roll - o2.roll;
            }
        });

        arr.sort((Student s1, Student s2) -> {return s1.roll - s2.roll;});
        
        for(Student s : arr) {
            System.out.println(s.roll + " " + s.name + " " + s.age);
        }
    }
}

class Student {
    int roll;
    String name;
    int age;
}

class SortByRoll implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.roll - o2.roll;
    }
}