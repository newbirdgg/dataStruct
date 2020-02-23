package data.queuestruct;

import java.util.Random;

/**
 * @Author: liyuzhan
 * @classDesp： 队列测试类，测试ArrayQueue和LoopQueue的运行效率
 * @Date: 2020/2/22 19:45
 * @Email: 1031759184@qq.com
 */
public class Main {
    private static double time(Queue<Integer> queue,int opCount){
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
        int opCount = 100000;

        System.out.println(time(arrayQueue,opCount));
        System.out.println(time(loopQueue,opCount));
    }

}
