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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        Set<Integer> set = new HashSet<>();
        //System.out.println(list);
        for(int i : list){
            int comp =k -(i);
            if(set.contains(i))return true;
            set.add(comp);
        }
        return false;
        
        
    }
    
    public void helper(TreeNode root, List<Integer> list){
        if(root ==null){
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
}