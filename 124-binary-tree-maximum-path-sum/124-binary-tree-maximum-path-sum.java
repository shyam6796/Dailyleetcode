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
    int maxPath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left =helper(root.left);
        int right =helper(root.right);
        int max =root.val;
        
        max =Math.max(left+root.val,max);
        max =Math.max(root.val+right,max);
        maxPath =Math.max(max,maxPath);
        maxPath =Math.max(maxPath,root.val+left+right);
            
        return max;
    }
}