package LinkedList;
/**
 *25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 *
 * 思路：分步解决问题吧，实现人脑解题步骤，本身不难，但是要对
 * linkedlist revers的细节精通。
 */

import java.util.List;

public class ReverseNodesInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode newHead = null;
        ListNode ktail = null;

        while (k > 0) {
            int count = 0;
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverseList(head, k);

                if (newHead == null) {
                    newHead = revHead;
                }

                if (ktail != null) {
                    ktail = revHead;
                }

                ktail = head;
                head = ptr;
            }
        }

        if (ktail != null) {
            ktail.next = head;
        }

        return newHead == null ? head : newHead;
    }

    public ListNode reverseList(ListNode head, int k) {
        ListNode cur = head;
        ListNode newHead = null;

        while (k > 0) {
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
            k--;
        }

        return newHead;
    }
}
