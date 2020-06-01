package data.binarysearchtreestruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第236题——二叉树的最近公共祖先
 * @Date: 2020/5/10 8:17
 * @Email: 1031759184@qq.com
 */
public class Solution5 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode p, q, result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return result;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) return false;
        boolean leftHaveNode = dfs(node.left);
        boolean rightHaveNode = dfs(node.right);
        boolean isTargetNode = node.val == p.val || node.val == q.val;
        result = (leftHaveNode && rightHaveNode) || (isTargetNode && (leftHaveNode || rightHaveNode)) ? node : result;
        return leftHaveNode || rightHaveNode || isTargetNode;
    }
}
