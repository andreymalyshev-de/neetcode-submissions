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
    public boolean hasCycle(ListNode head) {
        int c = 0;
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = fast;

        while (fast != null) {
            if (slow.equals(fast)) return true;
            if (c % 2 == 0) slow = slow.next;
            fast = fast.next;
            c++;
        }
        
        return false;
    }
}
