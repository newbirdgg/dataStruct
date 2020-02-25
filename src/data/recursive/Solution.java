package data.recursive;

/**
 * @Author: liyuzhan
 * @classDesp： 用递归方法解决LeetCode203题
 * @Date: 2020/2/25 21:05
 * @Email: 1031759184@qq.com
 */
public class Solution extends data.linkliststruct.Solution {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode = removeElements(head, 6);
        System.out.println(listNode);
    }
}
