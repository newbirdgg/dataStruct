package data.linkliststruct;

import data.stackstruct.Stack;

/**
 *  @Author: liyuzhan
 *  @classDesp： 用链表实现栈结构
 *  @Date: 2020/2/24 21:03
 *  @Email: 1031759184@qq.com
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "Stack: top " +
                list;
    }
}
