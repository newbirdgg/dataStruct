package data.trie;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第820题——单词的压缩编码
 * @Date: 2020/3/28 7:09
 * @Email: 1031759184@qq.com
 */


public class Solution1 {
    static class Node {
        public int count;
        public boolean isWord;
        public HashMap<Character, Node> next;
        public Node(int count,boolean isWord) {
            this.isWord = isWord;
            this.count = count;
            next = new HashMap<>();
        }

        public Node() {
            this(1,false);
        }
    }

    Node root = new Node();
    int allCount;
    public int minimumLengthEncoding(String[] words) {
        for (String str : words) {
            add(str);
        }
        return length(root);
    }

    private int length(Node node){
        node.next.forEach(
                (k,v)->{
                    if (!v.isWord||v.next.size()!=0){
                        allCount = length(v);
                    }else {
                        allCount += v.count;
                    }
                }
        );
        return allCount;
    }


    private void add(String word){
        Node curNode = root;
        char[] chars = word.toCharArray();
        int count = curNode.count;
        for (int i = word.length()-1; i >= 0; i--) {
            char c = chars[i];
            if (curNode.next.get(c) == null) {
                curNode.next.put(c, new Node(++count,false));
            }
            curNode = curNode.next.get(c);
            count = curNode.count;
        }
        if (!curNode.isWord){
            curNode.isWord = true;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"time", "me", "bell"};
        Solution1 s = new Solution1();
        int i = s.minimumLengthEncoding(strings);
        System.out.println(i);
    }
}
