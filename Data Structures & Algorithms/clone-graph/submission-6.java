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
        if(node == null) return null;

        Map<Node, Node> cm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        cm.put(node, clone);
        q.add(node);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node n : curr.neighbors) {
                if(!cm.containsKey(n)) {
                    cm.put(n, new Node(n.val));
                    q.add(n);
                }
                cm.get(curr).neighbors.add(cm.get(n));
            }
        }

        return clone;
    }
}