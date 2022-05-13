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
    class BSTpar{
        int min;
        int max;
        boolean isBST;
        int maxBST;
        
        public BSTpar(int min, int max, boolean isBST,int maxBST){
            this.min=min;
            this.max=max;
            this.isBST=isBST;
            this.maxBST=maxBST;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root ==null){
                return 0;
            }
        
        
        return helper(root).maxBST;
    }
    
    public BSTpar helper(TreeNode root){
        if(root.left==null && root.right ==null){
            new BSTpar(root.val,root.val,true,1);
        }
        
        int min =root.val;
        int max =root.val;
        Boolean isBST= true;
        int maxBST=0;
        if(root.left !=null){
            BSTpar left =helper(root.left);
             min =Math.min(min,left.min);
            if(left.max >= root.val){
                isBST=false;
            }
            if(!left.isBST){
                isBST=false;
            }
            maxBST +=left.maxBST;
        }
        if(root.right !=null){
            BSTpar right =helper(root.right);
             max =Math.max(max,right.max);
            if(right.min <= root.val){
                isBST=false;
            }
            if(!right.isBST){
                isBST=false;
            }
            if(isBST){
                maxBST +=right.maxBST;
            }else{
                maxBST =Math.max(right.maxBST, maxBST);
        }
    }
        if(isBST)maxBST++;
        return new BSTpar(min,max,isBST,maxBST);
    }
}