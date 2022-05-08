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
    private int maxPath = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        pathSumReq(root);
        return maxPath;
    }
    
    
    public int pathSumReq(TreeNode node){
        if (node == null){
            return 0;
        }
        
        int rightPath = pathSumReq(node.right);
        int leftPath = pathSumReq(node.left);
        
        int max = node.val;
        max = Math.max(max,rightPath + node.val);
        max = Math.max(max,leftPath + node.val);
        //max = Math.max(max,leftPath + node.val + rightPath);
        maxPath = Math.max(maxPath,max);
        maxPath = Math.max(maxPath,leftPath + node.val + rightPath);

        return max;
    }
}