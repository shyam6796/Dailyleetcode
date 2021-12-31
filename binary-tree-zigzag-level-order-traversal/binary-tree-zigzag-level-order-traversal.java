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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        int count =0;
        while(!queue.isEmpty()){
            int size =queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node =queue.poll();
                ans.add(node.val);
                if(node.left !=null)queue.add(node.left);
                 if(node.right !=null)queue.add(node.right);
            }
            if(list.size() %2==0){
                list.add(ans);
            }else{
              Collections.reverse(ans);
                list.add(ans);
            }
            count++;
        }
        return list;
    }
}