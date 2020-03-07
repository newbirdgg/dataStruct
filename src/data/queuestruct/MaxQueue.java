package data.queuestruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第59题-队列最大值
 * @Date: 2020/3/7 7:33
 * @Email: 1031759184@qq.com
 */
public class MaxQueue {
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private Node maxNode;

    public MaxQueue() {
        head = new Node(-1,null);
        tail = new Node(-1,null);
        maxNode = null;
    }

    public int max_value() {
        if (maxNode == null) {
            return -1;
        }
        return maxNode.value;
    }

    public void push_back(int value) {
        if (tail.value == head.value) {
            tail = new Node(value, null);
            maxNode = tail;
            head.next = tail;
            return;
        }
        tail.next = new Node(value, null);
        if (maxNode.value < tail.next.value) {
            maxNode = tail.next;
        }

        tail = tail.next;

    }

    public int pop_front() {
        if (head.value == tail.value) {
            return -1;
        }
        if (head.next == tail) {
            tail = new Node(-1,null);
            maxNode = new Node(-1,null);
            return -1;
        }
        if (head.next.value == maxNode.value) {
            maxNode = maxNode.next;
            while (maxNode != null && maxNode.next != null) {
                if (maxNode.value < maxNode.next.value) {
                    maxNode = maxNode.next;
                }
            }
        }
        Node remove = head.next;
        head.next = head.next.next;
        return remove.value;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        int param1 = maxQueue.max_value();
        System.out.println(param1);
        maxQueue.pop_front();
        maxQueue.pop_front();
        maxQueue.push_back(94);
        maxQueue.push_back(16);
        maxQueue.push_back(89);
        maxQueue.pop_front();
        maxQueue.push_back(22);
        maxQueue.pop_front();



    }
}
