package data.binarysearchtreestruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第98题——验证二叉搜索树
 * @Date: 2020/5/5 7:32
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private boolean isValidBST = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root,null,null);
        return isValidBST;
    }

    private Integer dfs(TreeNode node,Integer min ,Integer max){
        if (node==null)return null;
        Integer leftVal = dfs(node.left,min,node.val),rightVal = dfs(node.right,node.val,max);
        boolean judgment = (null!=leftVal&&leftVal>node.val||null!=rightVal&&rightVal<node.val)||(null!=min&&node.val<=min||null!=max&&node.val>=max);
        if (judgment) isValidBST=false;
        return node.val;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left= new TreeNode(1);
        a.right = new TreeNode(3);
        Solution3 s = new Solution3();
        s.isValidBST(a);
    }
}
