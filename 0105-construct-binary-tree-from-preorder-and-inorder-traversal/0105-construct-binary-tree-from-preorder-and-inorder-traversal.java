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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,0,inorder.length);
    }
    public TreeNode helper(int preorder[], int inorder[], int index, int left, int right){
        if(index ==preorder.length || left >right)return null;

        TreeNode root =new TreeNode(preorder[index]);
        int pos =-1;
        for(int i =left; i <=right; i++){
            if(root.val==inorder[i]){
                pos =i;
                break;
            }
        }
        
        root.left = helper(preorder, inorder, index+1, left, pos-1);
        root.right =helper(preorder, inorder, index+pos-left+1, pos+1, right);
        return root;
    }
}