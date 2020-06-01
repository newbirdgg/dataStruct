package data.string;

import java.util.Map;

/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第394题——字符串解码
 *  @Date: 2020/5/28 7:47
 *  @Email: 1031759184@qq.com
 */
public class Solution14 {
    private int pos;
    public String decodeString(String s) {
           return dfs(s,0);
    }

    private String dfs(String s, int index){
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        for (int i = index;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch>=48&&ch<=57){
                num = 10*num+(ch-48);
            }else if (ch==91){
                String retStr = dfs(s, i + 1);
                while (num>0){
                    stringBuilder.append(retStr);
                    --num;
                }
                i = pos;
            }else if (ch==93){
                pos = i;
                return stringBuilder.toString();
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
