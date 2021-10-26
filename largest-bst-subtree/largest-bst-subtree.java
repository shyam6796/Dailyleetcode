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
    
    public  class BSTpar {
        int min;
        int max;
        boolean isBST;
        int maxBST;
        
        public BSTpar(int min, int max, boolean isBST, int maxBST){
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
        
        return helperBST(root).maxBST;
    }
    
    public BSTpar helperBST(TreeNode root){
        if(root.left ==null && root.right ==null){
            return new BSTpar(root.val,root.val,true,1);
        }
        int min =root.val;
        int max =root.val;
        boolean isBST=true;
        int maxBST=0;
        
        if(root.left !=null){
            BSTpar left =helperBST(root.left);
            min =Math.min(min,left.min);
            if(!left.isBST){
                isBST =false;
            }
            if(left.max >= root.val){
                isBST =false;
            }
            maxBST =left.maxBST;
        }
        
        if(root.right !=null){
            BSTpar right =helperBST(root.right);
            max =Math.max(max,right.max);
            if(right.min <= root.val){
                isBST =false;
            }
           if(!right.isBST){
                isBST =false;
            }
            
            if(isBST){
                maxBST +=right.maxBST;
            }else{
                maxBST =Math.max(right.maxBST,maxBST);
            }
        }
        
        if(isBST){
            maxBST++;
        }
        return new BSTpar(min,max,isBST,maxBST);
    }
}