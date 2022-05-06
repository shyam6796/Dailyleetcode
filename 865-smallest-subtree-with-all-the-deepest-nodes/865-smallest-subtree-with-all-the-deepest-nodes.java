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
    int maxDepth=-1;
    TreeNode result;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        postOrder(root,0);
        return result;
    }
    public int postOrder(TreeNode node ,int depth){
        if(node==null)return depth;
        
        int left = postOrder(node.left,depth+1);
        int right = postOrder(node.right,depth+1);
        
        if(left==right){
            maxDepth =Math.max(maxDepth,left);
            if(left ==maxDepth){
                result = node;
            }
        }
        
        return Math.max(left,right);
    }
}