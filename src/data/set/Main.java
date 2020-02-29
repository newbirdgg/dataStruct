package data.set;

import data.linkliststruct.LinkedListStack;
import data.stackstruct.ArrayStack;
import data.stackstruct.Stack;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 *  @Author: liyuzhan
 *  @classDesp： 测试链表集合和二分搜索树集合的性能差异
 *  @Date: 2020/2/29 20:14
 *  @Email: 1031759184@qq.com
 */
public class Main {
    private static double time(HashSet<Integer> set, int opCount){
        double startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0;i<opCount;i++){
            set.add(random.nextInt(100000000));
        }
        System.out.println(set);

        double endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
//        BinarySearchTreeSet<Integer> binarySearchTreeSet = new BinarySearchTreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        int opCount = 100000000;
//        System.out.println(time(binarySearchTreeSet,opCount));
//        System.out.println(time(linkedListSet,opCount));
        System.out.println(time(hashSet,opCount));


    }
}
