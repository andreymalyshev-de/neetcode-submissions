/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode cur = head;
         ListNode prev = null;

         int c = 0;
         ListNode[] pn = new ListNode[]{null, null};
         while (cur != null) {
            if (c % k == 0) {
                pn = reverseNode(cur, prev, k);
                cur = pn[0];
            }

            System.out.println("cur: " + cur.val);

            prev = cur;
            if (c == 0) head = cur;
            if (c % k == k - 1) {
                cur.next = pn[1];
            }
            cur = cur.next;
            c++;
         }
         return head;
    }

    public ListNode[] reverseNode(ListNode head, ListNode tprev, int k) {
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;
        int c = 0;
        while (c < k) {
            //System.out.println("cur: " + cur.val);
            c++;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            if (c < k && cur == null) {
                ListNode[] pn = reverseNode(prev, tprev, c);
                prev = pn[0];
                next = pn[1];
                break;
            }
        }

        if (tprev != null) tprev.next = prev;
        return new ListNode[]{prev, next};
    }
}
