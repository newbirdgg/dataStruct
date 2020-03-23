package data.linkliststruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第876题——链表中间节点
 * @Date: 2020/3/23 7:06
 * @Email: 1031759184@qq.com
 */
public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int count, back;
    private boolean isfind;

    public ListNode middleNode(ListNode head) {
        return findMid(head);
    }

    private ListNode findMid(ListNode node) {
        if (node.next == null) {
            count++;
            return node;
        }
        count++;
        ListNode retNode = findMid(node.next);
        if (!isfind) {
            back++;
            if (count % 2 == 0 && (back << 1) == count||(count % 2 == 1 && (back << 1) - 1 == count)){
                isfind = true;
                return node.next;
            }
            return node;
        }
        return retNode;
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.middleNode1(head).val);


    }
}
