package data.linkliststruct;

import java.util.List;

public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int dep = 1, index = 1;
    private ListNode flipHead;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        if (null == head || null == head.next) return head;
        flipHead = head;
        while (index < m) {
            flipHead = flipHead.next;
            index++;
        }

        return recursive(head, m, n);
    }

    private ListNode recursive(ListNode node, int m, int n) {
        if (++dep <= n) {
            recursive(node.next, m, n);

        }
        if (index < dep) {
            swap(flipHead, node);
            flipHead = flipHead.next;
            index++;
            dep--;
        }
        return node;
    }

    private void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        Solution2 s = new Solution2();
        s.reverseBetween(head, 3, 4);
    }
}
