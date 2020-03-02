package data.map;

import java.util.*;

/**
 * @Author: liyuzhan
 * @classDesp： 简单实现哈希表
 * @Date: 2020/3/2 13:51
 * @Email: 1031759184@qq.com
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> iPair = iterator.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                //Replace old with new
                iterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K,V>>bucket:buckets) {
            if (bucket==null){
                continue;
            }
            set.addAll(bucket);
        }
        return set;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleHashMap<Integer,Integer> m = new SimpleHashMap<>();
        for (int i = 0; i<10;i++){
            m.put(i,i);
        }
        System.out.println(m);

    }

}
