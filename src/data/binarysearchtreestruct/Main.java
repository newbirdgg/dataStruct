package data.binarysearchtreestruct;

import java.util.ArrayList;
import java.util.Random;

/**
 *  @Author: liyuzhan
 *  @classDesp： 二分搜索树测试用例
 *  @Date: 2020/2/26 17:21
 *  @Email: 1031759184@qq.com
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0;i<n;i++){
            binarySearchTree.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!binarySearchTree.isEmpty()){
            nums.add(binarySearchTree.removeMax());
        }
        System.out.println(nums);
        for (int i = 1;i<nums.size();i++){
            if (nums.get(i-1)<nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed");

    }
}
