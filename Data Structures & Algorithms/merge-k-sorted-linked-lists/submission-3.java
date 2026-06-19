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

        PriorityQueue<ListNode> line = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null) line.add(lists[i]);
        }

        while(!line.isEmpty()) {
            ListNode cur = line.poll();
            System.out.println(line.size());
            list.next = cur;
            list = list.next;
            System.out.println(list.val);
            cur = cur.next;
            if (cur != null) line.add(cur);
            System.out.println(line.size());
        }

        return fst.next;
    }
}
