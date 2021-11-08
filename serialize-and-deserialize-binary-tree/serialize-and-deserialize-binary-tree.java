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
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }
    
    public void helperSerialize(TreeNode root, StringBuilder sb){
            
        if(root == null){
            sb.append("null,");
            return ;
        }
        sb.append(root.val+",");
        helperSerialize(root.left, sb);
        helperSerialize(root.right, sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        return  helperDeserialize(arr);
        
    }
    int index=0;
    public TreeNode helperDeserialize(String [] arr){
        if(index >= arr.length || arr[index].equals("null")){
                index++;
                return null;
        }
        TreeNode root =new TreeNode(Integer.parseInt(arr[index++]));
        root.left = helperDeserialize(arr);
        root.right = helperDeserialize(arr);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));