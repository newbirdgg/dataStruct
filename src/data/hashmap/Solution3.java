package data.hashmap;
/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第409题——最长回文串(数组解法)
 * @Date: 2020/3/19 7:12
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    private int result,odd;
    public int longestPalindrome(String s) {
        int[] array = new int[52];
        for(char ch : s.toCharArray()) {
            if(ch >= 'a') {
                array[ch-'a'] += 1;
            } else {
                array[ch-'A'+26] += 1;
            }
        }

        for(int count : array) {
            if ((count & 1) == 0){
                result += count;
            }
            if((count & 1) == 1) {
                result+=count-1;
                odd = 1;
            }
        }
        return result+odd;
    }
    public static void main(String[] args) {
        String s = "ccA";
        Solution3 solution = new Solution3();
        System.out.println(solution.longestPalindrome(s));

    }
}
