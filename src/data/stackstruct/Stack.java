package data.stackstruct;

/**
 * @Author: liyuzhan
 * @classDesp： 实现栈的接口
 * @Date: 2020/2/21 20:29
 * @Email: 1031759184@qq.com
 */
public interface Stack<E> {
    /**
     * 获得栈的大小
     * @return 栈的大小
     */
    int getSize();

    /**
     * 判断是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e 入栈的元素
     */
    void push(E e);

    /**
     * 出栈
     * @return 出栈的元素
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return 栈顶的元素
     */
    E peek();
}
