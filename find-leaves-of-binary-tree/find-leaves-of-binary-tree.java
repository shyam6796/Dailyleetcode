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
    
     List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
            helper(root);
            return solution ;
    }
    
    public int helper(TreeNode root){
            if(root==null )return -1;
        
        int left= helper(root.left);
        int right =helper(root.right);
        int currHeight = Math.max(left, right) + 1;
        
         if (solution.size() == currHeight) {
                solution.add(new ArrayList<>());
        }
        
        solution.get(currHeight).add(root.val);
        
        return currHeight;
            
        
    } 
}