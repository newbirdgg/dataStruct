package data.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        Student student1 = new Student("lyz",1);
        Student student2 = new Student("lyz",1);
        System.out.println(student1.equals(student2));
        Map<Student,Integer> hashMap = new HashMap<>(16);
        hashMap.put(student1,123);
        hashMap.put(student2,123);
        Integer integer = hashMap.get(student2);
        System.out.println(integer);

        System.out.println(-100 % 3);

        System.out.println(Math.abs(-100) % 3);
        System.out.println(Integer.MAX_VALUE - Math.abs(-100) + 1);
        //1100 ->0100
        int a = 12;
        System.out.println(a&(~a+1));
        //0010 1100 -> 0000 1000
        //b: 0010 1100
        //~b:1101 0011
        //~b+1: 1101 0100
        //b: 0010 1100
        //b&(~b+1):0000 0100
        //b-b&(~b+1):0010 1000
        //(b-b&(~b+1))&(~(b-b&(~b+1))+1):0000 1000
        int b = 4;
        int c = b-(b&(~b+1));
        System.out.println(c&(~c+1));

    }
}
