package data.linkliststruct;


/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第445题——两数相加②
 * @Date: 2020/4/14 7:17
 * @Email: 1031759184@qq.com
 */
public class Solution3 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int carry;
    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();
    private ListNode resultNode = new ListNode(-1);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null) {
            stack1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addLast(l2.val);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            int res1 = stack1.isEmpty()?0:stack1.removeLast();
            int res2 = stack2.isEmpty()?0:stack2.removeLast();
            int resultNum = res1+res2+carry;
            ListNode curNode = new ListNode(resultNum % 10);
            carry = resultNum >= 10 ? 1 : 0;
            curNode.next = resultNode.next;
            resultNode.next = curNode;
        }
        if (carry==1){
            ListNode curNode = new ListNode(1);
            curNode.next = resultNode.next;
            resultNode.next = curNode;
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        m1.next = m2;
        m2.next = m3;
        Solution3 s = new Solution3();
        s.addTwoNumbers(l1,m1);
    }
}