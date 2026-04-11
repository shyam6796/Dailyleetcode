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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,root,targetSum,0,new ArrayList<>());
        return list;
    }
    public void helper(List<List<Integer>> list, TreeNode root, int target,int sum, List<Integer> ans){
        if(root==null){
            return ;
        }
       
        sum+=root.val;
        ans.add(root.val);
         if( root.left==null && root.right ==null  && sum== target){
            list.add(new ArrayList<>(ans));
          
           
        }

        helper(list, root.left, target, sum, ans);
        helper(list, root.right, target, sum, ans);
        ans.remove(ans.size()-1);

    }
}