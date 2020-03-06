package data.segmenttreee;


/**
 * @Author: liyuzhan
 * @classDesp： 线段树
 * @Date: 2020/3/6 15:02
 * @Email: 1031759184@qq.com
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     *
     * @param treeIndex 树节点的索引
     * @param l         开始区间索引
     * @param r         结束区间索引
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    /**
     * 获取线段树的大小
     *
     * @return 线段树大小
     */
    public int getSize() {
        return data.length;
    }

    /**
     * 获取线段树中指定索引的元素
     *
     * @param index 索引
     * @return 要获取的元素
     */
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    /**
     * 指定索引的左孩子
     *
     * @param index 指定索引
     * @return 左孩子索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 指定索引的右孩子
     *
     * @param index 指定索引
     * @return 右孩子索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 返回区间[queryL,queryR]的值
     *
     * @param queryL 开始区间
     * @param queryR 结束区间
     * @return 区间值
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeId为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     *
     * @param treeIndex 树节点索引
     * @param l         当前节点起始区间
     * @param r         当前节点结束区间
     * @param queryL    要查找的起始区间
     * @param queryR    要查找的结束区间
     * @return 要查找的区间的值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex,l,mid,queryL,queryR);
        }else {
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult,rightResult);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
