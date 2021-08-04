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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
         List<TreeNode> list =new ArrayList<>();
        for(int i : to_delete){
            set.add(i);
        }
          helper(root,set,list);
       
        if(!set.contains(root.val)){
            list.add(root);
        }
        
      
        return list;
    }
    public TreeNode helper(TreeNode root, HashSet<Integer> set, List<TreeNode> list){
        if(root == null){
            return null;
        }
        if(root.left != null) root.left= helper(root.left,set,list);
        if(root.right != null)  root.right= helper(root.right,set,list);
        
        if(set.contains(root.val)){
            if(root.left != null) list.add(root.left);
            if(root.right != null)list.add(root.right);
            
            return null;
        }
        return root;
        
    }
}