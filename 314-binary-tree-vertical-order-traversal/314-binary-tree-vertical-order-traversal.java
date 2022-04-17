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
    class Node{
        TreeNode node;
        int row;
        
        public Node(TreeNode node, int row){
            this.node=node;
            this.row=row;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        
        Map<Integer,List<Integer>> map =new TreeMap<>();
        Queue<Node> queue =new LinkedList<>();
        queue.add(new Node(root,0));
        
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
                Node n =queue.poll();
                TreeNode curr =n.node;
                int row =n.row;
                if(!map.containsKey(row)){
                    map.put(row, new ArrayList<>());
                }
                map.get(row).add(curr.val);
                if(curr.left != null)queue.add(new Node(curr.left,row-1));
                if(curr.right != null)queue.add(new Node(curr.right,row+1));
            }
        }
        for(int i :map.keySet()){
            list.add(map.get(i));
        }
        return list;
    }
}