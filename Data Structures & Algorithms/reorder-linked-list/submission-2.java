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
    public void reorderList(ListNode head) {
        // to split the array into two halves efficiently?
        int cnt = 0;
        ListNode res = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            cnt++;
        }

        if (cnt < 2) return;

        int ct = 1;
        cur = head;
        res.next = cur;

        //System.out.println(cur.val);
        while (ct < (cnt + 1) / 2) {
            cur = cur.next;
            ct++;
        }
        //System.out.println(cur.val);
        
        ListNode rev = reverseList(cur);
        cur.next = null;
        cur = res.next;
        res.next = cur;

        while (cur != null && rev != null) {
            System.out.println(cur.val);
            ListNode tmp = cur.next;
            cur.next = rev;
            rev = rev.next;
            cur = cur.next;
            System.out.println(cur.val);
            cur.next = tmp;
            cur = cur.next;
        }

        head = res.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
