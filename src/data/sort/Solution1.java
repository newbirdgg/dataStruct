package data.sort;
/**
 *  @Author: liyuzhan
 *  @classDesp： 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。请完成一个函数，
 *  输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *  @Date: 2020/3/20 9:58
 *  @Email: 1031759184@qq.com
 */
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
