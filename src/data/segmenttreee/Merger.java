package data.segmenttreee;
/**
 *  @Author: liyuzhan
 *  @classDesp： 适配接口
 *  @Date: 2020/3/6 15:23
 *  @Email: 1031759184@qq.com
 */
public interface Merger<E> {
    /**
     * 将两个元素返回成一个元素
     * @param a 元素a
     * @param b 元素b
     * @return 新的元素
     */
    E merge(E a,E b);
}
