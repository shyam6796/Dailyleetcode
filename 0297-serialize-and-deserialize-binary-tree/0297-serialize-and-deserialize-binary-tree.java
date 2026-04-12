/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    StringBuilder sb =new StringBuilder();
    helper(sb,root);
    return sb.toString();        
    }

    public void helper(StringBuilder sb, TreeNode root){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val +",");
        helper(sb, root.left);
        helper(sb, root.right);
    }

    // Decodes your encoded data to tree.
    int index =0;
    public TreeNode deserialize(String data) {
        String arr[] =data.split(",");
        return helper(arr);
    }
    public TreeNode helper(String []arr){
        if(index >=arr.length || arr[index].equals("null")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[index++]));
        root.left = helper(arr);
        root.right =helper(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));