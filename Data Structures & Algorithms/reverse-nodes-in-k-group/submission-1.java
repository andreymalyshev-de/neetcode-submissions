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
        ListNode dummy = new ListNode(0, cur);
        ListNode prev = dummy;

        while (true) {
            ListNode kth = getKth(cur, k);
            if (kth == null) {
                break;
            }

            ListNode pr = kth.next;
            ListNode glnext = kth.next;
            ListNode next = null;

            while (cur != glnext) {
                System.out.println(cur.val);
                next = cur.next;
                cur.next = pr;
                pr = cur;
                cur = next;
            }

            ListNode tmp = prev.next;
            prev.next = kth;
            prev = tmp;
        }
        
        return dummy.next;
    }

    public ListNode getKth(ListNode cur, int k) {
        while (cur != null && k > 1) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
