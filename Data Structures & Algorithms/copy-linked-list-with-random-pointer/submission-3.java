/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node tmp = null;
        Node cur = head;
        while (cur != null) {
            tmp = cur.next;
            Node n = new Node(cur.val);
            cur.next = n;
            n.next = tmp;
            cur = n.next;
        }

        cur = head;
        Node res = head.next;

        while (cur != null) { // random assignment
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            else cur.next.random = null;
            cur = cur.next.next;
        }

        tmp = null;
        cur = head;

        while (cur != null) { // reassignment of nexts
            tmp = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            if (cur != null) tmp.next = cur.next;
        }

        return res;
    }
}
