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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList();
        int width =0;
        queue.add(new Pair(root,0));

        while(!queue.isEmpty()){
            int size =queue.size();
            int low = queue.peek().getValue();
            int val =low;
            for(int i =0; i < size; i++){
                root = queue.peek().getKey();
                val =queue.poll().getValue();
                if(root.left !=null) queue.add(new Pair(root.left, 2*val));
                if(root.right !=null) queue.add(new Pair(root.right, 2*val+1));
            }
            width = Math.max(width,val -low+1);
        }
        return width;
    }
}