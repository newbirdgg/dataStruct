package data.binarysearchtreestruct;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第105题——从前序与中序遍历序列构造二叉树
 * @Date: 2020/5/22 7:50
 * @Email: 1031759184@qq.com
 */
public class Solution7 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private HashMap<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hashMap = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int mid) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;
        int rootIndex = hashMap.get(root.val) - mid;
        root.left = dfs(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex), 0);
        root.right = dfs(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length), hashMap.get(root.val) + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] a = {1,4,2,3};
        int[] b = {1,2,3,4};
        Solution7 s = new Solution7();
        s.buildTree(a, b);
    }
}
