package data.trie;
/**
 *  @Author: liyuzhan
 *  @classDesp： Trie测试类
 *  @Date: 2020/3/8 9:11
 *  @Email: 1031759184@qq.com
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("liyuzhan");
        trie.add("liyu");
        boolean isContains = trie.contains("liyuzhan");
        System.out.println(isContains);
    }

}
