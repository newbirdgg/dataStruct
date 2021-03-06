package data.unionfind;
/**
 *  @Author: liyuzhan
 *  @classDesp： 并查集第六版-针对第五版优化
 *  @Date: 2020/3/9 10:27
 *  @Email: 1031759184@qq.com
 */
public class UnionFind6 implements UnionFindInterface{
    private int[] parent;
    /**
     * rank[i]表示以i为根的集合中树的层数
     */
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找过程，时间复杂度为O(h)，h为树的高度
     *
     * @param p 元素p
     * @param q 元素q
     * @return 元素p所对应集合编号
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * 时间复杂度为O(h)，h为树的高度
     *
     * @param p 元素p
     * @param q 元素q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //根据两个元素所在树的rank不同判断合并方向
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程，查找元素为p所对应的集合编号
     * 时间复杂度为O(h)，h为树的高度
     *
     * @param p 元素p
     * @return 对应的集合编号
     */
    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
}
