package data.maxheap;

import data.arraystruct.Array;

/**
 * @Author: liyuzhan
 * @classDesp： 基于动态数组实现最大堆
 * @Date: 2020/3/2 19:41
 * @Email: 1031759184@qq.com
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * heapify对一个数组进行堆化操作
     * @param arr 数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--){
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     *
     * @return 元素个数
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return data.isArrayEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index 索引
     * @return 父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中每一个索引所表示的元素的左孩子节点的索引
     *
     * @param index 索引
     * @return 左孩子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中每一个索引所表示的元素的右孩子节点的索引
     *
     * @param index 索引
     * @return 右孩子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向完全二叉树的数组添加元素
     *
     * @param e 被添加的元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 节点的上浮
     *
     * @param k 节点索引
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看堆中最大的元素
     *
     * @return 最大的元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大的元素
     *
     * @return 最大的元素
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 节点下沉
     *
     * @param k 节点索引
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中最大的元素，并且替换成e
     *
     * @param e 要替换的元素
     * @return 被替换的元素
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
