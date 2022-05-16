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
    Map<TreeNode,Set<TreeNode>> map = new HashMap<>();
    Set<TreeNode> leafNodes =new HashSet<>();
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        buildMap(root,null);
        for(TreeNode node : leafNodes){
            dfs(node,distance, new HashSet<>());
        }
        return count/2;
    }
    
    public void buildMap(TreeNode root, TreeNode parent){
        if(root ==null){
            return;
        }
        if(root.left ==null && root.right ==null){
            leafNodes.add(root);
        }
        map.putIfAbsent(root,new HashSet<>());
        if(root.left !=null) map.get(root).add(root.left);
        if(root.right !=null) map.get(root).add(root.right);
        if(parent !=null) map.get(root).add(parent);    
        
        buildMap(root.left,root);
        buildMap(root.right,root);
        
    }
    public void dfs(TreeNode leaf,int d,Set<TreeNode> visited){
        if(d <= 0)
            return;
        visited.add(leaf);
        for(var edge : map.get(leaf)){
            if(visited.contains(edge))
                continue;
            if(leafNodes.contains(edge))
                count++;
            dfs(edge,d-1,visited);
        }
    }
}