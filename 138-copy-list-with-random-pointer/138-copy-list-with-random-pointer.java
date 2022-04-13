/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p=head;
        while(p !=null){
            Node newNode =new Node(p.val);
            newNode.next=p.next;
            p.next=newNode;
            p=newNode.next;
        }
        p =head;
         while(p !=null){
            if(p.random !=null){
                p.next.random =p.random.next;
            }else{
                 p.next.random=null;
            }
            p=p.next.next;
         }
        Node newHead=head.next;
        p=newHead;
        while(head !=null){
            head.next = head.next.next;
            newHead.next =newHead.next != null ?newHead.next.next :null;
            head =head.next;
            newHead =newHead.next;
        }
        return p;
    }
}