package data.binarysearchtreestruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： 二分搜索树测试用例
 *  @Date: 2020/2/26 17:21
 *  @Email: 1031759184@qq.com
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num:nums){
            binarySearchTree.add(num);
        }
        binarySearchTree.preOrder();
        System.out.println();

        binarySearchTree.inOrder();
        System.out.println();

        binarySearchTree.postOrder();
        System.out.println();
    }
}
