/*
// Definition for a Node.
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
    HashMap<Node,Node> h=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)return node;
        if(h.containsKey(node))return h.get(node);

        Node cloneNode=new Node(node.val);
        h.put(node,cloneNode);

        for(Node n:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(n));
        }return cloneNode;
    }
}