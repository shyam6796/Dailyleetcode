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
        Node head;
        Node last;
    public Node treeToDoublyList(Node root) {
        if(root==null)return null;
        helper(root);
        last.right=head;
        last.right.left =last;
        return head;
    }
    
    public void helper(Node root){
        if(root==null){
            return;
        }
        helper(root.left);
        
        if(last ==null){
            head=root;
            last =root;
        }else{
            last.right=root;
            root.left=last;
        }
        last= root;
        helper(root.right);
    }
}