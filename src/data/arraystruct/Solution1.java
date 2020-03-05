package data.arraystruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第1103-分糖果II
 *  @Date: 2020/3/5 8:26
 *  @Email: 1031759184@qq.com
 */
class Solution1 {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] n = new int[num_people];
        //索引
        int i = 0;
        int curCandies = 1;
        while (candies > 0) {
            n[i % num_people] += Math.min(candies, curCandies);
            candies -= curCandies;
            curCandies++;
            i++;
        }
        return n;
    }

    public static void main(String[] args) {
        int candies = 7;
        int num_people = 4;
        System.out.println(distributeCandies(candies, num_people));
    }
}
