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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode list = null;
        list = help(list, list1, list2);
        return list;
    }

    public ListNode help(ListNode list, ListNode list1, ListNode list2) {
                
        if (list1 != null) {
            if (list2 != null) {
                if (list1.val < list2.val) {
                    list = list1;
                    list.next = help(list.next, list1.next, list2);
                    return list;
                }
                else {
                    list = list2;
                    list.next = help(list.next, list1, list2.next);
                    return list;
                }
            }
            else {
                list = list1;
                return list;
            }
        }
        else {
            if (list2 != null) list = list2;
            return list;
        }
    }
}