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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        if(root==null)return list;
        LinkedList<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr=queue.poll();
                if(curr.left !=null)queue.add(curr.left);
                if(curr.right !=null)queue.add(curr.right);                
            }
            if(!queue.isEmpty())list.add(queue.peekLast().val);
        }
        return list;
    }
}