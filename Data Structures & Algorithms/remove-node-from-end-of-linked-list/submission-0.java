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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        head = slow;

        while (c < n) {
            fast = fast.next;
            c++;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //System.out.println(slow + " " + slow.next + " " + slow.next.next);
        //System.out.println(head + " " + head.next);
        slow.next = slow.next.next;
        //System.out.println(slow + " " + slow.next);
        return head.next;
    }
}
