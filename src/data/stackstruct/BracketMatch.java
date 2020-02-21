package data.stackstruct;

import javax.swing.*;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第20题——括号匹配
 * @Date: 2020/2/21 21:48
 * @Email: 1031759184@qq.com
 */
public class BracketMatch {
    static boolean valid(String s) {
        if (s.length()%2!=0){
            return false;
        }
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char param = s.charAt(i);
            if (param == '(' || param == '[' || param == '{') {
                arrayStack.push(param);
            } else {
                char stackTop = arrayStack.pop();
                if (param == ')' && stackTop != '(') {
                    return false;
                }
                if (param == ']' && stackTop != '[') {
                    return false;
                }
                if (param == '}' && stackTop != '{') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String param = "()[]{}";
        System.out.println(valid(param));

    }
}
