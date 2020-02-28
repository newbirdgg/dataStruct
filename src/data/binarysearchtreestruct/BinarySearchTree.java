package data.binarysearchtreestruct;

import data.linkliststruct.LinkedListQueue;

import java.util.Stack;

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

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树层序遍历
     */
    public void levelOrder() {
        LinkedListQueue<Node> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue(root);
        while (!linkedListQueue.isEmpty()) {
            Node cur = linkedListQueue.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                linkedListQueue.enqueue(cur.left);
            }
            if (cur.right != null) {
                linkedListQueue.enqueue(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return 最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST si Empty");
        }
        return minimum(root).e;
    }

    /**
     * 寻找以Node为根的二分搜索树的最小键值所在节点
     *
     * @param node 最小值节点
     * @return 最小值
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return 最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST si Empty");
        }
        return maximum(root).e;
    }

    /**
     * 寻找以Node为根的二分搜索树的最小大键值所在节点
     *
     * @param node 最大值节点
     * @return 最大值
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     *
     * @return 返回的最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中最小的节点
     *
     * @param node 遍历的节点
     * @return 新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点，返回最大值
     *
     * @return 返回的最大值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中最大的节点
     *
     * @param node 遍历的节点
     * @return 新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e 被删除的节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点，递归算法
     *
     * @param node 递归的节点
     * @param e    被删除的元素
     * @return 删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空
            node.e = minimum(node.right).e;
            node.right = removeMin(node.right);
            return node;
        }
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
