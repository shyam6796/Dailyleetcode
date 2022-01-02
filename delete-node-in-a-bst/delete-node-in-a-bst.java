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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        
       if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
         root.right=deleteNode(root.right,key);
        }else{
            if(root.left !=null && root.right !=null){
                 int leftMax = maxHelper(root.left);
                 root.val =leftMax;
                root.left=deleteNode(root.left,leftMax);
            }else if(root.left !=null){
                return root.left;
                
            }else if(root.right !=null){
                return root.right;
            }else{
                return null;
            }
        }
        return root;
    
    }
        
    public int maxHelper(TreeNode root){
         if(root.right !=null){
             return maxHelper(root.right);
         }else{
             return root.val;
         }
    }
}