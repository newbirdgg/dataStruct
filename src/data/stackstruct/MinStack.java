package data.stackstruct;


import java.util.LinkedList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第155题——最小栈
 * @Date: 2020/5/12 8:07
 * @Email: 1031759184@qq.com
 */
public class MinStack {
    private final LinkedList<Integer> stack;
    private int minNum;

    public MinStack() {
        this.stack = new LinkedList<>();
        this.minNum = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.addLast(x);
        minNum = Math.min(minNum, x);
    }

    public void pop() {
        int popNum = stack.removeLast();
        if (minNum == popNum && !stack.contains(minNum)) {
            minNum = Integer.MAX_VALUE;
            for (int i = 0;i<stack.size();i++){
                minNum = Math.min(minNum,stack.get(i));
            }
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minNum;
    }
}
