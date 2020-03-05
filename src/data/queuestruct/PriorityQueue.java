package data.queuestruct;

import data.maxheap.MaxHeap;

/**
 *  @Author: liyuzhan
 *  @classDesp： 用最大堆实现优先级队列
 *  @Date: 2020/3/5 15:07
 *  @Email: 1031759184@qq.com
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    private MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
