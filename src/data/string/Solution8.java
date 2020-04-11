package data.string;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第151题——反转字符串中的单词
 *  @Date: 2020/4/10 7:50
 *  @Email: 1031759184@qq.com
 */
public class Solution8 {
    public static String reverseWords(String s) {
        String[] param = s.split(" ");
        if (param.length == 0||"".equals(s)) return "";
        StringBuilder result = new StringBuilder();
        for (int i = param.length-1;i>=0;i--){
            if (!"".equals(param[i])) {
                result.append(param[i]).append(" ");
            }
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "  as";
        reverseWords(s);
    }
}
