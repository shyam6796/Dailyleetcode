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
        if(head ==null)return head;
        Node firstNode = head;

        while(head !=null){
            Node temp = new Node(head.val);
            temp.next =head.next;
            head.next =temp;
            head =temp.next;
        }   

        head =firstNode;
        while(head != null &&  head.next !=null){
            if(head.random !=null){
                head.next.random =head.random.next;
            }
            head =head.next.next;
        }

        Node newHead =firstNode.next;
        head =firstNode;
        firstNode =newHead;

        while(head !=null){
            head.next =newHead.next;
            newHead.next =newHead.next == null ? null : newHead.next.next;
            head =head.next;
            newHead =newHead.next;
        }

        return firstNode;

    }
}