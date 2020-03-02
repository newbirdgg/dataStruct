package data.maxheap;

import java.util.Random;

/**
 * @Author: liyuzhan
 * @classDesp： 最大堆的测试类
 * @Date: 2020/3/2 20:28
 * @Email: 1031759184@qq.com
 */
public class Main {
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (int num:testData){
                maxHeap.add(num);
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 10000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        System.out.println(testHeap(testData,false));
        System.out.println(testHeap(testData,true));
    }
}
