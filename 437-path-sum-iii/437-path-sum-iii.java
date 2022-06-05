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
    int count=0;
    Map<Integer,Integer> map =new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
      prepOrder(root,0,targetSum);
      return count;
    }
    
    public void prepOrder(TreeNode root, int sum, int targetSum){
        if(root==null) return;
        
        sum +=root.val;
        if(sum==targetSum){
            count++;
        }
        count +=map.getOrDefault(sum-targetSum,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        prepOrder(root.left,sum,targetSum);
        prepOrder(root.right,sum,targetSum);
        
        map.put(sum,map.get(sum)-1);
        
    }
}