package LinkedList;

import java.util.List;

/**
 *Given a linked list, swap every two adjacent nodes and return its head.
 *You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Linkedlist 基础互换next操作；
 */

public class SwapNodesInPair_24 {
     public ListNode swapPairs(ListNode head) throws Exception {
        if (head == null || head.next == null) {
            throw new Exception("Input can be empty!");
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy.next;

        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;

            l1 = l2;
            l2 = l2.next;
        }

        return dummy.next;
     }

}
