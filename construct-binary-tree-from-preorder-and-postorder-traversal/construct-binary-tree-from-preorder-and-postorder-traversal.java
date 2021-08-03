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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
               return construct(pre,0,pre.length-1,post,0,post.length-1);
    }
    public TreeNode construct(int[] pre,int preSI,int preEI,int[] post,int postSI,int postEI){
        if(preSI>preEI){
            return null;
        }
        TreeNode root=new TreeNode(pre[preSI]);
        int postIdx=postSI;
        if(preSI==preEI){
            return root;
        }
        while(post[postIdx]!=pre[preSI+1]){
            postIdx++;
        }
        int tnel=postIdx-postSI+1;
        root.left=construct(pre,preSI+1,preSI+tnel,post,postSI,postIdx-1);
        root.right=construct(pre,preSI+tnel+1,preEI,post,postIdx+1,postEI);
        return root;
    }

}