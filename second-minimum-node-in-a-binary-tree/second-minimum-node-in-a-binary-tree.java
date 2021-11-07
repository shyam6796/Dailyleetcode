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
    int min1 =Integer.MAX_VALUE;
    int min2 =Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
         Set<Integer> set = new TreeSet<>();
         helper(root, set);
        
        if(set.size()<2)return -1;
        
        for(int i :set){
            set.remove(i);
            break;
        }
        
         for(int i :set){
            return i;
            
        }
        return -1;
    
    }
    
    public void helper(TreeNode root,  Set<Integer> set){
        if(root ==null)return;
        set.add(root.val);
        helper(root.left,set);
        helper(root.right,set);
    }
}