package data.map;
/**
 *  @Author: liyuzhan
 *  @classDesp： 映射接口
 *  @Date: 2020/2/29 22:25
 *  @Email: 1031759184@qq.com
 */
public interface Map<K,V> {
    /**
     * 映射添加操作
     * @param key 键
     * @param value 值
     */
    void add(K key,V value);

    /**
     * 映射删除操作
     * @param key 键
     * @return 值
     */
    V remove(K key);

    /**
     * 映射查找包含操作
     * @param key 键
     * @return 是否包含
     */
    boolean contain(K key);

    /**
     * 获取键对应的值
     * @param key 键
     * @return 对应的值
     */
    V get(K key);

    /**
     * 修改指定键的值
     * @param key 指定的键
     * @param newValue 新的值
     */
    void set(K key,V newValue);

    /**
     * 获取映射大小
     * @return 映射大小
     */
    int getSize();

    /**
     * 判断映射是否为空
     * @return 是否为空
     */
    boolean isEmpty();
}
