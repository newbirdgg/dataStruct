package data.linkliststruct;

import data.queuestruct.ArrayQueue;
import data.queuestruct.LoopQueue;
import data.queuestruct.Queue;

import java.util.Random;

/**
 *  @Author: liyuzhan
 *  @classDesp： 测试循环队列、数组队列以及链表队列性能差异
 *  @Date: 2020/2/24 22:03
 *  @Email: 1031759184@qq.com
 */
public class Main1 {
    private static double time(Queue<Integer> queue, int opCount){
        double startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0;i<opCount;i++){
            queue.enqueue(random.nextInt(100000));
        }
        for (int i = 0;i<opCount;i++){
            queue.dequeue();
        }
        double endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        int opCount = 100000;

        System.out.println("数组队列="+time(arrayQueue,opCount));
        System.out.println("循环队列="+time(loopQueue,opCount));
        System.out.println("链表队列="+time(linkedListQueue,opCount));
    }
}
