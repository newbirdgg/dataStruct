package data.unionfind;

/**
 * @Author: liyuzhan
 * @classDesp： 并查集第三版-针对第二版优化
 * @Date: 2020/3/9 9:29
 * @Email: 1031759184@qq.com
 */
public class UnionFind3 implements UnionFindInterface {
    private int[] parent;
    /**
     * sz[i]表示以i为根的集合中元素的个数
     */
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
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
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
