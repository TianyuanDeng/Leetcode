package LinkedList;

import java.util.List;

public class SortList_148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        ListNode ptr = null;

        while (fast != null && fast.next != null) {
            ptr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ptr.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return dummy.next;
    }
}
