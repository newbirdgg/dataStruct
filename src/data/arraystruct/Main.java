package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： 测试类
 * @Date: 2020/2/12 18:18
 * @Email: 1031759184@qq.com
 */
public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0,size=10; i < size; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        //往索引为1的位置添加元素100
        arr.insert(1,100);
        System.out.println(arr);
        //往数组头部插入-1
        arr.addFirst(-1);
        System.out.println(arr);
    }
}
