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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();        
        Map<TreeNode,TreeNode> map =new HashMap<>();
        
        map.put(root,null);
        mapBuilder(root,map);
       
        
        Queue<TreeNode> queue =new LinkedList<>();
        Set<TreeNode> set= new HashSet<>();
        set.add(target);
        queue.add(target);
        
        int lvl=0;
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr=queue.poll();
                if(lvl ==k){
                    list.add(curr.val);
                }
                if(curr.left != null && !set.contains(curr.left)){
                    queue.add(curr.left);
                     set.add(curr.left);
                }
                if(curr.right != null && !set.contains(curr.right)){
                    queue.add(curr.right);
                     set.add(curr.right);
                }
                if(map.get(curr) !=null && !set.contains(map.get(curr))){
                    queue.add(map.get(curr));
                     set.add(map.get(curr));
                }
                
            }
            lvl++;
            if(lvl >k) break;
        }
        
        //System.out.println(map);
        return list;

    }
    public void mapBuilder(TreeNode root,Map<TreeNode,TreeNode> map){
        if(root.left !=null){
            map.put(root.left,root);
            mapBuilder(root.left,map);
        }
        if(root.right !=null){
            map.put(root.right,root);
            mapBuilder(root.right,map);
        }
    }
}