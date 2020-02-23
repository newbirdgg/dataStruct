package data.linkliststruct;

/**
 * @Author: liyuzhan
 * @classDesp： 链表的实现类
 * @Date: 2020/2/23 20:55
 * @Email: 1031759184@qq.com
 */
public class LinkedList<E> {
    /**
     * 节点内部类
     */
    private class Node {
        public E e;
        public Node next;

        //构造函数
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表的头虚拟头结点
     */
    private Node dummyHead;
    /**
     * 链表大小
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index 索引位置
     * @param e     被添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 在链表的尾部插入元素
     *
     * @param e 被插入的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在链表头添加新的元素
     *
     * @param e 被添加的元素
     */
    public void addFirst(E e) {
        add(0,e);
    }
}
