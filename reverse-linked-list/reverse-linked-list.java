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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();      
        while(head !=null){
            s.add(head.val);
            head=head.next;
        }
        ListNode temp =new ListNode(-1);
        ListNode ans =temp;
        while(!s.isEmpty()){
            temp.next=new ListNode(s.pop());
            temp=temp.next;
        }
        return ans.next;
    }
}