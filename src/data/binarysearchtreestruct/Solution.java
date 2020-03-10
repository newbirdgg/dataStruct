package data.binarysearchtreestruct;

import data.map.Map;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第543题-二叉树直径
 *  @Date: 2020/3/10 7:27
 *  @Email: 1031759184@qq.com
 */
public class Solution {
    private int max = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
    private int height(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        max = Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
