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
        HashMap<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node n : curr.neighbors) {
                if(!cloneMap.containsKey(n)) {
                    cloneMap.put(n, new Node(n.val));
                    q.add(n);
                }
            cloneMap.get(curr).neighbors.add(cloneMap.get(n));
            }
        }
        return cloneMap.get(node);
    }
}