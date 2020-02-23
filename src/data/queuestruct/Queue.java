package data.queuestruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： 实现队列接口
 *  @Date: 2020/2/22 19:31
 *  @Email: 1031759184@qq.com
 */
public interface Queue<E> {
    /**
     * 获取队列大小
     * @return 队列的大小
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e 入队的元素
     */
    void enqueue(E e);

    /**
     * 出队
     * @return 出队的元素
     */
    E dequeue();

    /**
     * 获取队首的元素
     * @return 队首的元素
     */
    E getFront();
}
