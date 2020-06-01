package data.string;
/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第76题——最小覆盖子串
 * @Date: 2020/5/23 7:54
 * @Email: 1031759184@qq.com
 */
public class Solution13 extends Solution{
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.length() == 1 && s.charAt(0) != t.charAt(0)) return "";
        int[] tHashMap = new int[130];
        int[] sHashMap = new int[130];
        for (char ch : t.toCharArray()) {
            ++tHashMap[ch];
        }
        int head = 0, tail = 0, count = 0, minLen = Integer.MAX_VALUE, minHead = -1, minTail = -1;
        char[] chars = s.toCharArray();
        while (tail < chars.length) {
            if (count < t.length()) {
                if (tHashMap[chars[tail]] > 0) {
                    count = sHashMap[chars[tail]] < tHashMap[chars[tail]] ? count + 1 : count;
                    ++sHashMap[chars[tail]];
                }
                ++tail;

            }
            if (count >= t.length() || tail >= chars.length) {
                while (count >= t.length()) {
                    if (tail - head - 1 < minLen) {
                        minLen = tail - head - 1;
                        minHead = head;
                        minTail = tail - 1;
                    }
                    if (sHashMap[chars[head]] > 0) {
                        count = sHashMap[chars[head]] <= tHashMap[chars[head]] ? count - 1 : count;
                        sHashMap[chars[head]]--;
                    }
                    ++head;
                }
            }
        }
        return minHead == -1 ? "" : s.substring(minHead, minTail + 1);
    }

    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "ABC";
        Solution13 s = new Solution13();
        s.minWindow(a, b);

    }
}
