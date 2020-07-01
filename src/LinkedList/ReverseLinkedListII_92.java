package LinkedList;

/**
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        for (int i = 0; i < m - n ; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            /**
             * 1-2-3-4
             * pre = 1, cur = 2, temp = 3;
             * temp = cur.next -> 3;
             * 下一步要把现在 cur.next填上
             * cur.next = temp.next; 因为要往后移动所以填temp.next; cur.next -> 4
             * 继续填temp
             * temp.next = pre.next; 把temp.next直接转换成pre.next; temp.next -> 2
             * 1->  cur =  2-4-5 temp = 3 - 2
             * pre.next = temp;
             *
             * 1-3-2-4-5
             * pre = 1, cur = 2, temp = 3，不变但是顺序变了
             * temp = cur.next -> 4
             * cur.next = temp.next -> 2-5;
             * temp.next = pre.next-> 4-3-2-5;
             * pre.next = temp; 1-4-3-2-5;
             */
        }

        return dummy.next;
    }
}
