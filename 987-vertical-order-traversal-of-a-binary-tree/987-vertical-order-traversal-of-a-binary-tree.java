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
        int col;
        int row;
        
        public Node(TreeNode node, int col, int row){
            this.node =node;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        TreeMap<Integer,List<Pair<Integer,Integer>>> map  = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0,0));
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i = 0; i < size; i++){
                Node curr =queue.poll();
                TreeNode temp =curr.node;
                int col =curr.col;
                int row =curr.row;
                
                if(!map.containsKey(col)){
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(new Pair(row,temp.val));
                if(temp.left != null) queue.add(new Node(temp.left,col-1,row+1));
                if(temp.right != null) queue.add(new Node(temp.right,col+1,row+1));
            }
        }
        for(int i : map.keySet()){
            List<Pair<Integer,Integer>> pairList =map.get(i);
            Collections.sort(pairList, (a,b) -> {
                if(a.getKey() ==b.getKey()){
                    return a.getValue() -b.getValue();
                }
                return a.getKey()-b.getKey();  
            });
            
            List<Integer> ans = new ArrayList<>();
            
            for(Pair<Integer,Integer> pr : pairList){
                ans.add(pr.getValue());
            }
            list.add(ans);
        }
        return list;    
    }
}