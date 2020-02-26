package data.binarysearchtreestruct;

/**
 * @Author: liyuzhan
 * @classDesp： 实现二分搜索树
 * <p>
 * 因为二分搜索树所有数据都要具有可比性，所以泛型继承Comparable
 * @Date: 2020/2/26 15:35
 * @Email: 1031759184@qq.com
 */
public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * 树节点
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 树的大小
     */
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取树的大小
     *
     * @return 树的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断树是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     *
     * @param e 被添加的元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中添加元素e，递归算法
     * 返回插入新节点后的二分搜索树的根
     *
     * @param node 树节点
     * @param e    被添加的元素
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     *
     * @param e 查找的元素
     * @return 是否包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树是否包含元素e，递归算法
     *
     * @param node 树节点
     * @param e    查找的元素
     * @return 是否包含
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node 树节点
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     *
     * @param node 树节点
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二分搜索树后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     *
     * @param node 树节点
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
