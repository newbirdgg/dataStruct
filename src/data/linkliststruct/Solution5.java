package data.linkliststruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第21题——合并两个有序链表
 * @Date: 2020/5/1 7:58
 * @Email: 1031759184@qq.com
 */
public class Solution5 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null==l1&&null==l2)return l1;
        if (null==l1)return l2;
        if (null==l2)return l1;
        ListNode left = l1;
        ListNode right = l2;
        while (null!=right){
            if (left.val<right.val){
                if (left.next==null){
                    break;
                }
                left = left.next;
            }else {
                ListNode pre = new ListNode(left.val);
                pre.next = left.next;
                left.val = right.val;
                left.next = pre;
                right = right.next;
            }
        }
        if (right!=null){
            left.next = right;
        }
        return l1;
    }
}
