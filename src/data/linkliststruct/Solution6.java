package data.linkliststruct;
/**
 *  @Author: liyuzhan
 *  @classDesp： LeetCode第25题——k个一组翻转链表
 *  @Date: 2020/5/16 9:03
 *  @Email: 1031759184@qq.com
 */
public class Solution6 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)return head;
        ListNode pre = null;
        ListNode first = head;
        ListNode last = next(first, k - 1);
        head = null;
        while (last != null) {
            reverse(pre, first, last);
            if (head == null) {
                head = last;
            }
            pre = first;
            first = pre.next;
            last = next(first, k - 1);
        }
        return head == null ? first : head;
    }
    public ListNode next(ListNode node, int k) {
        if (node == null)return null;
        while (k > 0) {
            node = node.next;
            if (node == null) return null;
            k--;
        }
        return node;
    }
    private void reverse(ListNode pre, ListNode first, ListNode last) {
        if (pre != null) {
            pre.next = last;
        }
        ListNode cur = first;
        ListNode curNext = first.next;
        ListNode curNextNext = curNext.next;
        first.next = last.next;
        while (true) {
            curNext.next = cur;
            cur = curNext;
            if (cur == last)break;
            curNext = curNextNext;
            curNextNext = curNext.next;

        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);
        Solution6 s = new Solution6();
        s.reverseKGroup(a, 2);

    }
}
