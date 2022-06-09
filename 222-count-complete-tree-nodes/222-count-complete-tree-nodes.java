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
    
        int height, absentNode;
    public int findHeight(TreeNode root, int h){
        if(root.left == null)
            return h+1;
        return findHeight(root.left, h+1);
    }
    
    private boolean findNodes(TreeNode root, int currHeight){
        if(currHeight != height-1){
            if(!(findNodes(root.right, currHeight+1)))
                return findNodes(root.left, currHeight+1);
            return true;
        }
        if(root.right != null)
            return true;
        else if(root.left != null){
            absentNode++;
            return true;
        }else{
            absentNode += 2;
            return false;
        }
    }
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        height = findHeight(root, 0);
        if(height == 1)
            return 1;
        
        int nodeMustBeAvailable = (int)(Math.pow(2, height)) - 1;
        absentNode = 0; 
        findNodes(root, 1);
        return (nodeMustBeAvailable - absentNode);
    }
}