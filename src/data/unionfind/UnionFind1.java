package data.unionfind;
/**
 *  @Author: liyuzhan
 *  @classDesp： 并查集第一版
 *  @Date: 2020/3/9 8:42
 *  @Email: 1031759184@qq.com
 */
public class UnionFind1 implements UnionFindInterface {
    private int[] id;
    public UnionFind1(int size){
        id = new int[size];
        for (int i = 0;i<id.length;i++){
            id[i] = i;
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId){
            return;
        }
        for (int i = 0;i<id.length;i++){
            if (id[i] == pId){
                id[i] = qId;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合的编号
     * @param p 元素p
     * @return 对应的编号
     */
    private int find(int p){
        if (p<0&&p>=id.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }
}
