package data.set;

import data.linkliststruct.LinkedList;

/**
 *  @Author: liyuzhan
 *  @classDesp： 基于链表实现的集合
 *  @Date: 2020/2/29 19:41
 *  @Email: 1031759184@qq.com
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> linkedList;
    public LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    public void remove(){
        linkedList.removeFirst();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
