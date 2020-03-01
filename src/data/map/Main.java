package data.map;

import data.linkliststruct.LinkedListQueue;
import data.queuestruct.ArrayQueue;
import data.queuestruct.LoopQueue;
import data.queuestruct.Queue;

import java.util.Random;
/**
 *  @Author: liyuzhan
 *  @classDesp： 二分搜索树映射和链表映射性能比较
 *  @Date: 2020/3/1 20:19
 *  @Email: 1031759184@qq.com
 */
public class Main {
    private static double time(Map<Integer,String> map, int opCount){
        double startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0;i<opCount;i++){
            map.add(random.nextInt(100000),"test");
        }
        for (int i = 0;i<opCount;i++){
            map.remove(i);
        }
        double endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        BinarySearchTreeMap<Integer,String> binarySearchTreeMap = new BinarySearchTreeMap<>();
        LinkedListMap<Integer,String> linkedListMap = new LinkedListMap<>();
        int opCount = 100000;
        System.out.println("二分搜索树映射="+time(binarySearchTreeMap,opCount));
        System.out.println("链表映射="+time(linkedListMap,opCount));

    }
}
