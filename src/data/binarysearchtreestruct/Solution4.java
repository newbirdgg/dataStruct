package data.binarysearchtreestruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第572题——另一个树的子树
 * @Date: 2020/5/7 7:58
 * @Email: 1031759184@qq.com
 */
public class Solution4 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean result;
    private TreeNode subTree;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        subTree = t;
        dfs(s);
        return result;
    }

    private void dfs(TreeNode tree) {
        if (null == tree) return;
        if (tree.val == subTree.val) result = isEquals(tree, subTree);
        if (!result){
            dfs(tree.left);
            dfs(tree.right);
        }

    }

    private boolean isEquals(TreeNode tree, TreeNode subTree) {
        if (null == tree && null == subTree) return true;
        if (null != tree && null == subTree) return false;
        if (null == tree && null != subTree) return false;
        if (tree.val != subTree.val) return false;
        return isEquals(tree.left, subTree.left) && isEquals(tree.right, subTree.right);
    }

}
