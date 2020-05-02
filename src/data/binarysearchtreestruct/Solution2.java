package data.binarysearchtreestruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第199题——二叉树的右视图
 * @Date: 2020/4/22 8:54
 * @Email: 1031759184@qq.com
 */
public class Solution2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> result;
    private int maxHeight;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        dfs(root,1);
        return result;
    }

    private void dfs(TreeNode node,int height) {
        if (node == null) return;
        if (height>maxHeight){
            result.add(node.val);
            maxHeight = height;
        }
        dfs(node.right,height+1);
        dfs(node.left,height+1);
    }

}
