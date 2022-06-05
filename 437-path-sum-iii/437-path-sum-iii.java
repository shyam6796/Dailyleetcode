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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> queue =new LinkedList<>();
        helepr(root,queue);
        //System.out.println(queue);
        int size =queue.size();
        for(int i=0; i<size; i++){
            TreeNode curr=queue.poll();
            solve (curr,0,targetSum);
        }
        return count;
    }
    public void helepr(TreeNode root, Queue<TreeNode> queue){
        if(root ==null){
            return;
        }
        queue.add(root);
        helepr(root.left,queue);
        helepr(root.right,queue);
    }
    
    public void solve(TreeNode root,int sum, int targetSum){
        sum +=root.val;
        //System.out.println(sum);
       // if(targetSum >0 && sum >targetSum )return;
        //if(targetSum <0 && sum <targetSum )return;
        if(sum==targetSum){
            count++;
        }
        if(root.left !=null)solve(root.left,sum,targetSum);
        if(root.right !=null)solve(root.right,sum,targetSum);
    }
}