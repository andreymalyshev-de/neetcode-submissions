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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int s = a + b + carry;
            
            if (s < 10) {
                res.next = new ListNode(s);
                carry = 0;
            }
            else {
                res.next = new ListNode(s - 10);
                carry = 1;
            }

            res = res.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            System.out.println(res.val);
        }

        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        System.out.println(res.val);

        return (dummy.next);
    }

    public ListNode reverseNode(ListNode head) {
        ListNode tmp = null;
        ListNode next = null;
        ListNode cur = head;

        while (cur != null) {
            next = cur.next;
            cur.next = tmp;
            tmp = cur;
            cur = next;
        }
        return tmp;
    }
}
