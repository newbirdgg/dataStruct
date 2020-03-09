package data.unionfind;

/**
 * @Author: liyuzhan
 * @classDesp： 并查集接口
 * @Date: 2020/3/9 8:19
 * @Email: 1031759184@qq.com
 */
public interface UnionFindInterface {
    /**
     * 查看两个元素是否是连接的
     * @param p 元素p
     * @param q 元素q
     * @return 是否连接
     */
    boolean isConnected(int p, int q);

    /**
     * 把两个元素的集合合并起来
     * @param p 元素p
     * @param q 元素q
     */
    void unionElements(int p, int q);

    /**
     * 返回并查集考虑多少元素
     * @return 多少元素
     */
    int getSize();
}
