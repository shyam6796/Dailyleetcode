/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root ==null || (root.left ==null && root.right==null)){
            return ;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        helper(queue,root);
        root= queue.poll();
        while(!queue.isEmpty()){
            root.left=null;
            root.right=queue.poll();
            root=root.right;
        }
    }
    public void helper( Queue<TreeNode> queue, TreeNode root){
        if(root==null){
            return;
        }
        queue.add(root);
        if(root.left != null)helper(queue,root.left);
        if(root.right != null)helper (queue, root.right);
    }
    
}