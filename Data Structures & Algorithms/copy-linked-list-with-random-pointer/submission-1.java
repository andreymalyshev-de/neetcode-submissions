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

        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head.next;
        Node tmp1 = new Node(head.val);
        map.put(head, tmp1);
        Node tmp2 = null;

        while (cur != null) {
           tmp2 = new Node(cur.val);
           tmp1.next = tmp2;
           map.put(cur, tmp2);
           cur = cur.next;
           tmp1 = tmp2;
        }

        cur = head;
        while (cur != null) {
            tmp1 = cur.random;
            map.get(cur).random = tmp1 == null ? null : map.get(tmp1);
            cur = cur.next;
        }

        return map.get(head);
    }
}
