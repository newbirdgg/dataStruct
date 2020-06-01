package data.binarysearchtreestruct;

import java.util.LinkedList;
import java.util.List;

public class Solution6 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i< size; i++){
                TreeNode curNode = queue.pop();
                list.add(curNode.val);
                if (curNode.left!=null) queue.add(curNode.left);
                if (curNode.right!=null) queue.add(curNode.right);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20);
        a.right.right = new TreeNode(7);
        a.right.left = new TreeNode(15);
        Solution6 s = new Solution6();
        s.levelOrder(a);
    }
}
