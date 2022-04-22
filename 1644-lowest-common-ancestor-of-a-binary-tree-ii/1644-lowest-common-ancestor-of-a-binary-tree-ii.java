/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
       Set<Integer> found = new HashSet();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node =DFS(root, p, q);
        return found.size() == 2 ? node : null;
        
    }
    public TreeNode DFS(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
         TreeNode left = DFS(root.left, p, q);
        TreeNode right = DFS(root.right, p, q);
        
        if (root == p || root == q) {
            found.add(root.val);
            return root;
        }
        
       
        
        if (left != null && right != null) {
            return root;
        }
        
        
        return left != null ? left : right;
    }
}