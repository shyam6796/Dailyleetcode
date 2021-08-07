/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null)return null;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        helper(pq,root);
        Node ans=new Node(-1);
        Node head =ans;
        while(!pq.isEmpty()){
            Node temp =new Node(pq.poll().val);
            temp.left=ans;
            ans.right=temp;
            ans= ans.right;
        }
        ans.right=head.right;
        head=head.right;
        head.left=ans;
        return head;
        
    }
    public void helper(PriorityQueue<Node> pq, Node root){
        if(root==null){
            return;
        }
        pq.add(root);
        helper(pq,root.left);
        helper(pq,root.right);
    }
}