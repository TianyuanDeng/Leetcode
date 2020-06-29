package LinkedList;

/**
 *Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * 分段思维，分成两部分分别sort,最后再合并在一起注意dummy情况；
 */

public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy_before = new ListNode(0);
        ListNode before = dummy_before;
        ListNode dummy_after = new ListNode(0);
        ListNode after = dummy_after;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = dummy_after.next;

        return dummy_before.next;
    }
}
