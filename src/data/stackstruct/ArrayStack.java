package data.stackstruct;

import data.arraystruct.Array;

/**
 *  @Author: liyuzhan
 *  @classDesp： 栈的实现类(基于之前写的动态数组)
 *  @Date: 2020/2/21 20:36
 *  @Email: 1031759184@qq.com
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isArrayEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for (int i = 0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
