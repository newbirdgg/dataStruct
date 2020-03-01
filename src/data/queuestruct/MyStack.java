package data.queuestruct;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  @Author: liyuzhan
 *  @classDesp： 力扣队列实现栈
 *  @Date: 2020/3/1 22:18
 *  @Email: 1031759184@qq.com
 */
public class MyStack {
    private Queue<Integer> list;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        list = new LinkedList<>();
        size = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
        size++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        for (int i = 0;i<size-1;i++){
            list.add(list.poll());
        }
        size--;
        return list.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        for (int i = 0;i<size-1;i++){
            list.add(list.poll());
        }
        int res = list.poll();
        list.add(res);
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("tail [ ");
        for (Integer i : list) {
            res.append(i).append(" ");
        }
        res.append(" ]top");
        return res.toString();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        System.out.println(myStack);
        myStack.push(2);
        System.out.println(myStack);
        myStack.push(3);
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
    }
}
