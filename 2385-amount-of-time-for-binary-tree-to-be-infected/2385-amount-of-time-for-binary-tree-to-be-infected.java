
import java.time.format.SignStyle;/**
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
    TreeNode startNode;
     Map<TreeNode,TreeNode> map = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
       
        BuildMap(root,null,start);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set =  new HashSet<>();
        queue.add(startNode);
        set.add(startNode);

        int steps =0;

        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i =0; i <size; i++){
                TreeNode curr =queue.poll();
                if(curr.left !=null && !set.contains(curr.left)){
                    set.add(curr.left);
                    queue.add(curr.left);
                }
                 if(curr.right !=null && !set.contains(curr.right)){
                    set.add(curr.right);
                    queue.add(curr.right);
                }
                 if(map.get(curr) !=null && !set.contains(map.get(curr))){
                    set.add(map.get(curr));
                    queue.add(map.get(curr));
                }
            }
            steps++;
        }
        return steps -1;

    }
    public void BuildMap(TreeNode root, TreeNode parent, int start){
        if(root==null)return ;
        if(root.val==start)startNode=root;
        map.put(root,parent);
        BuildMap(root.left, root, start);
        BuildMap(root.right, root, start);
    }
}