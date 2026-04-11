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
        if(root==null || targetSum ==0)return list;
        helper(list,new ArrayList<>(),  root,targetSum,0);
        return list;
    }

    public void helper(List<List<Integer>> list, List<Integer> ans , TreeNode root, int target, int sum){
        if(root.left ==null && root.right ==null){
            if(root.val + sum ==target){
                ans.add(root.val);
                list.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
            }
            return ;
        }
        ans.add(root.val);
        sum +=root.val;
        
        if(root.left !=null)helper(list, ans, root.left, target, sum);
        if(root.right !=null)helper(list, ans, root.right, target, sum);

        ans.remove(ans.size()-1);
        
    }
}