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
class BSTIterator {
    List<Integer> list=new ArrayList<>();
    public BSTIterator(TreeNode root) {
        list= inorderTraversal(root);        
    }
    
    public int next() {
       int temp =list.remove(0);
        return temp;
    }
    
    public boolean hasNext() {
        return list.size() !=0;
    }
     public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return list;
            }
            if(root.left != null) inorderTraversal(root.left);
             list.add(root.val);
            if(root.right != null) inorderTraversal(root.right);
            
        return list;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */