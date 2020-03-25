package data.binarysearchtreestruct;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1382题——将二叉搜索树变平衡
 * @Date: 2020/3/23 22:17
 * @Email: 1031759184@qq.com
 */
public class Solution1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // node节点的高度缓存
        Map<TreeNode, Integer> nodeHeight = new HashMap<>();
        TreeNode newRoot = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 先序遍历插入（其实用哪个遍历都行）
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 新树插入
                newRoot = insert(newRoot, node.val, nodeHeight);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return newRoot;
    }

    /**
     * 新节点插入
     *
     * @param root       root
     * @param val        新加入的值
     * @param nodeHeight 节点高度缓存
     * @return 新的root节点
     */
    private TreeNode insert(TreeNode root, int val, Map<TreeNode, Integer> nodeHeight) {
        if (root == null) {
            root = new TreeNode(val);
            // 新节点的高度
            nodeHeight.put(root, 1);
            return root;
        }
        TreeNode node = root;
        int cmp = val - node.val;
        if (cmp < 0) {
            // 左子树插入
            node.left = insert(root.left, val, nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            if (nodeHeight.getOrDefault(node.left, 0) - nodeHeight.getOrDefault(node.right, 0) > 1) {
                if (val > node.left.val) {
                    // 插入在左孩子右边，左孩子先左旋
                    node.left = rotateLeft(node.left, nodeHeight);
                }
                // 节点右旋
                node = rotateRight(node, nodeHeight);
            }
        } else if (cmp > 0) {
            // 右子树插入
            node.right = insert(root.right, val, nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            if (nodeHeight.getOrDefault(node.right, 0) - nodeHeight.getOrDefault(node.left, 0) > 1) {
                if (val < node.right.val) {
                    // 插入在右孩子左边，右孩子先右旋
                    node.right = rotateRight(node.right, nodeHeight);
                }
                // 节点左旋
                node = rotateLeft(node, nodeHeight);
            }
        } else {
            // 一样的节点，啥都没发生
            return node;
        }
        // 获取当前节点高度
        int height = Math.max(nodeHeight.getOrDefault(node.left, 0), nodeHeight.getOrDefault(node.right, 0)) + 1;
        // 更新当前节点高度
        nodeHeight.put(node, height);
        return node;
    }

    /**
     * node节点左旋
     *
     * @param node       node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateLeft(TreeNode node, Map<TreeNode, Integer> nodeHeight) {
        TreeNode right = node.right;
        node.right = right.left;
        right.left = node;
        // 右孩子高度+1
        nodeHeight.put(right, nodeHeight.getOrDefault(right, 0) + 1);
        // 本身高度-1
        nodeHeight.put(node, nodeHeight.getOrDefault(node, 0) - 1);
        return right;
    }

    /**
     * node节点右旋
     *
     * @param node       node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateRight(TreeNode node, Map<TreeNode, Integer> nodeHeight) {
        TreeNode left = node.left;
        node.left = left.right;
        left.right = node;
        // 左孩子高度+1
        nodeHeight.put(left, nodeHeight.getOrDefault(left, 0) + 1);
        // 本身高度-1
        nodeHeight.put(node, nodeHeight.getOrDefault(node, 0) - 1);
        return left;
    }
}
