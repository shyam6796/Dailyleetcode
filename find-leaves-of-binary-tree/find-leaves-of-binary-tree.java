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
    public List<List<Integer>> findLeaves(TreeNode root) {
           List<List<Integer>> ans =new ArrayList<>();
        helper(root, ans);
         return ans;  
    }
    public int helper(TreeNode root,List<List<Integer>> ans){
        if(root == null){
            return -1;
        }
        int left = helper(root.left,ans);
        int right =helper(root.right,ans);
        int height = Math.max(left,right)+1;
        
        if(ans.size()==height){
            ans.add(new ArrayList<>());
        }
        ans.get(height).add(root.val);
        
        return height;
    }
}