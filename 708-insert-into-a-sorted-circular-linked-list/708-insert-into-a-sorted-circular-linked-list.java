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
            head =new Node(insertVal);
            head.next= head;
            return head;
        }
        boolean doInsert =false;
        Node prev =head;
        Node curr =head.next;
        do{
            if(prev.val <= insertVal && curr.val >= insertVal){
                doInsert =true;
            }else if( prev.val > curr.val && (prev.val <=insertVal ||curr.val >= insertVal)){
                 doInsert =true;
            }
            if(doInsert){
                Node newNode =new Node(insertVal,curr);
                prev.next =newNode;
                return head;
            }
            prev =prev.next;
            curr =curr.next;
            
        }while(prev != head);
            
        if(!doInsert){
             Node newNode =new Node(insertVal,curr);
                prev.next =newNode;
                
        }
      return head;  
    }
}