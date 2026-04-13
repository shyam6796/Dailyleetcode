/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head ==null || head.next ==null)return head;
        ListNode oddNode =new ListNode(-1);
        ListNode evenNode = new ListNode(-1);
        ListNode oddHead =oddNode;
        ListNode evenHead =evenNode;

        while(head !=null){
            oddNode.next =head;
            head =head.next;
            oddNode=oddNode.next;
            if(head==null)break;
            evenNode.next=head;
            evenNode=evenNode.next;
            head =head.next;
        }
        evenNode.next= null;
        oddNode.next =evenHead.next;
        return oddHead.next;
    }
}