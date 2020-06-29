package LinkedList;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 1;
        ListNode dummy = head;
        ListNode cur = head;

        while (dummy.next != null) {
            dummy = dummy.next;
            len++;
        }
        dummy.next = head;

        for (int i = 0; i < len - k % len - 1; i++) {
            cur = cur.next;
        }

        head = cur.next;
        cur.next = null;
        return head;
    }
}
