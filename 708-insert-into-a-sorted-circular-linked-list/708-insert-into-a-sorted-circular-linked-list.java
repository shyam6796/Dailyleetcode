/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head ==null){
            head =new Node(insertVal,null);
            head.next=head;
            return head;
        }
       Node prev =head;
       Node curr =head.next;
       boolean doInsert =false;
        do{
            if(prev.val <= insertVal  && insertVal <= curr.val){
                doInsert =true;
            }else if(prev.val > curr.val && (prev.val <= insertVal || insertVal <= curr.val)){
                doInsert =true;
            }
            
            if(doInsert){
                Node node =new Node(insertVal,curr);
                prev.next =node;
                return head;
            }
            prev=curr;
            curr=curr.next;
            
        }while(curr !=head);
        if(!doInsert){
                Node node =new Node(insertVal,curr);
                prev.next =node;
                
            }
        return head;
    }
}