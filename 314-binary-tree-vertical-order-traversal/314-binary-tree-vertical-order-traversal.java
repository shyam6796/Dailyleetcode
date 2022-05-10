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
    class Node {
        TreeNode node;
        int col;
        
        public Node (TreeNode node, int col){
            this.node=node;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer,List<Integer>> map =new TreeMap<>();
        List<List<Integer>> list =new ArrayList<>();
        if(root==null) return list;
        Queue<Node> queue =new LinkedList<>();
        queue.add(new Node(root,0));
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
                Node curr =queue.poll();
                root =curr.node;
                if(!map.containsKey(curr.col)){
                    map.put(curr.col,new ArrayList<>());
                }
                map.get(curr.col).add(root.val);
                if(root.left !=null){
                    queue.add(new Node(root.left,curr.col-1));
                }
                if(root.right !=null){
                    queue.add(new Node(root.right,curr.col+1));
                }
            }
        }
        
        for(int i :map.keySet()){
            list.add(map.get(i));
            
        }
        
        return list;
    }
}