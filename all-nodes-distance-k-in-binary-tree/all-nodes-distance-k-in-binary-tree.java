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
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        HashSet<TreeNode> seen =new HashSet<>();
        Queue<TreeNode> queue =new LinkedList<>();
         Queue<TreeNode> queue1 =new LinkedList<>();
        queue.add(root);
        map.put(root, null);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
               TreeNode temp =queue.poll();
                if(temp ==target){
                    queue1.add(temp);
                    seen.add(temp);
                }
                if(temp.left !=null){
                    map.put(temp.left,temp);
                    queue.add(temp.left);
                }
                if(temp.right !=null){
                    map.put(temp.right,temp);
                    queue.add(temp.right);
                }
            }
        }
        if(queue1.isEmpty())return list;
         int level = 0;
       while(!queue1.isEmpty()){
                int size =queue1.size();
                for(int i=0; i<size; i++){
                   TreeNode node=queue1.poll();
                    if(level ==k){
                        list.add(node.val);
                    }
                    if(node.left !=null && !seen.contains(node.left)){
                        queue1.add(node.left);
                        seen.add(node.left);
                    }
                     if(node.right !=null && !seen.contains(node.right)){
                        queue1.add(node.right);
                        seen.add(node.right);
                    }
                    
                     if(map.get(node) !=null && !seen.contains(map.get(node))){
                        queue1.add(map.get(node));
                        seen.add(map.get(node));
                    }
                    
                  //  System.out.println(level);
                }
           if(level >k)break;
           level++;
       }
      return list;  
    }
        
}