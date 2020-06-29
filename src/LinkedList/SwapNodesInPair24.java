package LinkedList;

import java.util.List;

public class SwapNodesInPair24 {
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
