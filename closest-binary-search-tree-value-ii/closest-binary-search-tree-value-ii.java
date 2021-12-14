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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
       List<Integer> list = new ArrayList<>();
        helper(root,list);
      Collections.sort(list,(a,b)->{
            if(Math.abs(target-a) <Math.abs(target-b)) return -1;
            else return 1;
        });
       return list.subList(0,k);
    }
    
    public void helper(TreeNode root, List<Integer> list){
        if(root == null)return;
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
}