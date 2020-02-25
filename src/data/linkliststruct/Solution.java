package data.linkliststruct;


/**
 * @Author: liyuzhan
 * @classDesp： LeetCode203题 删除链表元素
 * <p>
 * 给定一个值，删除链表中此值的所有元素
 * @Date: 2020/2/25 19:20
 * @Email: 1031759184@qq.com
 */
public class Solution {
    /**
     * 链表节点
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }

        /**
         * 使用array作为参数，创建一个链表，当前的ListNode为链表头结点
         *
         * @param arr 数组
         */
        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("Array can not be empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val).append("->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    /**
     * 删除元素操作
     *
     * @param head 头结点
     * @param val  被删除的元素
     * @return 被删除的元素
     */
    public static ListNode removeElements(ListNode head, int val) {
        //虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode = removeElements(head, 6);
        System.out.println(listNode);
    }
}
