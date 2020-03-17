package data.string;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第1160题——拼写单词（数组解法）
 * @Date: 2020/3/17 8:15
 * @Email: 1031759184@qq.com
 */
public class Solution4 {
    private int result;

    public int countCharacters(String[] words, String chars) {
        int[] a = new int[26];
        for (char ch : chars.toCharArray()) {
            int index = ch - 'a';
            a[index]++;
        }
        for (String word : words) {
            int[] b = new int[26];
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                b[index]++;
            }
            for (int i = 0; i < 26; i++) {
                if (a[i] < b[i]) {
                    break;
                }
                if (i==25){
                    result += word.length();
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] s = {"cat","bt","hat","tree"};
        String c = "atach";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.countCharacters(s, c));
    }
}
