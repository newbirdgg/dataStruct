package data.set;
/**
 *  @Author: liyuzhan
 *  @classDesp： 集合接口类
 *  @Date: 2020/2/29 19:19
 *  @Email: 1031759184@qq.com
 */
public interface Set<E> {
    /**
     * 集合添加接口
     * @param e 被添加的元素
     */
    void add(E e);

    /**
     * 集合删除接口
     * @param e 被删除的元素
     */
    void remove(E e);

    /**
     * 是否包含传入元素
     * @param e 被检查的元素
     * @return 是否包含
     */
    boolean contains(E e);

    /**
     * 获取集合大小
     * @return 集合大小
     */
    int getSize();

    /**
     * 判断是否为空
     * @return 是否为空
     */
    boolean isEmpty();
}
