package data.arraystruct;



/**
 * @Author: liyuzhan
 * @classDesp： 简单封装的数组工具类
 * @Date: 2020/2/12 17:13
 * @Email: 1031759184@qq.com
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造函数,默认容量为10
     */
    public Array() {
        this(10);
    }
    @SuppressWarnings("unchecked")
    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0;i<arr.length;i++){
            data[i] = arr[i];
        }
        size = arr.length;
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
    public void addLast(E param) {
        insert(this.size, param);
    }

    /**
     * 向所有元素头部添加一个新元素
     *
     * @param param 被添加进数组的元素
     */
    public void addFirst(E param) {
        insert(0, param);
    }

    /**
     * 在第index个位置插入一个新元素param
     *
     * @param index 插入的位置
     * @param param 插入的元素
     */
    public void insert(int index, E param) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("AddLast failed. Out of the Array Index");
        }
        if (isArrayFull()) {
            //动态扩容
            resize(2 * this.data.length);
        }
        for (int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = param;
        size++;
    }

    /**
     * @param index 索引位置
     * @return 获取索引位置的元素
     */
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return this.data[index];
    }

    /**
     * 获取最后一个元素
     *
     * @return 被获取的元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     *
     * @return 被获取的元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素param
     *
     * @param index 索引
     * @param param 被修改的元素
     */
    public void set(int index, E param) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        this.data[index] = param;
    }

    /**
     * @param param 匹配元素
     * @return 查找数组中是否包含param
     */
    public boolean contains(E param) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(param)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param param 被查找的元素
     * @return 查找元素中param所在的索引，如果不存在元素param，则返回-1
     */
    public int find(E param) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(param)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index 索引
     * @return 从数组中删除index位置的元素，返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        E ret = this.data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //方便垃圾回收、防止出现loitering object
        data[size] = null;
        //为什么数组实际容量等于数组容量的1/4时才减半？原因请看复杂度震荡文件
        if (this.size == this.data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中最后一个元素
     *
     * @return 被删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中第一个元素
     *
     * @return 被删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除元素param
     *
     * @param param 被删除的元素
     */
    public void removeElement(E param) {
        for (int i = 0; i < this.size; i++) {
            int index = find(param);
            if (index != -1) {
                remove(index);
            }
        }
    }

    /**
     * 交换两个元素的位置
     *
     * @param i 第一个元素
     * @param j 第二个元素
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
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

    /**
     * 动态扩容
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }
}
