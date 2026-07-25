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
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> qn = new LinkedList<>();
        Queue<Node> qc = new LinkedList<>();
        Node fst = new Node(node.val);
        qn.add(node);
        Node[] visited = new Node[101];
        visited[1] = fst;

        while(!qn.isEmpty()) {

            Node curn = qn.poll();
            Node curc = visited[curn.val];

            for (Node n: curn.neighbors) {
                if (n == null ) continue;
                if (visited[n.val] != null) {
                    curc.neighbors.add(visited[n.val]);
                    continue;
                }
                qn.offer(n);
                Node copy = new Node(n.val);
                curc.neighbors.add(copy);
                //copy.neighbors.add(curc);
                visited[n.val] = copy;
            }
        }

        return fst;
    }

}