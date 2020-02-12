package data.arraystruct;

/**
 * @Author: liyuzhan
 * @classDesp： 简单封装的数组工具类
 * @Date: 2020/2/12 17:13
 * @Email: 1031759184@qq.com
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * 无参构造函数,默认容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * @return 数组中元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @return 获取数组容量
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * @return 返回数组是否为空
     */
    public boolean isArrayEmpty() {
        return this.size == 0;
    }

    /**
     * @return 返回数组是否已满
     */
    public boolean isArrayFull() {
        return this.size == this.data.length;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param param 被添加进数组的元素
     */
    public void addLast(int param) {
        insert(this.size, param);
    }

    /**
     * 向所有元素头部添加一个新元素
     *
     * @param param 被添加进数组的元素
     */
    public void addFirst(int param) {
        insert(0, param);
    }

    /**
     * 在第index个位置插入一个新元素param
     *
     * @param index 插入的位置
     * @param param 插入的元素
     */
    public void insert(int index, int param) {
        if (isArrayFull()) {
            throw new IllegalArgumentException("Add failed. Array is full");
        }
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("AddLast failed. Out of the Array Index");
        }
        for (int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = param;
        size++;
    }

    /**
     * @param index 索引位置
     * @return 获取索引位置的元素
     */
    int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return this.data[index];
    }

    /**
     * 修改index索引位置的元素param
     * @param index 索引
     * @param param 被修改的元素
     */
    void set(int index, int param) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        this.data[index] = param;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n", this.size, this.data.length));
        res.append("[");
        for (int i = 0; i < this.size; i++) {
            res.append(this.data[i]);
            if (i != this.size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
