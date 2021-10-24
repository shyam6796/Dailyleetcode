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
    int max=Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        helper(root,0,0);
        return max;
    }
    public void helper(TreeNode root, int count, int target){
        if(root==null){
            return ;
        }else if(root.val == target){
            count++;
        }else{
            count=1;
        }
        max =Math.max(max,count);
       helper(root.left,count,root.val+1);
        helper(root.right,count,root.val+1);
    }
}