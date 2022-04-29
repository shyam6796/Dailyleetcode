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
    Node first;
    Node last;
    public Node treeToDoublyList(Node root) {
        if(root==null)return root;
        helper(root);
        first.left=last;
        last.right=first;
        return first;
    }
    
    public void helper(Node root){
        if(root.left !=null) helper(root.left);
        
        if(last ==null){
            first= root;
        }else{
            root.left=last;
            last.right= root;
        }
        last =root;
         if(root.right !=null) helper(root.right);
    }
}