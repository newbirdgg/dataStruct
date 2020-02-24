package data.linkliststruct;

import data.queuestruct.ArrayQueue;
import data.queuestruct.LoopQueue;
import data.queuestruct.Queue;
import data.stackstruct.ArrayStack;
import data.stackstruct.Stack;

import java.util.Random;

/**
 *  @Author: liyuzhan
 *  @classDesp： 测试链表栈和数组栈的性能差异
 *  @Date: 2020/2/24 19:41
 *  @Email: 1031759184@qq.com
 */
public class Main {
    private static double time(Stack<Integer> stack, int opCount){
        double startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0;i<opCount;i++){
            stack.push(random.nextInt(100000));
        }
        for (int i = 0;i<opCount;i++){
            stack.pop();
        }
        double endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        int opCount = 10000000;
        System.out.println(time(linkedListStack,opCount));
        System.out.println(time(arrayStack,opCount));

    }
}
