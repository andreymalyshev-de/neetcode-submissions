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
        ListNode h = new ListNode(0);
        h.next = res;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
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
            l1 = l1.next;
            l2 = l2.next;
            System.out.println(res.val);
        }
        //System.out.println(l1.val + " " + carry);

        while (l1 != null) {
            if (carry > 0) {
                int s = l1.val + carry;
                if (s < 10) {
                    res.next = new ListNode(s);
                    carry = 0;
                }
                else {
                    res.next = new ListNode(s - 10);
                    carry = 1;
                }
                l1 = l1.next;
                res = res.next;
            }
            else if (l1.val > 0) {
                res.next = new ListNode(l1.val + carry);
                l1 = l1.next;
                res = res.next;
            }
        }

        while (l2 != null) {
            if (carry > 0) {
                int s = l2.val + carry;
                if (s < 10) {
                    res.next = new ListNode(s);
                    carry = 0;
                }
                else {
                    res.next = new ListNode(s - 10);
                    carry = 1;
                }
                l2 = l2.next;
                res = res.next;
            }
            else if (l2.val > 0) {
                res.next = new ListNode(l2.val + carry);
                l2 = l2.next;
                res = res.next;
            }
        }

        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        System.out.println(res.val);

/*         if (l2 != null) {
            if (carry > 0) {
                res.next = new ListNode(l2.val + carry);
                carry = 0;
            }
            else res.next = new ListNode(l2.val + carry);
            l2 = l2.next;
            res = res.next;
        }
        System.out.println(res.val); */

        return (h.next.next);
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
