/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max=0;
    public int diameter(Node root) {
        helper(root);
        return max;
    }
    
    public int helper(Node root){
        if(root.children.size() ==0)return 0;
        
        int maxHeight1 = 0, maxHeight2 = 0;
        List<Integer> list = new ArrayList<>();
        for(Node n :root.children){
            int height = helper(n)+1;
            if(height>maxHeight1){
                maxHeight2=maxHeight1;
                maxHeight1=height;
            }else if(height>maxHeight2){
                 maxHeight2=height;
            }
            
        }
        
        max =Math.max(maxHeight1+maxHeight2,max);
       
         return maxHeight1;
        
    } 
}