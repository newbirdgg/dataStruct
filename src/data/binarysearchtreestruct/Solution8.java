package data.binarysearchtreestruct;

import java.util.ArrayList;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第101题——对称二叉树
 * @Date: 2020/5/31 6:44
 * @Email: 1031759184@qq.com
 */
public class Solution8 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private ArrayList<Integer> arrayListLeftL;
    private ArrayList<Integer> arrayListLeftR;
    public boolean isSymmetric(TreeNode root) {
        if (null==root)return true;
        arrayListLeftL = new ArrayList<>();
        arrayListLeftR = new ArrayList<>();
        dfsL(root.left);
        dfsR(root.right);
        if (arrayListLeftL.size()==arrayListLeftR.size()){
            for (int i = 0;i<arrayListLeftL.size();i++){
                if (!arrayListLeftL.get(i).equals(arrayListLeftR.get(i))) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    private void dfsL(TreeNode node){
        if (node == null) {
            arrayListLeftL.add(-1);
            return;
        }
        arrayListLeftL.add(node.val);
        dfsL(node.left);
        dfsL(node.right);
    }
    private void dfsR(TreeNode node){
        if (node == null) {
            arrayListLeftR.add(-1);
            return;
        }
        arrayListLeftR.add(node.val);
        dfsR(node.right);
        dfsR(node.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
//        node.right = new TreeNode(2);
//        node.left.right = new TreeNode(3);
//        node.right.right = new TreeNode(3);
        Solution8 s =new Solution8();
        s.isSymmetric(node);
    }
}
