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
    HashMap<Integer,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(map.containsKey(n)) return map.get(n);        
        if(n==1){
            list.add(new TreeNode(0));
            return list;
        }
         List<TreeNode> left =new ArrayList<>();
         List<TreeNode> right =new ArrayList<>();
           
        
        for(int i=1; i<n; i=i+2){
            
            left =  allPossibleFBT(i);
            right = allPossibleFBT(n-i-1);
            
            for(int j =0; j<left.size(); j++){
                
                for(int k =0; k<right.size(); k++){
                    TreeNode root =new TreeNode(0);
                   // System.out.println(left.get(j));
                    //System.out.println(right.get(k));
                    root.left =left.get(j);
                    root.right =right.get(k);
                    list.add(root);
                }
                
                
            }
        }
        map.put(n,list);
        
        return list;
    }
}