/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> map =new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>list =new ArrayList<>();
        buildMap(root,null);  
        Queue<TreeNode> queue =new LinkedList<>();
        Set<TreeNode> set =new HashSet<>();
        
        queue.add(target);
        set.add(target);
        int lvl=0;
        
        while(!queue.isEmpty()){
            int size =queue.size();
           
            for(int i=0; i<size; i++){
                TreeNode curr=queue.poll();
                if(lvl==k){
                    list.add(curr.val);
                    continue;
                }
                if(map.get(curr) !=null && !set.contains(map.get(curr)) ){
                        queue.add(map.get(curr));
                        set.add(map.get(curr));
                }
                 if(curr.left !=null && !set.contains(curr.left)){
                        queue.add(curr.left);
                       set.add(curr.left);
                }
                if(curr.right !=null && !set.contains(curr.right)){
                        queue.add(curr.right);
                        set.add(curr.right);
                }
            
            }
            lvl++;
            if(lvl >k)break;
        }      
              
    return list;    
    
        
    }
    
    public void buildMap(TreeNode root, TreeNode parent){
        if(root==null)return;
        map.put(root,parent);
        buildMap(root.left,root);
        buildMap(root.right,root);
    }
}