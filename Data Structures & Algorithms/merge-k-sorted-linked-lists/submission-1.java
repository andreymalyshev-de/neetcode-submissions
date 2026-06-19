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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode list = new ListNode(0);
        ListNode fst = list;

        while (true) {
            int[] min = new int[]{-1, 1001};
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min[1]) {
                    min = new int[]{i, lists[i].val};
                }
            }
            if (min[1] == 1001) break;
            list.next = lists[min[0]];
            lists[min[0]] = lists[min[0]].next;

            System.out.println(list.val + " index: " + min[0] + " " );
            list = list.next;
        }

        return fst.next;
    }
}
