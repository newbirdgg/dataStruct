package data.recursive;

/**
 * @Author: liyuzhan
 * @classDesp： 数组递归求和
 * @Date: 2020/2/25 20:12
 * @Email: 1031759184@qq.com
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr,0);
    }

    /**
     * 计算arr[l...n]这个区间内所有数字的和
     * @param arr 数组
     * @param l 最左边的索引
     * @return 总和
     */
    private static int sum(int[] arr,int l){
        if (l == arr.length){
            return 0;
        }else{
            return arr[l]+sum(arr,l+1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
