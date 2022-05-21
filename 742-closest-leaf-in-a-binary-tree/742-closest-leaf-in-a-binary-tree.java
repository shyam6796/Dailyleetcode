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
    public int findClosestLeaf(TreeNode root, int k) {
        Queue<TreeNode> queue =new LinkedList<>();
        Map<TreeNode,List<TreeNode>> map =new HashMap<>();
        Set<TreeNode> set =new HashSet<>();
        buildGraph(root,null,map,k,queue);
        set.add(queue.peek());
        
        while(!queue.isEmpty()){
            TreeNode curr =queue.poll();
            if(curr !=null){
                if(map.get(curr).size() <=1){
                return curr.val;
            }
            for(TreeNode n :map.get(curr)){
                if(!set.contains(n)){
                    queue.add(n);
                    set.add(n);
                }
            }
            }
        }
        return 0;
    }
    
    public void buildGraph(TreeNode root, TreeNode parent, Map<TreeNode,List<TreeNode>> map, int k, Queue<TreeNode> queue){
        if(root !=null){
            if(!map.containsKey(root)) map.put(root,new ArrayList<>());
            if(!map.containsKey(parent)) map.put(parent, new ArrayList<>());
            map.get(root).add(parent);
            map.get(parent).add(root);
            buildGraph(root.left,root,map,k,queue);
            buildGraph(root.right,root,map,k,queue);
            
            if(root.val ==k){
                queue.add(root);
            }
        }
    }
}