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
    int index=0;
    public TreeNode str2tree(String s) {
        return helper(s);
    }
    
    public TreeNode helper(String s){
        if(index >= s.length())return null;
        
        if(s.charAt(index) ==')'){
            index++;
            return null;
        }
        
        int val =getValue(s);
        TreeNode root = new TreeNode(val);
        if(index <s.length() && s.charAt(index) =='('){
            index++;
            root.left=helper(s);
        }
         if( index <s.length() && s.charAt(index) =='('){
            index++;
            root.right=helper(s);
        }
        index++;
        return root;
        
    }
    
    public int getValue(String s){
        StringBuilder sb =new StringBuilder();
        
        while(index <s.length() && s.charAt(index) !='(' && s.charAt(index) !=')'){
            sb.append(s.charAt(index));
            index++;
        }
        return Integer.valueOf(sb.toString());
    }
}