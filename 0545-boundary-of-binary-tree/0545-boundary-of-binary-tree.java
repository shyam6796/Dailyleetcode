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
    List<Integer> list = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null)return list;
        if(!is_Leaf(root))list.add(root.val);
        leftBound(root.left);
        leavesNode(root);
        rightBound(root.right);
        return list;
    }
    public boolean is_Leaf(TreeNode root){
        if(root.left ==null && root.right==null)return true;
        return false;
    }
    public void leftBound(TreeNode root){
        if(root==null)return;
        if(is_Leaf(root))return;
        list.add(root.val);
        if(root.left ==null)leftBound(root.right);
        else leftBound(root.left);
    }

    public void leavesNode(TreeNode root){
        if(root==null)return;
        if(is_Leaf(root))list.add(root.val);
        leavesNode(root.left);
        leavesNode(root.right);
    }

     public void rightBound(TreeNode root){
        if(root==null)return;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        List<Integer> tempList =new ArrayList<>();

        while(!queue.isEmpty()){
            root =queue.poll();
            if(!is_Leaf(root))tempList.add(0,root.val);
            if(root.right !=null)queue.add(root.right);
            else if(root.left !=null)queue.add(root.left);
        }
        for(int i :tempList)list.add(i);
    }


}