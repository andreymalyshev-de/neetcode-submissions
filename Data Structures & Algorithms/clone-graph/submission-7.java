/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> created = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node fst = new Node(node.val);
        created.put(node, fst);

        for (Node nb: node.neighbors) {
            if (created.containsKey(nb)) {
                fst.neighbors.add(created.get(nb));
                continue;
            }
            Node cur = cloneGraph(nb);
            fst.neighbors.add(cur);
        }

        return fst;
    }
}