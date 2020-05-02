package data.linkliststruct;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第23题——合并k个排序链表
 * @Date: 2020/4/26 8:25
 * @Email: 1031759184@qq.com
 */
public class Solution4 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) return null;
        return process(0, lists.length - 1, lists);
    }

    private ListNode process(int l, int r, ListNode[] arr) {
        if (l == r) return arr[l];
        int mid = l + ((r - l) >> 1);
        return merge(process(l, mid, arr), process(mid + 1, r, arr));
    }

    public ListNode merge(ListNode leftNode, ListNode rightNode) {
        if (leftNode!=null&&rightNode!=null){
            ListNode indexA = leftNode;
            ListNode indexB = rightNode;
            while ( indexB != null) {
                if (indexA.val < indexB.val) {
                    if (indexA.next==null){
                        break;
                    }
                    indexA = indexA.next;
                } else {
                    ListNode pre = new ListNode(indexA.val);
                    pre.next = indexA.next;
                    indexA.val = indexB.val;
                    indexA.next = pre;
                    indexB = indexB.next;
                }
            }
            if (indexB != null) {
                indexA.next = indexB;
            }
            return leftNode;
        }
        if (leftNode==null){
            return rightNode;
        }
        return leftNode;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next= b3;
        c1.next = c2;
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = a1;
        listNodes[1] = b1;
        listNodes[2] = c1;
        Solution4 s = new Solution4();
        s.mergeKLists(listNodes);

    }
}
