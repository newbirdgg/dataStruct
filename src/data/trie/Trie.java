package data.trie;

import java.util.TreeMap;

/**
 * @Author: liyuzhan
 * @classDesp： 字典树实现类
 * @Date: 2020/3/7 11:07
 * @Email: 1031759184@qq.com
 */
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     *
     * @return 单词数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     *
     * @param word 单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie
     * @param word 要查询的单词
     * @return 是否在Trie
     */
    public boolean contains(String word){
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在trie中有单词以prefix为前缀
     * @param prefix 前缀
     * @return 是否有此前缀
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
