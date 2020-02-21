package data.stackstruct;

/**
 * @Author: liyuzhan
 * @classDesp： 栈测试类
 * @Date: 2020/2/21 20:56
 * @Email: 1031759184@qq.com
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
